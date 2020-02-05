<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2020/1/13
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>客户信息管理</title>
    <link  href="/skin/css/base.css" type=text/css rel=stylesheet>
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
    //当全不选选按钮被点击时，所有name=“id”的复选框不被选中！
    //当反选按钮被点击是，所有name=“id”的复选框变为非！
    function checkAll() {
        var arrs = document.getElementsByName("id");
        for(var i = 0;i<arrs.length;i++){
            arrs[i].checked = true;
        }
    }
    //当全不选选按钮被点击时，所有name=“id”的复选框不被选中！
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
            arrs[i].innerText = ${pageBean.pageNum}*5-4+i;
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
                        当前位置:客户信息管理>>客户信息
                    </td>
                    <td>
                        <input type='button' class="coolbg np" onClick="location='/testSSMStepByStep/customer-add.jsp';" value='添加客户信息' />
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form name='form3' action="/testSSMStepByStep/uu.do?pageNum=1" method="post">
    <input type='hidden' name='dopost' value='' />
    <table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
        <tr bgcolor='#EEF4EA'>
            <td background='/skin/images/wbg.gif' align='center'>
                <table border='0' cellpadding='0' cellspacing='0'>
                    <tr>
                        <td width='90' align='center'>搜索条件：</td>
                        <td width='160'>
                            <select name='conditionName' style='width:150px'>
                                <option value='companyname'
                                        <c:if test="${pageBean.conditionName=='companyname'}">
                                            selected="selected"
                                        </c:if>
                                >客户所在公司名称</option>
                                <option value='customername'
                                        <c:if test="${pageBean.conditionName=='customername'}">
                                            selected="selected"
                                        </c:if>
                                >联系人姓名</option>
                            </select>
                        </td>
                        <td width='70'>
                            关键字：
                        </td>
                        <td width='160'>
                            <input type='text' name='conditionValue'  style='width:120px' value="${pageBean.conditionValue}"/>
                        </td>
                        <td width='110'>
                            <select name='orderByMethod' style='width:120px'>
                                <option value='addtime'
                                        <c:if test="${pageBean.orderByMethod=='addtime'}">
                                            selected="selected"
                                        </c:if>
                                >添加时间</option>
                                <option value='modtime'
                                        <c:if test="${pageBean.orderByMethod=='modtime'}">
                                            selected="selected"
                                        </c:if>
                                >修改时间</option>
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

<form name="form2" action="/testSSMStepByStep/delCustomer.do" method="post" onsubmit="return delAll();">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="12" background="/skin/images/tbg.gif">&nbsp;需求列表&nbsp;</td>
        </tr>
        <tr align="center" bgcolor="#FAFAF1" height="22">
            <td width="4%">选择</td>
            <td width="6%">序号</td>
            <td width="10%">联系人</td>
            <td width="10%">公司名称</td>
            <td width="8%">添加时间</td>
            <td width="8%">联系电话</td>
            <td width="10%">操作</td>
        </tr>
        <c:forEach var="customer" items="${pageBean.customers}">
            <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
                <td><input type="checkbox" name="id" value="${customer.id}" ></td>
                <td name="xuhao"></td>
                <td>${customer.customername}</td>
                <td align="center">${customer.companyname}</td>
                <td>${customer.addtime}</td>
                <td>${customer.cellphone}</td>

                <td><a href="/testSSMStepByStep/customerLook.do?id=${customer.id}">编辑</a> | <a href="/testSSMStepByStep/show.do?id=${customer.id}">查看详情</a></td>
            </tr>
        </c:forEach>



        <tr bgcolor="#FAFAF1">
            <td height="28" colspan="12">
                &nbsp;

                <%-- <th>全选<input type="checkbox" id="checkAllbtn" onclick="checkAll();"> </th>--%>
                <input type="button" id="checkAllbtn" onclick="checkAll();" value="全选">
                <input type="button" id="checkAllbtn" onclick="nocheckAll();" value="全不选">
                <input type="button" id="checkAllbtn" onclick="changecheck();" value="反选">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="删除" class="coolbg">

                <a href="/project/DownLoadExcelServlet?pageNum=1&&orderByMethod=${pageBean.orderByMethod}&&conditionValue=${pageBean.conditionValue}
                    &&conditionName=${pageBean.conditionName}" class="coolbg">&nbsp;全部导出Excel&nbsp;</a>
            </td>
        </tr>
        <tr align="right" bgcolor="#EEF4EA">
            <td height="36" colspan="12" align="center">






                <%-- 分页查询的代码--%>
                <%--如果不是第一页则显示首页加上一页的链接--%>
                <c:if test="${pageBean.pageNum!=1}">
                    <a  href="/testSSMStepByStep/uu.do?pageNum=1&&orderByMethod=${pageBean.orderByMethod}&&conditionValue=${pageBean.conditionValue}
                    &&conditionName=${pageBean.conditionName}">首页</a>
                    <a  href="/testSSMStepByStep/uu.do?pageNum=${pageBean.pageNum-1}&&orderByMethod=${pageBean.orderByMethod}&&conditionValue=${pageBean.conditionValue}
                    &&conditionName=${pageBean.conditionName}">上一页</a>
                </c:if>

                <%--前五后四的工具条
                    pageBean.pageNum-5>0//则有前五页
                    pageBean.pageNum+4<=pageBean.totalPageNume//则有后四页
                --%>
                <c:forEach begin="${pageBean.pageNum-5>0?(pageBean.pageNum-5):1}"
                           end="${pageBean.pageNum+4<=pageBean.totalPageNume?(pageBean.pageNum+4):pageBean.totalPageNume}"
                           step="1" var="i">
                    <%--当前页不用加超链接--%>
                    <c:if test="${pageBean.pageNum==i}">
                        ${i}
                    </c:if>
                    <c:if test="${pageBean.pageNum!=i}">
                        <span><a href="/testSSMStepByStep/uu.do?pageNum=${i}&&orderByMethod=${pageBean.orderByMethod}&&conditionValue=${pageBean.conditionValue}
                    &&conditionName=${pageBean.conditionName}">${i}</a></span>
                    </c:if>
                </c:forEach>


                <%--如果不是最后一页则显示尾页加下一页的链接--%>
                <c:if test="${pageBean.pageNum!=pageBean.totalPageNume}">
                    <a  href="/testSSMStepByStep/uu.do?pageNum=${pageBean.pageNum+1}&&orderByMethod=${pageBean.orderByMethod}&&conditionValue=${pageBean.conditionValue}
                    &&conditionName=${pageBean.conditionName}">下一页</a>
                    <a  href="/testSSMStepByStep/uu.do?pageNum=${pageBean.totalPageNume}&&orderByMethod=${pageBean.orderByMethod}&&conditionValue=${pageBean.conditionValue}
                    &&conditionName=${pageBean.conditionName}">尾页</a>
                </c:if>



            </td>
        </tr>
    </table>

</form>


</body>
</html>
