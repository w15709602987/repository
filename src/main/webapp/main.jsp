<%--
  Created by IntelliJ IDEA.
  User:
  Date: 2019/10/27
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>main</title>
    <base target="_self">
    <link rel="stylesheet" type="text/css" href="/testSSMStepByStep/skin/css/base.css" />
    <link rel="stylesheet" type="text/css" href="/testSSMStepByStep/skin/css/main.css" />
</head>
<body leftmargin="8" topmargin='8'>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td><div style='float:left'> <img height="14" src="/testSSMStepByStep/skin/images/frame/book1.gif" width="20" />&nbsp;欢迎使用项目平台管理系统</div>
            <div style='float:right;padding-right:8px;'>

            </div></td>
    </tr>
    <tr>
        <td height="1" background="/skin/images/frame/sp_bg.gif" style='padding:0px'></td>
    </tr>
</table>


<table width="98%" align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px;margin-top:8px;">
    <tr>
        <td background="/testSSMStepByStep/skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'><span>待完成任务</span></td>
    </tr>
    <tr bgcolor="#FFFFFF">
        <td>您有<a href=""><font color="red">2</font></a>个任务未完成……&nbsp;</td>
    </tr>
</table>



<table width="98%" align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px;margin-top:8px;">
    <tr>
        <td background="/testSSMStepByStep/skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'><span>未读消息</span></td>
    </tr>
    <tr bgcolor="#FFFFFF">
        <td>您有<a href=""><font color="red">10</font></a>条未读消息……&nbsp;</td>
    </tr>
</table>


<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
    <tr>
        <td colspan="2" background="/testSSMStepByStep/skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'>
            <div style='float:left'><span>快捷操作</span></div>
            <div style='float:right;padding-right:10px;'></div>
        </td>
    </tr>
    <tr bgcolor="#FFFFFF">
        <td height="30" colspan="2" align="center" valign="bottom"><table width="100%" border="0" cellspacing="1" cellpadding="1">
            <tr>
                <td width="15%" height="31" align="center"><img src="/testSSMStepByStep/skin/images/frame/qc.gif" width="90" height="30" /></td>
                <td width="85%" valign="bottom"><div class='icoitem'>
                    <div class='ico'><img src='/testSSMStepByStep/skin/images/frame/addnews.gif' width='16' height='16' /></div>
                    <div class='txt'><a href='/testSSMStepByStep/project-base.jsp'><u>查看项目信息</u></a></div>
                </div>
                    <div class='icoitem'>
                        <div class='ico'><img src='/testSSMStepByStep/skin/images/frame/menuarrow.gif' width='16' height='16' /></div>
                        <div class='txt'><a href='/testSSMStepByStep/task-my.jsp'><u>查看任务</u></a></div>
                    </div>
                    <div class='icoitem'>
                        <div class='ico'><img src='/testSSMStepByStep/skin/images/frame/manage1.gif' width='16' height='16' /></div>
                        <div class='txt'><a href='/testSSMStepByStep/task-add.jsp'><u>发布任务</u></a></div>
                    </div>
                    <div class='icoitem'>
                        <div class='ico'><img src='/testSSMStepByStep/skin/images/frame/file_dir.gif' width='16' height='16' /></div>
                        <div class='txt'><a href='/testSSMStepByStep/message-give.jsp'><u>收件箱</u></a></div>
                    </div>
                    <div class='icoitem'>
                        <div class='ico'><img src='/testSSMStepByStep/skin/images/frame/part-index.gif' width='16' height='16' /></div>
                        <div class='txt'><a href='/testSSMStepByStep/info.jsp'><u>个人信息</u></a></div>
                    </div>
                    <div class='icoitem'>
                        <div class='ico'><img src='/testSSMStepByStep/skin/images/frame/manage1.gif' width='16' height='16' /></div>
                        <div class='txt'><a href='/testSSMStepByStep/modpassword.jsp'><u>修改密码</u></a></div>
                    </div></td>
            </tr>
        </table></td>
    </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
    <tr bgcolor="#EEF4EA">
        <td colspan="2" background="/testSSMStepByStep/skin/images/frame/wbg.gif" class='title'><span>温馨信息</span></td>
    </tr>
    <tr bgcolor="#FFFFFF">
        <td width="25%" bgcolor="#FFFFFF">您的级别：</td>
        <td width="75%" bgcolor="#FFFFFF">${roleName}</td>
    </tr>
</table>
</body>
</html>

