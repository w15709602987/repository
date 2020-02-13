<%--
  Created by IntelliJ IDEA.
  User:
  Date: 2019/10/27
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>菜单资源管理</title>
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

        var arrs = document.getElementsByName("xuhao");//当前页只有5个序号！！！
        for (var i = 0;i<arrs.length;i++){
            arrs[i].innerText = ${pageBeanMenu.pageNum}*6-5+i;
        }

    }

    function delMenuOne(id) {
        var isconfirm = window.confirm("您确定要删除这个菜单资源吗？");
        if (isconfirm){
            window.location.href = "/testSSMStepByStep/delMenu.do?id="+id;
        }
    }
</script>
<body leftmargin="8" topmargin="8" background='/testSSMStepByStep/skin/images/allbg.gif'>

<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
    <tr>
        <td height="26" background="/testSSMStepByStep/skin/images/newlinebg3.gif">
            <table width="58%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td >
                        当前位置:权限管理>>菜单资源管理
                    </td>
                    <td>
                        <input type='button' class="coolbg np" onClick="location='/testSSMStepByStep/queFatherMenuAndtoMenuAddjsp.do'" value='添加菜单资源' />
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form name='form3' action="/testSSMStepByStep/queMenu.do?pageNum=1" method="post">
    <input type='hidden' name='dopost' value='' />
    <table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
        <tr bgcolor='#EEF4EA'>
            <td background='/testSSMStepByStep/skin/images/wbg.gif' align='center'>
                <table border='0' cellpadding='0' cellspacing='0'>
                    <tr>
                        <td width='90' align='center'>搜索条件：</td>
                        <td width='160'>
                            <select name='conditionName' style='width:150px'>
                                <option value='menuname'
                                        <c:if test="${pageBeanMenu.conditionName=='menuname'}">
                                            selected="selected"
                                        </c:if>
                                >菜单资源名称</option>
                                <option value='m_id'
                                        <c:if test="${pageBeanMenu.conditionName=='m_id'}">
                                            selected="selected"
                                        </c:if>
                                >菜单资源编号</option>

                            </select>
                        </td>
                        <td width='70'>
                            关键字：
                        </td>
                        <td width='160'>
                            <input type='text' name='conditionValue' value='${pageBeanMenu.conditionValue}' style='width:120px' />
                        </td>
                        <td>
                            &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" src="/testSSMStepByStep/skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>

<form name="form2" action="/testSSMStepByStep/banMenuState.do" method="post" onsubmit="return delAll();">


    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="12" background="/testSSMStepByStep/skin/images/tbg.gif">&nbsp;菜单资源列表&nbsp;</td>
        </tr>
        <tr align="center" bgcolor="#FAFAF1" height="22">
            <td width="4%">选择</td>
            <td width="6%">序号</td>
            <td width="10%">菜单资源编号</td>
            <td width="10%">菜单资源名称</td>
            <td width="10%">父菜单</td>
            <td width="10%">菜单资源路径</td>
            <td width="8%">状态</td>
            <td width="10%">操作</td>
        </tr>

        <c:forEach var="menu" items="${pageBeanMenu.list}">
            <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
                <td><input name="id" type="checkbox" value="${menu.m_id}"  class="np"></td>
                <td name="xuhao"></td>
                <td>${menu.m_id}</td>
                <td align="center">${menu.menuName}</td>
                <td align="center">${menu.fatherMenuName}</td>
                <td align="center">${menu.menuPath}</td>
                <td>${menu.state}</td>
                <td>
                    <a href="javascript:delMenuOne('${menu.m_id}')">删除</a>

                    |<a href="/testSSMStepByStep/MenuEdit.do?id=${menu.m_id}">编辑</a>
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



                <!--翻页代码 -->
                <!--翻页代码 -->
                <%-- 分页查询的代码--%>
                <%--如果不是第一页则显示首页加上一页的链接--%>
                <c:if test="${pageBeanMenu.pageNum!=1}">
                    <a  href="/testSSMStepByStep/queMenu.do?pageNum=1&&conditionValue=${pageBeanMenu.conditionValue}
                    &&conditionName=${pageBeanMenu.conditionName}">首页</a>
                    <a  href="/testSSMStepByStep/queMenu.do?pageNum=${pageBeanMenu.pageNum-1}&&conditionValue=${pageBeanMenu.conditionValue}
                    &&conditionName=${pageBeanMenu.conditionName}">上一页</a>
                </c:if>

                <%--前五后四的工具条
                    pageBean.pageNum-5>0//则有前五页
                    pageBean.pageNum+4<=pageBean.totalPageNume//则有后四页
                --%>
                <c:forEach begin="${pageBeanMenu.pageNum-5>0?(pageBeanMenu.pageNum-5):1}"
                           end="${pageBeanMenu.pageNum+4<=pageBeanMenu.totalPageNume?(pageBeanMenu.pageNum+4):pageBeanMenu.totalPageNume}"
                           step="1" var="i">
                    <%--当前页不用加超链接--%>
                    <c:if test="${pageBeanMenu.pageNum==i}">
                        ${i}
                    </c:if>
                    <c:if test="${pageBeanMenu.pageNum!=i}">
                        <span><a href="/testSSMStepByStep/queMenu.do?pageNum=${i}&&conditionValue=${pageBeanMenu.conditionValue}
                    &&conditionName=${pageBeanMenu.conditionName}">${i}</a></span>
                    </c:if>
                </c:forEach>


                <%--如果不是最后一页则显示尾页加下一页的链接--%>
                <c:if test="${pageBeanMenu.pageNum!=pageBeanMenu.totalPageNume}">
                    <a  href="/testSSMStepByStep/queMenu.do?pageNum=${pageBeanMenu.pageNum+1}&&conditionValue=${pageBeanMenu.conditionValue}
                    &&conditionName=${pageBeanMenu.conditionName}">下一页</a>
                    <a  href="/testSSMStepByStep/queMenu.do?pageNum=${pageBeanMenu.totalPageNume}&&conditionValue=${pageBeanMenu.conditionValue}
                    &&conditionName=${pageBeanMenu.conditionName}">尾页</a>
                </c:if>









            </td>
        </tr>
    </table>

</form>


</body>
</html>
