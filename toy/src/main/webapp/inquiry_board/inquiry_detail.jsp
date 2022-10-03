<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bitcamp</title>
</head>
<body>
<h1>1:1문의 상세 페이지</h1>


<form action='update' method="post">
  <table border='1'>
    <tr>
      <th>문의항목</th>
      <td><input name='type' type='text' value='${inquiry.type}' readonly></td>
    </tr>
    <tr>
      <th>제목</th>
      <td><input name='title' type='text' value='${inquiry.title}' readonly></td>
    </tr>
    <tr>
      <th>문의 일시</th>
      <td>${inquiry.createdDate}</td>
    </tr>
    <tr>
      <th>문의내용</th>
      <td><textarea name='content' rows='10' cols='60' readonly>${inquiry.content}</textarea></td>
    </tr>
    <tr>
      <th>답글 내용</th>
      <td><textarea name='qa_content' rows='10' cols='60' readonly>${inquiry.qa_content}</textarea></td>
    </tr>
    <tr>
      <th>답글 일시</th>
      <td>${inquiry.qa_createdDate}</td>
    </tr>
  </table>
  <p>
    <button type='submit'>변경</button>
    <a href='delete?no=${inquiry.no}'>삭제</a>
  </p>
</form>
</body>
</html>