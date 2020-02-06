<%--
  Created by IntelliJ IDEA.
  User:
  Date: 2019/10/29
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>编辑客户信息</title>
    <link rel="stylesheet" type="text/css" href="/skin/css/base.css">
</head>
<script>
    function cal_words() {
        var length = document.getElementById("introduction").value.length;
        document.getElementById("num").innerHTML = length;

    }
    function updateCustomer() {
        var isupdate = window.confirm("确定修改吗？");
        if (!isupdate) {
            return false;
        }

        var companyname = document.getElementById("companyname").value;
        if (companyname.match("^[0-9]*$") != null || companyname == "") {
            alert("公司名称有误！！！(不能有数字)");
            return false;
        }

        var cellphone = document.getElementById("cellphone").value;
        if (cellphone.match("^1(3|4|5|7|8|9)\\d{9}$") == null) {
            alert("手机号格式有误！");
            return false;
        }
        var landline = document.getElementById("landline").value;
        if (landline.match("0\\d{2,3}-\\d{7,8}$") == null) {
            alert("座机号格式有误！");
            return false;
        }
    }
</script>
<body leftmargin="8" topmargin="8" background='/skin/images/allbg.gif'>

<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
    <tr>
        <td height="26" background="/skin/images/newlinebg3.gif">
            <table width="58%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td >
                        当前位置:客户信息管理>>编辑客户信息
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form name="form2" onsubmit="return updateCustomer();" action="/testSSMStepByStep/updateCustomer.do?id=${customerEdit.id}" method="post">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="2" background="/skin/images/tbg.gif">&nbsp;编辑客户信息&nbsp;</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22" >公司名称：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input value="${customerEdit.companyname}" name="companyname" id="companyname"/></td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">公司联系人：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input value="${customerEdit.customername}"name="customername" id="customername"/></td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">公司地址：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input size="60" value="${customerEdit.companyaddress}"name="companyaddress"id="companyaddress"/></td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input value="${customerEdit.cellphone}"name="cellphone" id="cellphone"/></td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">座机：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input value="${customerEdit.landline}" name="landline" id="landline"/></td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">公司简介：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><textarea rows=15 cols=130 name="introduction" id="introduction" onKeyUp="cal_words()">${customerEdit.introduction}</textarea></td>
            <div>字数：<span id="num">0</span></div>
        </tr>

        <tr >
            <td align="right" bgcolor="#FAFAF1" >备注：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
                <textarea rows=10 cols=130 name="remarks" id="remarks">${customerEdit.remarks}</textarea>
            </td>
        </tr>


        <tr bgcolor="#FAFAF1">
            <td height="28" colspan=4 align=center>
                &nbsp;
                <input type="submit" value="保存" id="submit" class="coolbg">


                <a href="/testSSMStepByStep/uu.do?pageNum=${pageNum}&&conditionName=${conditionName}&&conditionValue=${conditionValue}&&orderByMethod=${orderByMethod}"
                   class="coolbg">返回</a>

            </td>
        </tr>
    </table>

</form>


</body>
</html>
