<%--
  Created by IntelliJ IDEA.
  User: Zaxap
  Date: 29.10.2024
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="user1" scope="request" class="org.chousik.weblab2.bean.User"/>
<jsp:useBean id="user2" scope="session" class="org.chousik.weblab2.bean.User"/>
<p><jsp:getProperty name="user1" property="name"/></p>
<p><jsp:getProperty name="user2" property="name"/></p>
</body>
</html>
