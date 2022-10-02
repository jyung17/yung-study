package com.yung.toy.controller;

import com.yung.toy.dao.BoardDao;
import com.yung.toy.domain.Board;
import com.yung.toy.domain.Member;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/board/update")
public class BoardUpdateController extends HttpServlet {
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
      request.setCharacterEncoding("UTF-8");
      Board board = new Board();

      board.setNo(Integer.parseInt(request.getParameter("no")));
      board.setTitle(request.getParameter("title"));
      board.setContent(request.getParameter("content"));

      Member loginMember = (Member) request.getSession().getAttribute("loginMember");
      //      System.out.println(loginMember);

      //      System.out.println(boardDao.findByNo(board.getNo()).getWriter());
      //      System.out.println(boardDao.findByNo(board.getNo()).getWriter().getNo());

      if (boardDao.findByNo(board.getNo()).getWriter().getNo() != loginMember.getNo()) {
        /*
         * boardDao.findByNo(board.getNo()) ==> boardDao.findByNo(게시글번호)
         * boardDao.findByNo(board.getNo()).getWriter()
         *  => Member [no=23, name=user1, email=null, password=null, createdDate=null]
         * boardDao.findByNo(board.getNo()).getWriter().getNo()
         *  => 23
         */

        throw new Exception("게시글 작성자가 아닙니다.");
      }

      if (boardDao.update(board) == 0) {
        throw new Exception("게시글 변경 실패!");
      }

      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
