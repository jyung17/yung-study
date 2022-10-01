package com.yung.toy.dao;

import com.yung.toy.domain.Board;
import java.util.List;

public interface BoardDao {
  int insert(Board board) throws Exception;
  Board findByNo(int no) throws Exception;
  int update(Board board) throws Exception;
  int delete(int no) throws Exception;
  List<Board> findAll() throws Exception;
}
