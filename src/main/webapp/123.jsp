<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2020/1/13
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${customers}" var="customer">
    <td>id：${customer.id}</td>

</c:forEach>

</body>
</html>

</body>
</html>
