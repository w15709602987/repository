<%--
  Created by IntelliJ IDEA.
  User: Join
  Date: 2019/9/7
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>menu</title>
    <link rel="stylesheet" href="/testSSMStepByStep/skin/css/base.css" type="text/css" />
    <link rel="stylesheet" href="/testSSMStepByStep/skin/css/menu.css" type="text/css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script>
        function showHide(objname)
        {

            var obj = document.getElementById(objname);
            if(objname.indexOf('_1')<0 || objname.indexOf('_10')>0)
            {
                if(obj.style.display == 'block' || obj.style.display =='')
                    obj.style.display = 'none';
                else
                    obj.style.display = 'block';
                return true;
            }

            var ckstr = getCookie('menuitems');
            var ckstrs = null;
            var okstr ='';
            var ischange = false;
            if(ckstr==null) ckstr = '';
            ckstrs = ckstr.split(',');
            objname = objname.replace('items','');
            if(obj.style.display == 'block' || obj.style.display =='')
            {
                obj.style.display = 'none';
                for(var i=0; i < ckstrs.length; i++)
                {
                    if(ckstrs[i]=='') continue;
                    if(ckstrs[i]==objname){  ischange = true;  }
                    else okstr += (okstr=='' ? ckstrs[i] : ','+ckstrs[i] );
                }
                if(ischange) setCookie('menuitems',okstr,7);
            }
            else
            {
                obj.style.display = 'block';
                ischange = true;
                for(var i=0; i < ckstrs.length; i++)
                {
                    if(ckstrs[i]==objname) {  ischange = false; break; }
                }
                if(ischange)
                {
                    ckstr = (ckstr==null ? objname : ckstr+','+objname);
                    setCookie('menuitems',ckstr,7);
                }
            }
        }

        function getCookie(c_name)
        {
            if (document.cookie.length > 0)
            {
                c_start = document.cookie.indexOf(c_name + "=")
                if (c_start != -1)
                {
                    c_start = c_start + c_name.length + 1;
                    c_end   = document.cookie.indexOf(";",c_start);
                    if (c_end == -1)
                    {
                        c_end = document.cookie.length;
                    }
                    return unescape(document.cookie.substring(c_start,c_end));
                }
            }
            return null
        }
        function setCookie(c_name,value,expiredays)
        {
            var exdate = new Date();
            exdate.setDate(exdate.getDate() + expiredays);
            document.cookie = c_name + "=" +escape(value) + ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString()); //使设置的有效时间正确。增加toGMTString()
        }

        var totalitem = 12;
        function CheckOpenMenu()
        {

            var ckstr = getCookie('menuitems');
            var curitem = '';
            var curobj = null;


            if(ckstr==null)
            {
                ckstr='1_1,2_1,3_1';
                setCookie('menuitems',ckstr,7);
            }
            ckstr = ','+ckstr+',';
            for(i=0;i<totalitem;i++)
            {
                curitem = i+'_'+curopenItem;
                curobj = document.getElementById('items'+curitem);
                if(ckstr.indexOf(curitem) > 0 && curobj != null)
                {
                    curobj.style.display = 'block';
                }
                else
                {
                    if(curobj != null) curobj.style.display = 'none';
                }
            }
        }

        var curitem = 1;
        function ShowMainMenu(n)
        {
            var curLink = $DE('link'+curitem);
            var targetLink = $DE('link'+n);
            var curCt = $DE('ct'+curitem);
            var targetCt = $DE('ct'+n);
            if(curitem==n) return false;
            if(targetCt.innerHTML!='')
            {
                curCt.style.display = 'none';
                targetCt.style.display = 'block';
                curLink.className = 'mm';
                targetLink.className = 'mmac';
                curitem = n;
            }
            else
            {
                var myajax = new DedeAjax(targetCt);
                myajax.SendGet2("index_menu_load.php?openitem="+n);
                if(targetCt.innerHTML!='')
                {
                    curCt.style.display = 'none';
                    targetCt.style.display = 'block';
                    curLink.className = 'mm';
                    targetLink.className = 'mmac';
                    curitem = n;
                }
                DedeXHTTP = null;
            }
        }
    </script>

    <base target="main" />
</head>
<body target="main">
<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
    <tr>
        <td style='padding-left:3px;padding-top:8px' valign="top">
            <c:forEach var="menu" items="${menuTest}">
                <c:if test="${menu.fatherMenuName=='顶级菜单'&&menu.state=='启用'}">
                    <dl class='bitem'>
                        <dt onClick='showHide("items${menu.m_id}__1")'><b>${menu.menuName}</b></dt>
                        <dd style='display:block' class='sitem' id='items${menu.m_id}__1'>
                            <ul class='sitemu'>
                                <c:set var="father" value="${menu.menuName}" scope="page"></c:set>
                                <c:forEach var="me" items="${menuTest}">
                                    <c:if test="${me.fatherMenuName==father&&me.state=='启用'}">
                                        <li><a href='${me.menuPath}' target='main'>${me.menuName}</a> </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </dd>
                    </dl>
                </c:if>
            </c:forEach>
        </td>
    </tr>
</table>
</body>
</html>

<%--                <c:forEach var="menu" items="${menuTest}">--%>
<%--                   <c:if test="${menu.state=='启用'}">--%>
<%--                     <c:if test="${menu.fatherMenuName=='顶级菜单'}">--%>


