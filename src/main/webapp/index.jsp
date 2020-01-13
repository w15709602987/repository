<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<body>
<h2>Hello World!123</h2>
<a href="/testSSMStepByStep/uu.do">123</a>
${abc}
${10+5}
<form name="index.do"action="index.jsp">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="2" background="/skin/images/tbg.gif">&nbsp;查看客户信息&nbsp;</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22" >公司名称：</td>

            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${customer.companyname}</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">公司联系人：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${customer.customername}</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">公司地址：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${customer.companyaddress}</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${customer.cellphone}</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">座机：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${customer.landline}</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">公司简介：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><p>${customer.introduction}</p></td>
        </tr>

        <tr >
            <td align="right" bgcolor="#FAFAF1" >备注：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
                ${customer.remarks}
            </td>
        </tr>
        <tr bgcolor="#FAFAF1">
            <td height="28" colspan=4 align=center>
                &nbsp;

            </td>
        </tr>
    </table>
    <input name="imageField" type="image" src="/skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />

</form>
</body>
</html>
