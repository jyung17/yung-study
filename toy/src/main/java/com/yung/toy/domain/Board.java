package com.yung.toy.domain;

import java.sql.Date;

public class Board {
  private int no;
  private String title;
  private String content;
  private String password;
  private int viewCount;
  private Date createDate;
  private Member writer;
  
  @Override
  public String toString() {
    return "Board{" +
        "no=" + no +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", password='" + password + '\'' +
        ", viewCount=" + viewCount +
        ", createDate=" + createDate +
        '}';
  }
  
  public int getNo() {
    return no;
  }
  
  public void setNo(int no) {
    this.no = no;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getContent() {
    return content;
  }
  
  public void setContent(String content) {
    this.content = content;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public int getViewCount() {
    return viewCount;
  }
  
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  
  public Date getCreateDate() {
    return createDate;
  }
  
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
}
