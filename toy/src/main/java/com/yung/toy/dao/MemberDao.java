package com.yung.toy.dao;

import com.yung.toy.domain.Member;
import java.util.List;

public interface MemberDao {
  int insert(Member member) throws Exception;
  Member findByNo(int no) throws Exception;
  int update(Member member) throws Exception;
  int delete (int no) throws Exception;
  List<Member> findAll() throws Exception;
  Member findByEmailPassword(String email, String password) throws Exception;
}
