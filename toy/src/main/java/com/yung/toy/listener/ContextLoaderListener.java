package com.yung.toy.listener;

import com.yung.toy.dao.MariaDBBoardDao;
import com.yung.toy.dao.MariaDBInquiryBoardDao;
import com.yung.toy.dao.MariaDBMemberDao;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
  
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("공유 자원을 준비 중!!");
  
    try {
      Class.forName("org.mariadb.jdbc.Driver");
      Connection con =
          DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      
      ServletContext ctx = sce.getServletContext();
      ctx.setAttribute("boardDao", new MariaDBBoardDao(con));
      ctx.setAttribute("inquiryboardDao", new MariaDBInquiryBoardDao(con));
      ctx.setAttribute("memberDao", new MariaDBMemberDao(con));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
