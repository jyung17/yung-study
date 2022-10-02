package com.yung.toy.controller;

import com.yung.toy.dao.BoardDao;
import com.yung.toy.domain.AttachedFile;
import com.yung.toy.domain.Board;
import com.yung.toy.domain.Member;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/board/add")
public class BoardAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  BoardDao boardDao;

  @Override
  public void init() {
    boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      // URL 디코딩 한 바이트를 UTF-16으로 변환하기 전에
      // 그 바이트의 characterset이 무엇인지 알려줘야 한다.
      // 안 알려주면 그 디코딩 바이트가 ASCII 코드라고 간주한다.
      // UTF-8 코드를 ASCII 코드라고 잘못 판단하니까 UTF-16으로 바꿀 때 오류가 발생하는 것이다.
      // 물론 영어나 숫자는 ASCII 코드와 UTF-8이 같기 때문에 UTF-16으로 변환하더라도 문제가 되지 않는다.
      // 그러나 한글은 UTF-8 코드의 3바이트를 묶어서 UTF-16 2바이트로 변환해야 하는데,
      // 영어라고 간주하고 각각의 1바이트를 2바이트로 변환하니까 문제가 발생하는 것이다.

      // getParameter()를 최초로 호출하기 전에 먼저 실행
      // 단 한번이라도 호출한 후에 실행하면 무효하다.
      //       request.setCharacterEncoding("UTF-8");

      //multiparg/form-data 형식으로 요청한 데이터에 대해서는
      // 다음과 같이 요청 데이터의 인코딩을 지정할 수 없다.
      //       request.setCharacterEncoding("UTF-8");

      // 멀티파트 데이터 처리하기
      // 1) 클라이언트가 보낸 멀티파트 데이터를 임시 보관할 객체 준비
      //  - 임시 폴더에 저장한다.
      DiskFileItemFactory factory = new DiskFileItemFactory(); // FileSystem(HDD(SSD)) 임시 폴더에 저장한다.

      // 2) 멀티파트 데이터를 분석할 객체 준비
      //  - 멀티파트 데이터를 파트 별로 쪼개서 이름과 데이터를 분리하여
      // DiskFileItemFactory를 이용하여 임시 폴더에 저장한다.
      ServletFileUpload upload = new ServletFileUpload(factory);

      // 3) HttpServletRequest 객체를 통해 데이터를 읽어서 멀티파트 데이터를 처리한다.
      // - 각각의 파트 정보는 FileItem 객체에 담긴다.
      // - 그 FileItem 객체들을 List에 담아 리턴한다.
      // - 물론 업로드 된 파일의 데이터는 DiskFileItemFactory에서 관리하고 있다.
      List<FileItem> items = upload.parseRequest(request);

      // 클라이언트가 멀티파트로 보낸 데이터를 저장할 도메인 객체를 준비한다.
      Board board = new Board();

      // 첨부파일명을 저장할 컬렉션 객체 준비
      List<AttachedFile> attachedFiles = new ArrayList<>();

      // 각 파트의 데이터를 꺼내 Board 객체에 담는다.
      for (FileItem item : items) {
        if (item.isFormField()) { // 일반 입력 값이라
          String paramName = item.getFieldName(); // 
          String paramValue = item.getString("UTF-8");
          System.out.println("getFieldName : getString = " + paramName + " : " + paramValue);

          switch (paramName) {
            case "title":
              board.setTitle(paramValue);
            case "content":
              board.setContent(paramValue);
          }

        } else { // 파일이라면
          // 다른 클라이언트가 보낸 파일명과 중복되지 않도록 임의의 새 파일명을 생성한다.
          String filename = UUID.randomUUID().toString();

          // 파일이름을 AttachedFile 객체에 담은 후
          // DB에 저장할 수 있도록 컬렉션에 저장한다.
          //          AttachedFile attachedFile = new AttachedFile(filename);
          //          attachedFiles.add(attachedFile);
          attachedFiles.add(new AttachedFile(filename));

          // 임시 폴더에 저장된 파일을 옮길 폴더 경로 알아내기
          String dirPath = request.getServletContext().getRealPath("/board/files");
          System.out.println(dirPath + "/" + filename);

          // FileItem 객체가 가리키는 임시폴더에 저장된 파일을 
          // 우리가 지정한 디렉토리로 옮긴다.
          // 이때 파일명은 원래의 이름 대신 우리가 UUID로 생성한 이름을 사용한다.
          item.write(new File(dirPath + "/" + filename));
        }
      }

      // Board 객체에 파일명 목록을 담고 있는 컬랙션 객체를 저장한다.
      board.setAttachedFiles(attachedFiles);

      Member loginMember = (Member) request.getSession().getAttribute("loginMember");
      board.setWriter(loginMember);

      if (boardDao.insert(board) == 0) {
        throw new Exception("게시글 등록 실패!");
      }

      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
