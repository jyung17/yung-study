<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: jyung
  Date: 2022/10/01
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>bitcamp 오류 페이지</title>
</head>
<body>
<h1> 실행 오류!</h1>
<pre>
  <%
    Exception e = (Exception) request.getAttribute("exception");
    if (e != null) {
      e.printStackTrace(new PrintWriter(out));
    }
  %>
</pre>

</body>
</html>
