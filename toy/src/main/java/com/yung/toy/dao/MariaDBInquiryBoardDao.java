package com.yung.toy.dao;

import com.yung.toy.domain.AttachedFile;
import com.yung.toy.domain.Inquiry;
import com.yung.toy.domain.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MariaDBInquiryBoardDao implements InquiryBoardDao {
  
  Connection con;
  
  // DAO가 사용할 의존 객체 Connection을 생성자의 파라미터로 받는다.
  public MariaDBInquiryBoardDao(Connection con) {
    this.con = con;
  }
  
  @Override
  public int insert(Inquiry inquiry) throws Exception {
    try(PreparedStatement pstmt =
        con.prepareStatement("insert into app_inquiry_board(iq_title, iq_cont, iq_type, mno) values(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        PreparedStatement pstmt2 =
            con.prepareStatement("insert into app_inquiry_file(iqf_filepath, iq_no) values(?, ?)")) {
      pstmt.setString(1, inquiry.getTitle());
      pstmt.setString(2, inquiry.getContent());
      pstmt.setString(3, inquiry.getType());
      pstmt.setInt(4, inquiry.getWriter().getNo());
      int count = pstmt.executeUpdate();
  
      try (ResultSet rs = pstmt.getGeneratedKeys()) {
        rs.next();
        inquiry.setNo(rs.getInt(1));
      }
      
      List<AttachedFile> attachedFiles = inquiry.getAttachedFiles();
      for (AttachedFile attachedFile : attachedFiles) {
        pstmt2.setString(1, attachedFile.getFilepath());
        pstmt2.setInt(2, inquiry.getNo());
        pstmt2.executeUpdate();
      }

      return count;
    }
  }
  
  @Override
  public Inquiry findByNo(int no) throws Exception {
    try(
        PreparedStatement pstmt = con.prepareStatement("select iq.iq_no, iq.iq_title, iq.iq_cont, iq.iq_type, iq.iq_cdt, iq.iq_acont, iq.iq_acdt, m.mno, m.name from app_inquiry_board iq join app_member m on iq.mno = m.mno where iq_no=" + no);
        ResultSet rs = pstmt.executeQuery()) {
  
      if (!rs.next()) {
        return null;
      }

      Inquiry inquiry = new Inquiry();
      inquiry.setNo(rs.getInt("iq_no"));
      inquiry.setTitle(rs.getString("iq_title"));
      inquiry.setContent(rs.getString("iq_cont"));
      inquiry.setType(rs.getString("iq_type"));
      inquiry.setCreatedDate(rs.getDate("iq_cdt"));
      inquiry.setQa_content(rs.getString("iq_acont"));
      inquiry.setQa_createdDate(rs.getDate("iq_acdt"));
  
      Member writer = new Member();
      writer.setNo(rs.getInt("mno"));
      writer.setName(rs.getString("name"));
  
      inquiry.setWriter(writer);
      
      return inquiry;
    }
  }
  
  @Override
  public int update(Inquiry inquiry) throws Exception {
    return 0;
  }
  
  @Override
  public int delete(int no) throws Exception {
    return 0;
  }
  
  @Override
  public List<Inquiry> findAll() throws Exception {
    try (
        PreparedStatement pstmt = con.prepareStatement(
            "select iq.iq_no, iq.iq_title, iq.iq_type, iq.iq_cdt, iq.iq_acont, iq.iq_acdt, m.mno, m.name from app_inquiry_board iq join app_member m on iq.mno = m.mno order by iq.iq_no desc;");
        ResultSet rs = pstmt.executeQuery()) {

      ArrayList<Inquiry> list = new ArrayList<>();
    
      while (rs.next()) {
        Inquiry inquiry = new Inquiry();
        inquiry.setNo(rs.getInt("iq_no"));
        inquiry.setTitle(rs.getString("iq_title"));
        inquiry.setType(rs.getString("iq_type"));
        inquiry.setCreatedDate(rs.getDate("iq_cdt"));
        inquiry.setQa_content(rs.getString("iq_acont"));
        inquiry.setQa_createdDate(rs.getDate("iq_acdt"));
      
        Member writer = new Member();
        writer.setNo(rs.getInt("mno"));
        writer.setName(rs.getString("name"));
  
        inquiry.setWriter(writer);
      
        list.add(inquiry);
      }
      return list;
    }
  }
}
