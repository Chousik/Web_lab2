<%--
  Created by IntelliJ IDEA.
  User: Zaxap
  Date: 29.10.2024
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
  <jsp:useBean id="user1" scope="request" class="org.chousik.weblab2.bean.User"/>
  <jsp:useBean id="user2" scope="session" class="org.chousik.weblab2.bean.User"/>
  <jsp:setProperty name="user1" property="name" value="Zahar1"/>
  <jsp:setProperty name="user2" property="name" value="Zahar2"/>
  <%@ page import="org.jboss.logging.Logger" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <p><jsp:getProperty name="user1" property="name"/></p>
    <p><jsp:getProperty name="user2" property="name"/></p>
    <p>${user1.name}</p>
</body>
</html>
