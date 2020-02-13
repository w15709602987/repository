<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: join
  Date: 2019/11/1
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>我的信息</title>
    <link rel="stylesheet" type="text/css" href="testSSMStepByStep/skin/css/base.css">
</head>
<body leftmargin="8" topmargin="8" background='testSSMStepByStep/skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
    <tr>
        <td height="26" background="testSSMStepByStep/skin/images/newlinebg3.gif">
            <table width="58%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td >
                        当前位置:我的信息>>我的信息
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form name="form2">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="2" background="testSSMStepByStep/sskin/images/tbg.gif">&nbsp;我的信息&nbsp;</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">职位：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${sessionScope.user.position}</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">姓名：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${sessionScope.user.username}</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">性别：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${sessionScope.user.gender}</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">年龄：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${sessionScope.user.age}</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${sessionScope.user.cellphone}</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">入职时间：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${sessionScope.user.initiationtime}</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">身份证号码：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${sessionScope.user.idcard}</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">状态：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">正常</td>
        </tr>

        <tr >
            <td align="right" bgcolor="#FAFAF1" >备注：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >${sessionScope.user.remarks}</td>
        </tr>

    </table>

</form>


</body>
</html>