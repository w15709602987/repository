<%--<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<body>--%>
<%--<h2>Hello World!123</h2>--%>
<%--<a href="/testSSMStepByStep/uu.do?pageNum=1&&conditionName=companyname&&conditionValue=&&orderByMethod=addtime">Customer</a>--%>
<%--<a href="/testSSMStepByStep/queMenu.do?pageNum=1&&conditionName=menuname&&conditionValue=">Menu</a>--%>
<%--<a href="/testSSMStepByStep/queRole.do?pageNum=1&&conditionName=roleName&&conditionValue=">Role</a>--%>
<%--<a href="/testSSMStepByStep/test.do";>test</a>--%>
<%--<a href="/testSSMStepByStep/queUser.do?pageNum=1&&conditionName=username&&conditionValue=&&orderByMethod=initiationtime">User</a>--%>
<%--<a href="/testSSMStepByStep/login.jsp">login</a>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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