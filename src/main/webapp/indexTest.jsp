<%--
  Created by IntelliJ IDEA.
  User:
  Date: 2019/9/7
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>项目平台管理系统</title>
    <style>
        body
        {
            scrollbar-base-color:#C0D586;
            scrollbar-arrow-color:#FFFFFF;
            scrollbar-shadow-color:#DEEFC6;
        }
    </style>
</head>
<frameset rows="60,*" cols="*" frameborder="no" border="0" framespacing="0">
    <frame src="/testSSMStepByStep/top.jsp" name="topFrame" scrolling="no">
    <frameset cols="180,*" name="btFrame" frameborder="NO" border="0" framespacing="0">
        <frame src="/testSSMStepByStep/meanTest.jsp" noresize name="menu" scrolling="yes">
        <frame src="/testSSMStepByStep/main.jsp" noresize name="main" scrolling="yes">
    </frameset>
</frameset>
<noframes>
    <body>您的浏览器不支持框架！</body>
</noframes>
</html>
