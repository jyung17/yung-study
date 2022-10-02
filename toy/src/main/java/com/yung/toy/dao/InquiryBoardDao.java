package com.yung.toy.dao;

import com.yung.toy.domain.Inquiry;
import java.util.List;

public interface InquiryBoardDao {
  int insert(Inquiry inquiry) throws Exception;
  Inquiry findByNo(int no) throws Exception;
  int update(Inquiry inquiry) throws Exception;
  int delete(int no) throws Exception;
  List<Inquiry> findAll() throws Exception;
}
