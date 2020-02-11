<%--
  Created by IntelliJ IDEA.
  User: Join
  Date: 2019/9/5
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="/skin/css/base.css">
</head>
<script>


    //全部数据删除的确认,在表单提交时被调用!
    function delAll() {
        var arrs = document.getElementsByName("id");
        /*在进行批量删除前先判断是不是有选中的数据！*/
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
            //判断是不是要删除，若选择为false,则表单提交失败，即不进行删除操作！
            var isconfirm = window.confirm("你确定要删除你选中的数据吗？");
            if (!isconfirm){
                return false;
            }
        }

    }

    //当全选按钮被点击时，所有name=“id”的复选框被选中！
    //当反选按钮被点击时，所有name=“id”的复选框不被选中！
    function checkAll() {
        var arrs = document.getElementsByName("id");
        for(var i = 0;i<arrs.length;i++){
            arrs[i].checked = true;
        }
    }
    //当反选按钮被点击时，所有name=“id”的复选框不被选中！
    function nocheckAll() {
        var arrs = document.getElementsByName("id");
        for(var i = 0;i<arrs.length;i++){
            arrs[i].checked = false;
        }
    }
    //反选
    function changecheck() {
        var arrs = document.getElementsByName("id");
        for(var i = 0;i<arrs.length;i++){
            arrs[i].checked = !arrs[i].checked;

        }
    }
    window.onload = function () {

        var arrs = document.getElementsByName("xuhao");//当前页只有5个序号！！！
        for (var i = 0;i<arrs.length;i++){
            arrs[i].innerText = ${pageBeanUser.pageNum}*5-4+i;
        }

    }

    //单个数据删除的确定！
    function delUserOne(id) {
        var isconfirm = window.confirm("您确定要删除吗？");
        if (isconfirm){
            window.location.href = "/testSSMStepByStep/delUser.do?id="+id;
        }
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
                        当前位置:权限管理>>用户管理
                    </td>
                    <td>
                        <input type='button' class="coolbg np" onClick="location='/testSSMStepByStep/queRoleAndtoUserAddjsp.do';" value='添加用户' />
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<!--  搜索表单  -->
<form name='form3' action="/testSSMStepByStep/queUser.do?pageNum=1" method="post">
    <input type='hidden' name='dopost' value='' />
    <table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
        <tr bgcolor='#EEF4EA'>
            <td background='/skin/images/wbg.gif' align='center'>
                <table border='0' cellpadding='0' cellspacing='0'>
                    <tr>
                        <td width='90' align='center'>搜索条件：</td>
                        <td width='160'>
                            <select name='conditionName' style='width:150px'>
                                <option value='username'
                                        <c:if test="${pageBeanUser.conditionName=='username'}">
                                            selected="selected"
                                        </c:if>
                                >姓名</option>
                                <option value='cellphone'
                                        <c:if test="${pageBeanUser.conditionName=='cellphone'}">
                                            selected="selected"
                                        </c:if>
                                >联系电话</option>
                            </select>
                        </td>
                        <td width='70'>
                            关键字：
                        </td>
                        <td width='160'>
                            <input type='text' name='conditionValue' value="${pageBeanUser.conditionValue}" style='width:120px' />
                        </td>
                        <td width='110'>
                            <select name='orderByMethod' style='width:120px'>
                                <option value='initiationtime'>添加时间</option>
                               <%-- <option value='pubdate'>修改时间</option>--%>
                            </select>
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
<!--  内容列表   -->
<form name="form2" action="/testSSMStepByStep/delUser.do" method="post" onsubmit="return delAll();">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="12" background="/skin/images/tbg.gif">&nbsp;用户列表&nbsp;</td>
        </tr>
        <tr align="center" bgcolor="#FAFAF1" height="22">
            <td width="4%">选择</td>
            <td width="6%">序号</td>
            <td width="10%">姓名</td>
            <td width="10%">职位</td>
            <td width="10%">性别</td>
            <td width="10%">年龄</td>
            <td width="10%">联系电话</td>
            <td width="8%">入职时间</td>
            <td width="8%">状态</td>
            <td width="10%">操作</td>
        </tr>





<c:forEach var="user" items="${pageBeanUser.list}">
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
            <td><input name="id" type="checkbox" value="${user.u_id}"  class="np"></td>
            <td name="xuhao"></td>
            <td>${user.username}</td>
            <td align="center">${user.position}</td>
            <td>${user.gender}</td>
            <td>${user.age}</td>
            <td>${user.cellphone}</td>
            <td>${user.initiationtime}</td>
            <td>正常</td>
            <td>
                <a href="javascript:delUserOne('${user.u_id}')">删除</a>
                | <a href="/testSSMStepByStep/userEdit.do?id=${user.u_id}">编辑</a>
                | <a href="/testSSMStepByStep/userShow.do?id=${user.u_id}">查看详情</a></td>
        </tr>
</c:forEach>











        <tr bgcolor="#FAFAF1">
            <td height="28" colspan="12">
                &nbsp;
                <input type="button" onclick="checkAll();" value="全选">
                <input type="button" onclick="nocheckAll();" value="全不选">
                <input type="button" onclick="changecheck();" value="反选">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="注销" class="coolbg">&nbsp;
                <a href="" class="coolbg">&nbsp;全部导出Excel&nbsp;</a>
            </td>
        </tr>
        <tr align="right" bgcolor="#EEF4EA">
            <td height="36" colspan="12" align="center">

                <!--翻页代码 -->
                <%-- 分页查询的代码--%>
                <%--如果不是第一页则显示首页加上一页的链接--%>
                <c:if test="${pageBeanUser.pageNum!=1}">
                    <a  href="/testSSMStepByStep/queUser.do?pageNum=1&&orderByMethod=${pageBeanUser.orderByMethod}&&conditionvalue=${pageBeanUser.conditionValue}
                    &&conditionname=${pageBeanUser.conditionName}">首页</a>
                    <a  href="/testSSMStepByStep/queUser.do?pageNum=${pageBeanUser.pageNum-1}&&orderByMethod=${pageBeanUser.orderByMethod}&&conditionvalue=${pageBeanUser.conditionValue}
                    &&conditionname=${pageBeanUser.conditionName}">上一页</a>
                </c:if>

                <%--前五后四的工具条
                    pageBean.pageNum-5>0//则有前五页
                    pageBean.pageNum+4<=pageBean.totalPageNume//则有后四页
                --%>
                <c:forEach begin="${pageBeanUser.pageNum-5>0?(pageBeanUser.pageNum-5):1}"
                           end="${pageBeanUser.pageNum+4<=pageBeanUser.totalPageNume?(pageBeanUser.pageNum+4):pageBeanUser.totalPageNume}"
                           step="1" var="i">
                    <%--当前页不用加超链接--%>
                    <c:if test="${pageBeanUser.pageNum==i}">
                        ${i}
                    </c:if>
                    <c:if test="${pageBeanUser.pageNum!=i}">
                        <span><a href="/PPManagerSystem/queUser.do?pageNum=${i}&&orderByMethod=${pageBeanUser.orderByMethod}&&conditionvalue=${pageBeanUser.conditionValue}
                    &&conditionname=${pageBeanUser.conditionName}">${i}</a></span>
                    </c:if>
                </c:forEach>


                <%--如果不是最后一页则显示尾页加下一页的链接--%>
                <c:if test="${pageBeanUser.pageNum!=pageBeanUser.totalPageNume}">
                    <a  href="/testSSMStepByStep/queUser.do?pageNum=${pageBeanUser.pageNum+1}&&orderByMethod=${pageBeanUser.orderByMethod}&&conditionvalue=${pageBeanUser.conditionValue}
                    &&conditionname=${pageBeanUser.conditionName}">下一页</a>
                    <a  href="/testSSMStepByStep/queUser.do?pageNum=${pageBeanUser.totalPageNume}&&orderByMethod=${pageBeanUser.orderByMethod}&&conditionvalue=${pageBeanUser.conditionValue}
                    &&conditionname=${pageBeanUser.conditionName}">尾页</a>
                </c:if>











            </td>
        </tr>
    </table>

</form>


</body>
</html>
