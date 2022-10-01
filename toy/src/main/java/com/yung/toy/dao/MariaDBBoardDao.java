package com.yung.toy.dao;

import com.yung.toy.domain.Board;
import java.sql.Connection;
import java.util.List;

public class MariaDBBoardDao implements BoardDao{
  
  Connection con;
  
  public MariaDBBoardDao(Connection con) {
    this.con = con;
  }
  
  @Override
  public int insert(Board board) throws Exception {
    return 0;
  }
  
  @Override
  public Board findByNo(int no) throws Exception {
    return null;
  }
  
  @Override
  public int update(Board board) throws Exception {
    return 0;
  }
  
  @Override
  public int delete(int no) throws Exception {
    return 0;
  }
  
  @Override
  public List<Board> findAll() throws Exception {
    return null;
  }
}
