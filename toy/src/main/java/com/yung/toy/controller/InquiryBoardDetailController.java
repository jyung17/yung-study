package com.yung.toy.controller;

import com.yung.toy.dao.InquiryBoardDao;
import com.yung.toy.domain.Inquiry;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inquiry/inquiry_detail")
public class InquiryBoardDetailController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  InquiryBoardDao inquiryBoardDao;

  @Override
  public void init() {
    inquiryBoardDao = (InquiryBoardDao) this.getServletContext().getAttribute("inquiryboardDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  
    int inquiryNo = Integer.parseInt(request.getParameter("no"));
    
    try {
      Inquiry inquiry = inquiryBoardDao.findByNo(inquiryNo);
      System.out.println(inquiry);
      
      if(inquiry == null) {
        throw new Exception("1:1문의 게시글 조회 실패!");
      }

      request.setAttribute("inquiry", inquiry);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/inquiry_board/inquiry_detail.jsp").include(request, response);

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
