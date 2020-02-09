<%--
  Created by IntelliJ IDEA.
  User:
  Date: 2019/10/27
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>编辑角色信息</title>
    <link rel="stylesheet" type="text/css" href="/skin/css/base.css">
</head>
<script>

    function updateRole() {
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
                        当前位置:权限管理>>编辑角色
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form name="form2" onsubmit="return updateRole();" action="/testSSMStepByStep/updateRole.do?r_id=${roleEdit.r_id}" method="post">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="2" background="/skin/images/tbg.gif">&nbsp;编辑角色&nbsp;</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">角色编号：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

                ${roleEdit.r_id}

            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">角色名称：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

                <input value="${roleEdit.roleName}" name="roleName"/>

            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">状态：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="state">

                    <option value="启用"
                            <c:if test="${roleEdit.state=='启用'}">
                                selected="selected"
                            </c:if>
                    >启用</option>

                    <option value="禁用"
                            <c:if test="${roleEdit.state=='禁用'}">
                                selected="selected"
                            </c:if>
                    >禁用</option>

                </select>
            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">赋菜单资源：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

                <c:forEach var="menu" items="${roleMenuEdit}">

                    <c:if test="${menu.fatherMenuName=='顶级菜单'}">
                        <input type="checkbox" value="${menu.m_id}" name="menu"

                                <c:forEach var="r_haveid" items="${roleEdit_m_id}">
                                    <c:if test="${r_haveid.m_id==menu.m_id}">
                                        checked="checked"
                                    </c:if>
                                </c:forEach>

                        />${menu.menuName}<br/>

                        <c:set var="father" value="${menu.menuName}" scope="page"></c:set>

                        <c:forEach var="me" items="${roleMenuEdit}">
                            <c:if test="${me.fatherMenuName==father}">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="menu"  value="${me.m_id}"
                                <c:forEach var="r_haveid" items="${roleEdit_m_id}">
                                    <c:if test="${r_haveid.m_id==me.m_id}">
                                        checked="checked"
                                    </c:if>
                                </c:forEach>
                                />${me.menuName}<br/>
                            </c:if>

                        </c:forEach>
                    </c:if>
                </c:forEach>








            </td>
        </tr>

        <tr >
            <td align="right" bgcolor="#FAFAF1" >备注：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
                <textarea rows=10 cols=130 name="remarks">${roleEdit.remarks}</textarea>
            </td>
        </tr>


        <tr bgcolor="#FAFAF1">
            <td height="28" colspan=4 align=center>
                &nbsp;
                <input type="submit" value="保存" id="submit" class="coolbg">
                <a href="/testSSMStepByStep/queRole.do?pageNum=${pageNum}&&conditionName=${conditionName}&&conditionValue=${conditionValue}" class="coolbg">返回</a>

            </td>
        </tr>
    </table>

</form>


</body>
</html>
