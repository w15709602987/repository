<%--
  Created by IntelliJ IDEA.
  User: Join
  Date: 2019/9/3
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>添加客户信息</title>
    <link rel="stylesheet" type="text/css" href="/skin/css/base.css">
</head>
<script>

    /*表单的onsubmit属性，在表单提交前检查表单的参数内容，若为false，则无法提交！*/
    function updateUse() {
        //    校验表单
        var customername = document.getElementById("customername").value;
        if (customername == "" || customername.trim().length == 0) {
            alert("客户名称不能为空！！！");
            return false;
        }





        //    校验手机号
        var cellphone = document.getElementById("cellphone").value;
        if (cellphone.match("^1(3|4|5|7|8|9)\\d{9}$") == null) {
            alert("手机号格式有误！");
            return false;
        }
        var cellphone = document.getElementById("cellphone");
        var cellphonevalue = cellphone.value;

        if(cellphonevalue==""||cellphonevalue.trim().length==0){
            alert("手机号码不能为空");
            return false;
        }else if(!/^[1][3,4,5,7,8][0-9]{9}$/.exec(cellphonevalue)){
            alert("输入有误，请重新输入")
            return false;
        };

        var landline = document.getElementById("landline");
        var landlinevalue = landline.value;
        if(landlinevalue==""||landlinevalue.trim().length==0){
            alert("座机号码不能为空");
            return false;

        }else if(!/0\d{2,3}-\d{7,8}/.exec(landlinevalue)){
            alert("输入有误，请重新输入")
            return false;
        }





        //验证描述
        var introduction = document.getElementById("introduction").value;
        if (introduction == "" || introduction.trim().length == 0) {
            alert("请输入正确的描述！");
            return false;
        }

        //验证提交

        var issub = confirm("确定要提交吗？");
        if (!issub) {
            return false;
        }
        return true
    }
</script>
<body leftmargin="8" topmargin="8" background='/skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
    <tr>
        <td height="26" background="/skin/images/newlinebg3.gif">
            <table width="58%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td >
                        当前位置:客户信息管理>>添加客户信息
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form name="form2" method="post" action="/testSSMStepByStep/add.do" onsubmit="return validateForm();">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="2" background="/skin/images/tbg.gif">&nbsp;添加客户&nbsp;</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">公司名称：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="companyname" id="companyname"/>
            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">公司联系人：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="customername" id="customername"/>
            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">公司地址：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="companyaddress" size="60" id="companyaddress"/>
            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="cellphone" id="cellphone"/>
            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">座机：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="landline" id="landline"/>
            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">公司简介：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <textarea rows=15 cols=130 name="introduction" id="introduction"></textarea>
            </td>
        </tr>

        <tr >
            <td align="right" bgcolor="#FAFAF1" >备注：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
                <textarea rows=10 cols=130 name="remarks" id="remarks"></textarea>
            </td>
        </tr>


        <tr bgcolor="#FAFAF1">
            <td height="28" colspan=4 align=center>
                &nbsp;
                <%--<a href="/PPManagerSystem/jsp//customer.jsp" class="coolbg">保存</a>--%>
                <input type="submit" value="保存" class="coolbg">
                <a href="/testSSMStepByStep/uu.do?pageNum=1&&conditionName=companyname&&conditionValue=&&orderByMethod=addtime" class="coolbg">返回</a>
            </td>
        </tr>
    </table>

</form>


</body>
</html>
