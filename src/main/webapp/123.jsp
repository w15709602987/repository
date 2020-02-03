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

<form name="form2" action="/project/delCustomer" method="post" onsubmit="return delAll();">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="12" background="/skin/images/tbg.gif">&nbsp;客户信息列表&nbsp;</td>
        </tr>
        <tr align="center" bgcolor="#FAFAF1" height="22">
            <td width="6%">序号</td>
            <td width="10%">联系人</td>
            <td width="10%">公司名称</td>
            <td width="8%">添加时间</td>
            <td width="8%">联系电话</td>

    <c:forEach items="${customers}" var="customer">
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
            <td name="xuhao">${customer.id}</td>
            <td>${customer.customername}</td>
            <td align="center">${customer.companyname}</td>
            <td>${customer.addtime}</td>
            <td>${customer.cellphone}</td>
        </tr>
    </c:forEach>
    </table>
</form>

</body>
</html>

</body>
</html>
