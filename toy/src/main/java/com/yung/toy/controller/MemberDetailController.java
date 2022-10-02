package com.yung.toy.controller;

import com.yung.toy.dao.MemberDao;
import com.yung.toy.domain.Member;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/detail")
public class MemberDetailController extends HttpServlet {
  MemberDao memberDao;
  
  @Override
  public void init() {
    memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  
    int memberNo = Integer.parseInt(request.getParameter("no"));
    
    try {
      Member member = memberDao.findByNo(memberNo);
  
      if (member == null) {
        throw new Exception("사용자 조회 실패!");
      }
      
      request.setAttribute("member", member);
      response.setContentType("text/html; charset=UTF-8");
      request.getRequestDispatcher("/member/inquiry_detail.jsp").include(request, response);
      
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
