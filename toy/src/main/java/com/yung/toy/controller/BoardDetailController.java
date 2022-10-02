package com.yung.toy.controller;

import com.yung.toy.dao.BoardDao;
import com.yung.toy.domain.Board;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/detail")
public class BoardDetailController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  BoardDao boardDao;

  @Override
  public void init() {
    boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    int boardNo = Integer.parseInt(request.getParameter("no"));

    try {
      Board board = boardDao.findByNo(boardNo);

      if (board == null) {
        throw new Exception("게시글 조회 실패!");
      }

      request.setAttribute("board", board);
      response.setContentType("text/html; charset=UTF-8");
      request.getRequestDispatcher("/board/inquiry_detail.jsp").include(request, response);

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
