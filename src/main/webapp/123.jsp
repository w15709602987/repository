<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2020/2/3
  Time: 15:27
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

    <br>
    <th>序号:<tb>${customer.id}</tb></th>
    <th>名字:<tb>${customer.customername}</tb></th>
    <th>公司名:<tb>${customer.companyname}</tb></th>
    <th>添加时间:<tb>${customer.addtime}</tb></th>
    <th>修改时间:<tb>${customer.modtime}</tb></th>
    <th>手机号:<tb>${customer.cellphone}</tb></th>
    <th>公司地址:<tb>${customer.companyaddress}</tb></th>
    <th>座机号:<tb>${customer.landline}</tb></th>
    <th>介绍:<tb>${customer.introduction}</tb></th>
    <th>备注:<tb>${customer.remarks}</tb></th>
    </br>
</c:forEach>
</body>
</html>
