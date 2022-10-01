package com.yung.toy.dao;

import com.yung.toy.domain.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.Result;

public class MariaDBMemberDao implements MemberDao {
  
  Connection con;
  
  public MariaDBMemberDao(Connection con) {
    this.con = con;
  }
  
  @Override
  public int insert(Member member) throws Exception {
    return 0;
  }
  
  @Override
  public Member findByNo(int no) throws Exception {
    return null;
  }
  
  @Override
  public int update(Member member) throws Exception {
    return 0;
  }
  
  @Override
  public int delete(int no) throws Exception {
    return 0;
  }
  
  @Override
  public List<Member> findAll() throws Exception {
    try (
      PreparedStatement pstmt = con.prepareStatement(
          "select mno, name, email from app_member order by name");
      ResultSet rs = pstmt.executeQuery()){
  
      ArrayList<Member> list = new ArrayList<>();
      
      while(rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("mno"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
  
        list.add(member);
      }
      return list;
      }
  }
  
  @Override
  public Member findByEmailPassword(String email, String password) throws Exception {
    try(PreparedStatement pstmt = con.prepareStatement("select mno,name,email,cdt from app_member where email=? and pwd=sha2(?,256)");) {
      pstmt.setString(1, email);
      pstmt.setString(2, password);
      
      try(ResultSet rs = pstmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }
        Member member = new Member();
        member.setNo(rs.getInt("mno"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setCreatedDate(rs.getDate("cdt"));
        return member;
      }
    }
  }
}
