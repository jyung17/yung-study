package com.yung.toy.controller;

import com.yung.toy.dao.InquiryBoardDao;
import com.yung.toy.domain.AttachedFile;
import com.yung.toy.domain.Inquiry;
import com.yung.toy.domain.Member;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/inquiry/inquiry_add")
public class InquiryBoardAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  InquiryBoardDao inquiryBoardDao;

  @Override
  public void init() {
    inquiryBoardDao = (InquiryBoardDao) this.getServletContext().getAttribute("inquiryboardDao");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
  
      DiskFileItemFactory factory = new DiskFileItemFactory();
      ServletFileUpload upload = new ServletFileUpload(factory);
      List<FileItem> items = upload.parseRequest(request);
      
      Inquiry inquiry = new Inquiry();
      List<AttachedFile> attachedFiles = new ArrayList<>();
  
      for (FileItem item : items) {
        if (item.isFormField()) { // 일반 입력 값이라
          String paramName = item.getFieldName(); //
          String paramValue = item.getString("UTF-8");
          System.out.println("getFieldName : getString = " + paramName + " : " + paramValue);
  
          switch (paramName) {
            case "type" :
              inquiry.setType(paramValue);
            case "title":
              inquiry.setTitle(paramValue);
            case "content":
              inquiry.setContent(paramValue);
          }
  
        } else {
          String filename = UUID.randomUUID().toString();
          attachedFiles.add(new AttachedFile(filename));
  
          String dirPath = request.getServletContext().getRealPath("/inquiry_board/files");
          System.out.println(dirPath + "/" + filename);
  
          item.write(new File(dirPath + "/" + filename));
        }
      }

      inquiry.setAttachedFiles(attachedFiles);
  
      Member loginMember = (Member) request.getSession().getAttribute("loginMember");
      inquiry.setWriter(loginMember);
  
      if (inquiryBoardDao.insert(inquiry) == 0) {
        throw new Exception("1:1문의 게시글 등록 실패!");
      }
      
      response.sendRedirect("inquiry_list");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
