package com.yung.toy.dao;

import com.yung.toy.domain.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MariaDBMemberDao implements MemberDao {
  private static final long serialVersionUID = 1L;
  
  Connection con;
  
  public MariaDBMemberDao(Connection con) {
    this.con = con;
  }
  
  @Override
  public int insert(Member member) throws Exception {
    try (
        PreparedStatement pstmt = con.prepareStatement(
            "insert into app_member(name, email, pwd) values(?,?, sha2(?,256))")) {
      pstmt.setString(1, member.getName());
      pstmt.setString(2, member.getEmail());
      pstmt.setString(3, member.getPassword());
  
      return pstmt.executeUpdate();
    }
  }
  
  @Override
  public Member findByNo(int no) throws Exception {
    try (
        PreparedStatement pstmt =
          con.prepareStatement("select mno,name,email,cdt from app_member where mno=" + no);
        ResultSet rs = pstmt.executeQuery()) {
    
        System.out.println(rs);
    
        if (!rs.next()) { // rs.next() ->  select 결과에서 한개의 레코드를 가져온다
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
  
  @Override
  public int update(Member member) throws Exception {
    try(PreparedStatement pstmt = con.prepareStatement("update app_member set name=?, email=?, pwd=sha2(?,256) where mno=?")) {
      pstmt.setString(1, member.getName());
      pstmt.setString(2, member.getEmail());
      pstmt.setString(3, member.getPassword());
      pstmt.setInt(4, member.getNo());

      return pstmt.executeUpdate();
    }
  }
  
  @Override
  public int delete(int no) throws Exception {
    try (PreparedStatement pstmt1 = con.prepareStatement("delete from app_board where mno=?");
        PreparedStatement pstmt2 = con.prepareStatement("delete from app_member where mno=?")) {
      //        PreparedStatement pstmt2 = con.prepareStatement("delete from app_member2 where mno=?")) { // 에러발생
    
      // 커넥션 객체를 수동 커밋 상태로 설정한다.
      con.setAutoCommit(false);
    
      // 회원이 작성한 게시글을 삭제한다.
      pstmt1.setInt(1, no);
      pstmt1.executeUpdate();
    
      // 회원을 삭제한다.
      pstmt2.setInt(1, no);
      int count = pstmt2.executeUpdate();
      // 현재까지 작업한 데이터 변경 결과를 실제 테이블에 적용해 달라고 요청한다.
      con.commit();
      return count;
    } catch (Exception e) {
      // 예외가 발생하면 마지막 커밋 상태로 돌린다.
      // => 임시 데이터베이스에 보관된 이전 작업 결과를 모두 취소한다.
      con.rollback();
      // 예외 발생 사실을 호출자에게 전달한다.
      throw e;
    } finally {
      // 삭제 작업 후 자동 커밋 상태로 전환한다.
      con.setAutoCommit(true);
    }
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
