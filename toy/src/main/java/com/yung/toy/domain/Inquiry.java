package com.yung.toy.domain;

import java.sql.Date;
import java.util.List;

public class Inquiry {
  private int no;
  private String title;
  private String content;
  private String type;
  private Date createdDate;
  private String qa_content;
  private Date qa_createdDate;
  private Member writer;
  private List<AttachedFile> attachedFiles;
  
  
  @Override
  public String toString() {
    return "Inquriy{" +
        "no=" + no +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", type='" + type + '\'' +
        ", createdDate=" + createdDate +
        ", qa_content='" + qa_content + '\'' +
        ", qa_createdDate=" + qa_createdDate +
        ", writer=" + writer +
        ", attachedFiles=" + attachedFiles +
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
  
  public String getType() {
    return type;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public Date getCreatedDate() {
    return createdDate;
  }
  
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  
  public String getQa_content() {
    return qa_content;
  }
  
  public void setQa_content(String qa_content) {
    this.qa_content = qa_content;
  }
  
  public Date getQa_createdDate() {
    return qa_createdDate;
  }
  
  public void setQa_createdDate(Date qa_createdDate) {
    this.qa_createdDate = qa_createdDate;
  }
  
  public Member getWriter() {
    return writer;
  }
  
  public void setWriter(Member writer) {
    this.writer = writer;
  }
  
  public List<AttachedFile> getAttachedFiles() {
    return attachedFiles;
  }
  
  public void setAttachedFiles(List<AttachedFile> attachedFiles) {
    this.attachedFiles = attachedFiles;
  }
}
