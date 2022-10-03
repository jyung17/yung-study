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

@WebServlet("/member/list")
public class MemberListController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  MemberDao memberDao;
  
  @Override
  public void init() {
    memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      List<Member> members = memberDao.findAll();
      request.setAttribute("members", members);
      response.setContentType("text/html; charset=UTF-8");
      request.getRequestDispatcher("/member/inquiry_list.jsp").include(request, response);
      
    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
