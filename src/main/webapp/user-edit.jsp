<%--
  Created by IntelliJ IDEA.
  User:
  Date: 2019/10/27
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>编辑用户信息</title>
    <link rel="stylesheet" type="text/css" href="/skin/css/base.css">
</head>
<script>

    function updateUse() {
        var isupdate = window.confirm("确定修改吗？");
        if (!isupdate){
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
                        当前位置:权限管理>>编辑用户
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form name="form2" onsubmit="return updateUse();" action="/testSSMStepByStep/updateUser.do?u_id=${userEdit.u_id}" method="post">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="2" background="/skin/images/tbg.gif">&nbsp;编辑用户&nbsp;</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">职位：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="position">
                    <option value="初级开发工程师"
                            <c:if test="${userEdit.position=='初级开发工程师'}">
                                selected="selected"
                            </c:if>
                    >初级开发工程师</option>
                    <option value="中级开发工程师"
                            <c:if test="${userEdit.position=='中级开发工程师'}">
                                selected="selected"
                            </c:if>
                    >中级开发工程师</option>
                    <option value="高级开发工程师"
                            <c:if test="${userEdit.position=='高级开发工程师'}">
                                selected="selected"
                            </c:if>
                    >高级开发工程师</option>
                    <option value="项目经理"
                            <c:if test="${userEdit.position=='项目经理'}">
                                selected="selected"
                            </c:if>
                    >项目经理</option>
                    <option value="其它"
                            <c:if test="${userEdit.position=='其它'}">
                                selected="selected"
                            </c:if>
                    >其它</option>
                </select>
            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">姓名：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="userName" value="${userEdit.username}"/></td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">性别：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="gender">
                    <option value="男"
                            <c:if test="${userEdit.gender=='男'}">
                                selected="selected"
                            </c:if>
                    >男</option>
                    <option value="女"
                            <c:if test="${userEdit.gender=='女'}">
                                selected="selected"
                            </c:if>
                    >女</option>
                </select>
            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">年龄：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input value="${userEdit.age}" name="age"/>
            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="cellPhone" value="${userEdit.cellphone}"/>
            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">入职时间：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="addTime" value="${userEdit.initiationtime}"/>
            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">身份证号码：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="idCard" value="${userEdit.idcard}"/>
            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">赋角色：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">


                <c:forEach var="roleEdit" items="${userRoleEdit}">
                    <input type="radio" name="role" value="${roleEdit.r_id}"
                            <c:if test="${userEdit_r_id==roleEdit.r_id}">
                                checked="checked"
                            </c:if>
                    />${roleEdit.roleName}
                </c:forEach>




            </td>
        </tr>

        <tr >
            <td align="right" bgcolor="#FAFAF1" >备注：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >

                <textarea rows=10 cols=130 name="remarks">${userEdit.remarks}</textarea>

            </td>
        </tr>


        <tr bgcolor="#FAFAF1">
            <td height="28" colspan=4 align=center>
                &nbsp;
                <input type="submit" value="保存" id="submit" class="coolbg">
                <a href="/testSSMStepByStep/queUser.do?pageNum=${pageNum}&&conditionname=${conditionname}&&conditionvalue=${conditionvalue}&&orderByMethod=${orderByMethod}" class="coolbg">返回</a>
            </td>
        </tr>
    </table>

</form>


</body>
</html>
