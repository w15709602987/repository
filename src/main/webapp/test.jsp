<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2020/2/11
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="form1" action="/testSSMStepByStep/deltest.do" method="post">
<c:forEach var="test" items="${test}">
    <tr>
        <td><input type="checkbox" name="tid" value="${test.tid}"></td>
        <td>${test.tid}</td>
        <td>${test.suibian}</td>
        <td>${test.ttest}</td>
    </tr>
</c:forEach>
    <input type="submit" value="删除" class="coolbg">
</form>
</body>
</html>
