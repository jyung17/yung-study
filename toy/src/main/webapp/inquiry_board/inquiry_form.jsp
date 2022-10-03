<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>bitcamp</title>
</head>

<body>
<h1>1:1문의하기 페이지</h1>


<form action='inquiry_add' method="post" enctype="multipart/form-data">
    <table border='1'>
        <tr>
            <th>문의항목</th>
            <td><input name='type' type='text'></td>
        </tr>
        <tr>
            <th>제목</th>
            <td><input name='title' type='text'></td>
        </tr>
        <tr>
            <th>문의내용</th>
            <td><textarea name='content' rows='10' cols='60'></textarea></td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td><input name='files' type="file" multiple></td>
        </tr>
    </table>
    <p>
        <button type='submit'>문의하기</button>
        <a href='inquiry_list'>목록</a>
    </p>
</form>

</body>
</html>