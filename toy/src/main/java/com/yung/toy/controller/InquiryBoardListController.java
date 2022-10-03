package com.yung.toy.controller;

import com.yung.toy.dao.InquiryBoardDao;
import com.yung.toy.domain.Board;
import com.yung.toy.domain.Inquiry;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inquiry/inquiry_list")
public class InquiryBoardListController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  InquiryBoardDao inquiryBoardDao;

  @Override
  public void init() {
    inquiryBoardDao = (InquiryBoardDao) this.getServletContext().getAttribute("inquiryboardDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {

      List<Inquiry> inquiries = inquiryBoardDao.findAll();
      request.setAttribute("inquiries", inquiries);

      response.setContentType("text/html;charset=UTF-8");
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/inquiry_board/inquiry_list.jsp");
      요청배달자.include(request, response);

    } catch (Exception e) {
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error.jsp");
      request.setAttribute("exception", e);
      요청배달자.forward(request, response);
    }
  }
}
