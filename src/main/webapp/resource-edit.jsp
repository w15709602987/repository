<%--
  Created by IntelliJ IDEA.
  User:
  Date: 2019/10/27
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>编辑菜单资源</title>
    <link rel="stylesheet" type="text/css" href="/skin/css/base.css">
</head>
<script>

    function updateMenu() {
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
                        当前位置:权限管理>>编辑菜单资源
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form name="form2"onsubmit="return updateMenu();" action="/testSSMStepByStep/updateMenu.do?m_id=${menuEdit.m_id}" method="post">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="2" background="/skin/images/tbg.gif">&nbsp;编辑菜单资源&nbsp;</td>
        </tr>

        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">菜单资源编号：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                ${menuEdit.m_id}
            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">菜单资源名称：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input value=" ${menuEdit.menuName}" name="menuName"/>
            </td>
        </tr>

        <tr >





            <td align="right" bgcolor="#FAFAF1" height="22">父菜单：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="fatherMenuName">


                    <option value="顶级菜单">顶级菜单</option>
                    <c:forEach var="menu" items="${MenuEditAll}">
                        <c:if test="${menu.fatherMenuName=='顶级菜单'}">
                            <option value="${menu.menuName}"

                                    <c:if  test="${menuEdit.fatherMenuName==menu.menuName}">
                                        selected="selected"
                                    </c:if>
                            >
                                    ${menu.menuName}
                            </option>
                        </c:if>
                    </c:forEach>


                </select>
            </td>


        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">菜单资源路径：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input value="${menuEdit.menuPath}" name="menuPath"/>
            </td>
        </tr>

        <tr >
            <td align="right" bgcolor="#FAFAF1" >备注：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
                <textarea rows=10 cols=130 name="remarks">
                    ${menuEdit.remarks}

                </textarea>
            </td>
        </tr>



        <tr bgcolor="#FAFAF1">
            <td height="28" colspan=4 align=center>
                &nbsp;
                <input type="submit" value="保存" id="submit" class="coolbg">
                <a href="/testSSMStepByStep/queMenu.do?pageNum=${pageNum}&&conditionName=${conditionName}&&conditionValue=${conditionValue}" class="coolbg">返回</a>

            </td>
        </tr>
    </table>

</form>


</body>
</html>
