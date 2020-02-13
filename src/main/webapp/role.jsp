<%--
  Created by IntelliJ IDEA.
  User:
  Date: 2019/10/27
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>角色管理</title>
    <link rel="stylesheet" type="text/css" href="/testSSMStepByStep/skin/css/base.css">
</head>

<script>

    function delAll() {
        var arrs = document.getElementsByName("id");
        var judge = false;
        for (var i = 0;i<arrs.length;i++){
            if (arrs[i].checked==true){
                judge = true;
                break;
            }
        }

        if (judge==false){
            alert("请选择至少一条数据！");
            return false;
        }else {
            var isconfirm = window.confirm("你确定要禁用你选中的角色吗？");
            if (!isconfirm){
                return false;
            }
        }

    }

    function checkAll() {
        var arrs = document.getElementsByName("id");
        for(var i = 0;i<arrs.length;i++){
            arrs[i].checked = true;
        }
    }
    function nocheckAll() {
        var arrs = document.getElementsByName("id");
        for(var i = 0;i<arrs.length;i++){
            arrs[i].checked = false;
        }
    }

    window.onload = function () {

        var arrs = document.getElementsByName("xuhao");
        for (var i = 0;i<arrs.length;i++){
            arrs[i].innerText = ${pageBeanRole.pageNum}*6-5+i;
        }

    }

    function delRoleOne(id) {
        var isconfirm = window.confirm("您确定要删除这个角色吗？");
        if (isconfirm){
            window.location.href = "/testSSMStepByStep/delRole.do?id="+id;
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
                        当前位置:权限管理>>角色管理
                    </td>
                    <td>
                        <input type='button' class="coolbg np" onClick="location='/testSSMStepByStep/queMenuAndtoRoleAddjsp.do'" value='添加角色' />
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<form name='form3' action="/testSSMStepByStep/queRole.do?pageNum=1" method="post">
    <input type='hidden' name='dopost' value='' />
    <table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
        <tr bgcolor='#EEF4EA'>
            <td background='/skin/images/wbg.gif' align='center'>
                <table border='0' cellpadding='0' cellspacing='0'>
                    <tr>
                        <td width='90' align='center'>搜索条件：</td>
                        <td width='160'>
                            <select name='conditionName' style='width:150px'>
                                <option value='roleName'
                                        <c:if test="${pageBeanRole.conditionName=='roleName'}">
                                            selected="selected"
                                        </c:if>
                                >角色名称</option>
                                <option value='r_id'
                                        <c:if test="${pageBeanRole.conditionName=='r_id'}">
                                            selected="selected"
                                        </c:if>
                                >角色编号</option>
                            </select>
                        </td>
                        <td width='70'>
                            关键字：
                        </td>
                        <td width='160'>
                            <input type='text' name='conditionValue'  style='width:120px'value="${pageBeanRole.conditionValue}" />
                        </td>
                        <td>
                            &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" src="/skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>


<form name="form2" action="/testSSMStepByStep/banRoleState.do" method="post" onsubmit="return delAll();">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="12" background="/skin/images/tbg.gif">&nbsp;角色列表&nbsp;</td>
        </tr>
        <tr align="center" bgcolor="#FAFAF1" height="22">
            <td width="4%">选择</td>
            <td width="6%">序号</td>
            <td width="10%">角色编号</td>
            <td width="10%">角色名称</td>
            <td width="8%">状态</td>
            <td width="10%">操作</td>
        </tr>


        <c:forEach var="role" items="${pageBeanRole.list}">
            <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
                <td><input name="id" type="checkbox" value="${role.r_id}"  class="np"></td>
                <td name="xuhao"></td>
                <td>${role.r_id}</td>
                <td align="center">${role.roleName}</td>
                <td>${role.state}</td>

                <td>
                    <a href="javascript:delRoleOne('${role.r_id}')">删除</a> |

                    <a href="/testSSMStepByStep/RoleEdit.do?id=${role.r_id}">编辑</a> |

                    <a href="/testSSMStepByStep/roleShow.do?id=${role.r_id}">查看详情</a>
                </td>
            </tr>
        </c:forEach>

        <tr bgcolor="#FAFAF1">
            <td height="28" colspan="12">
                &nbsp;
                <input type="button"  onclick="checkAll();" value="全选">
                <input type="button"  onclick="nocheckAll();" value="反选">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="禁用" class="coolbg">


            </td>
        </tr>
        <tr align="right" bgcolor="#EEF4EA">
            <td height="36" colspan="12" align="center">




                <c:if test="${pageBeanRole.pageNum!=1}">
                    <a  href="/testSSMStepByStep/queRole.do?pageNum=1&&conditionValue=${pageBeanRole.conditionValue}
                    &&conditionName=${pageBeanRole.conditionName}">首页</a>
                    <a  href="/testSSMStepByStep/queRole.do?pageNum=${pageBeanRole.pageNum-1}&&conditionValue=${pageBeanRole.conditionValue}
                    &&conditionName=${pageBeanRole.conditionName}">上一页</a>
                </c:if>

                <c:forEach begin="${pageBeanRole.pageNum-5>0?(pageBeanRole.pageNum-5):1}"
                           end="${pageBeanRole.pageNum+4<=pageBeanRole.totalPageNume?(pageBeanRole.pageNum+4):pageBeanRole.totalPageNume}"
                           step="1" var="i">

                    <c:if test="${pageBeanRole.pageNum==i}">
                        ${i}
                    </c:if>
                    <c:if test="${pageBeanRole.pageNum!=i}">
                        <span><a href="/testSSMStepByStep/queRole.do?pageNum=${i}&&conditionValue=${pageBeanRole.conditionValue}
                    &&conditionName=${pageBeanRole.conditionName}">${i}</a></span>
                    </c:if>
                </c:forEach>


                <c:if test="${pageBeanRole.pageNum!=pageBeanRole.totalPageNume}">
                    <a  href="/testSSMStepByStep/queRole.do?pageNum=${pageBeanRole.pageNum+1}&&conditionValue=${pageBeanRole.conditionValue}
                    &&conditionName=${pageBeanRole.conditionName}">下一页</a>
                    <a  href="/testSSMStepByStep/queRole.do?pageNum=${pageBeanRole.totalPageNume}&&conditionValue=${pageBeanRole.conditionValue}
                    &&conditionName=${pageBeanRole.conditionName}">尾页</a>
                </c:if>











            </td>
        </tr>
    </table>

</form>


</body>
</html>