<%--                                <c:forEach var="r_haveid" items="${M_ids}">--%>
<%--                                    <c:if test="${r_haveid.m_id==menu.m_id}">--%>
<%--                    <dl class='bitem'>--%>
<%--                              <dt onClick='showHide("items${menu.m_id}_1")'>--%>
<%--                                       <b> ${menu.menuName}</b>--%>
<%--                              </dt>--%>
<%--                   <dd style='display:block' class='sitem' id='items${menu.m_id}_1'>--%>
<%--                       <ul class='sitemu'>--%>
<%--                                    </c:if>--%>
<%--                                </c:forEach>--%>
<%--                        <c:set var="father" value="${menu.menuName}" scope="page"></c:set>--%>

<%--                        <c:forEach var="me" items="${menuTest}">--%>
<%--                            <c:if test="${me.fatherMenuName==father}">--%>

<%--                                <c:forEach var="r_haveid" items="${M_ids}">--%>
<%--                                    <c:if test="${r_haveid.m_id==me.m_id}">--%>

<%--                                        <li><a href='${me.menuPath}' target='main'>${me.menuName}</a> </li>--%>
<%--                                    </c:if>--%>
<%--                                </c:forEach>--%>
<%--                            </c:if>--%>


<%--                        </c:forEach>--%>
<%--                       </ul>--%>
<%--                   </dd>--%>
<%--               </dl>--%>
<%--                    </c:if>--%>
<%--                    </c:if>--%>
<%--                </c:forEach>--%>





               <%--&lt;%&ndash;查询数据库所得--%>
<%--               <c:forEach var="menu" items="${menuTest}">--%>

<%--                   <c:if test="${menu.fatherMenuName=='顶级菜单'}">--%>

<%--                       <c:forEach var="r_haveid" items="${M_ids}">--%>
<%--                           <c:if test="${r_haveid.m_id==menu.m_id}">--%>
<%--                               ${menu.menuName}--%>
<%--                           </c:if>--%>
<%--                       </c:forEach>--%>

<%--                       <c:set var="father" value="${menu.menuName}" scope="page"></c:set>--%>

<%--                       <c:forEach var="me" items="${menuTest}">--%>
<%--                           <c:if test="${me.fatherMenuName==father}">--%>

<%--                               <c:forEach var="r_haveid" items="${M_ids}">--%>
<%--                                   <c:if test="${r_haveid.m_id==me.m_id}">--%>
<%--                                       ${me.menuName}--%>
<%--                                   </c:if>--%>
<%--                               </c:forEach>--%>
<%--                           </c:if>--%>

<%--                       </c:forEach>--%>
<%--                   </c:if>--%>
<%--               </c:forEach>--%>
           <%-- <!-- Item  Strat -->
            <dl class='bitem'>
                <dt onClick='showHide("items2_1")'><b>任务管理</b></dt>
                <dd style='display:block' class='sitem' id='items2_1'>
                    <ul class='sitemu'>
                        <li><a href='/task-add.html' target='main'>创建任务</a> </li>
                        <li><a href='/task.html' target='main'>任务信息</a> </li>
                        <li><a href='/task-my.html' target='main'>我的任务</a> </li>
                    </ul>
                </dd>
            </dl>
            <!-- Item  End -->--%>






          <%--  <!-- Item  Strat -->
            <dl class='bitem'>
                <dt onClick='showHide("items3_1")'><b>信息箱</b></dt>
                <dd style='display:none' class='sitem' id='items3_1'>
                    <ul class='sitemu'>
                        <li><a href='/message-seed.html' target='main'>发信息</a> </li>
                        <li><a href='/message.html' target='main'>发件箱</a> </li>
                        <li><a href='/message-give.html' target='main'>收件箱</a> </li>
                    </ul>
                </dd>
            </dl>
            <!-- Item  End -->--%>





            <%--<!-- Item  Strat -->
            <dl class='bitem'>
                <dt onClick='showHide("items4_1")'><b>客户信息管理</b></dt>
                <dd style='display:none' class='sitem' id='items4_1'>
                    <ul class='sitemu'>
                        <li><a href='/PPManagerSystem/CodAndPageQue?pageNum=1&&conditionname=companyname&&conditionvalue=&&orderByMethod=addtime' target='main'>客户信息</a> </li>
                    </ul>
                </dd>
            </dl>
            <!-- Item  End -->--%>






          <%--  <!-- Item  Strat -->
            <dl class='bitem'>
                <dt onClick='showHide("items5_1")'><b>权限管理</b></dt>
                <dd style='display:none' class='sitem' id='items5_1'>
                    <ul class='sitemu'>
                        <li><a href='/PPManagerSystem/queUser?pageNum=1&&conditionname=username&&conditionvalue=&&orderByMethod=initiationtime' target='main'>人员管理</a> </li>
                        <li><a href='/PPManagerSystem/queRole?pageNum=1&&conditionName=roleName&&conditionValue=' target='main'>角色管理</a> </li>
                        <li><a href='/PPManagerSystem/queMenu?pageNum=1&&conditionName=menuname&&conditionValue=' target='main'>菜单资源管理</a> </li>
                    </ul>
                </dd>
            </dl>
            <!-- Item  End -->--%>







           <%-- <!-- Item  Strat -->
            <dl class='bitem'>
                <dt onClick='showHide("items6_1")'><b>我的信息</b></dt>
                <dd style='display:none' class='sitem' id='items6_1'>
                    <ul class='sitemu'>
                        <li><a href='/info.html' target='main'>信息查看</a> </li>
                        <li><a href='/modpassword.html' target='main'>修改密码</a> </li>
                    </ul>
                </dd>
            </dl>
            <!-- Item  End -->--%>








