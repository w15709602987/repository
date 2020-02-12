<%--
  Created by IntelliJ IDEA.
  User:
  Date: 2019/9/7
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<HEAD>
    <TITLE>欢迎登陆项目平台管理系统</TITLE>
    <%--引入CSS样式表--%>
    <LINK href="/images/css1.css" type=text/css rel=stylesheet>
    <LINK href="/images/newhead.css" type=text/css rel=stylesheet>
</HEAD>
<script>
    var code ;
    function createCode(){
        code = new Array();
        var codeLength = 4;
        var checkCode = document.getElementById("checkCode");
        checkCode.value = "";
        var selectChar = new Array(2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');
        for(var i=0;i<codeLength;i++) {
            var charIndex = Math.floor(Math.random()*32);
            code +=selectChar[charIndex];
        }
        checkCode.value = code;
    }
    function validate () {
        var inputCode = document.getElementById("yzm").value.toUpperCase();
        if(inputCode != code ){
            alert("验证码错误！");
            return false;
        }
        else {
            return true;
        }
    }
</script>
<BODY bgColor=#eef8e0 leftMargin=0 topMargin=0 MARGINWIDTH="0" MARGINHEIGHT="0">



<%--//表单提交后，转到登录servlet     "/login"中   --%>
<FORM action="/testSSMStepByStep/login.do" method="post">

    <TABLE cellSpacing=0 cellPadding=0 width=1004 border=0 align="center">
        <TBODY>
        <TR>
            <TD colSpan=6><IMG height=92 alt="" src="/images/crm_1.gif"
                               width=345></TD>
            <TD colSpan=4><IMG height=92 alt="" src="/images/crm_2.gif"
                               width=452></TD>
            <TD><IMG height=92 alt="" src="/images/crm_3.gif" width=207></TD></TR>
        <TR>
            <TD colSpan=6><IMG height=98 alt="" src="/images/crm_4.gif"
                               width=345></TD>
            <TD colSpan=4><IMG height=98 alt="" src="/images/crm_5.gif"
                               width=452></TD>
            <TD><IMG height=98 alt="" src="/images/crm_6.gif" width=207></TD></TR>
        <TR>
            <TD rowSpan=5><IMG height=370 alt="" src="/images/crm_7.gif"
                               width=59></TD>
            <TD colSpan=5><IMG height=80 alt="" src="/images/crm_8.gif"
                               width=286></TD>
            <TD colSpan=4><IMG height=80 alt="" src="/images/crm_9.gif"
                               width=452></TD>
            <TD><IMG height=80 alt="" src="/images/crm_10.gif" width=207></TD></TR>
        <TR >
            <TD><IMG height=110 alt="" src="/images/crm_11.gif" width=127></TD>
            <TD background=/images/crm_12.gif colSpan=6>
                <TABLE id=table1 cellSpacing=0 cellPadding=0 width="98%" border=0>
                    <TBODY>
                    <TR>
                        <TD>
                            <TABLE id=table2 cellSpacing=1 cellPadding=0 width="100%"
                                   border=0><TBODY>
                            <TR>
                                <TD align=middle width=81><FONT color=#ffffff style="font-size: 12px;font-family:宋体;">用户名：</FONT></TD>
                                <TD>
                                    <INPUT class=regtxt title=请填写用户名 maxLength=16 size=16 name=username>
                                </TD>
                            </TR>


                            <tr> <td colspan="2"style="padding-left: 60px;"><span style="color: red;font-size: 12px;font-family: 宋体">${sessionScope.msg2}</span>
                            </td>
                            </tr>


                            <TR>
                                <TD align=middle width=81>
                                    <FONT color=#ffffff style="font-size: 12px;font-family:宋体;">密码：</FONT>
                                </TD>
                                <TD>
                                    <INPUT class=regtxt title=请填写密码 type=password maxLength=16 size=16  name=password>
                                </TD>
                            </TR>
                            <TR>
                                <TD align=middle width=81><FONT color=#ffffff style="font-size: 12px;font-family:宋体;">验证码：</FONT></TD>
                                <TD>
                                    <input type="text" id="yzm" size="5" maxLength=50 size=16 />
                                </TD>
                                <td>
                                    <input type="button" id="checkCode" onClick="createCode()" title="刷新验证码" style="width: 80px;height: 20px;cursor: pointer" />
                                    <%--  //生成验证码--%>
                                </td>
                            </TR>
                            <tr> <td colspan="2"style="padding-left: 60px;"><span style="color: red;font-size: 12px;font-family: 宋体">${sessionScope.msg1}</span>
                            </td>
                            </tr>
                            </TBODY>
                            </TABLE>
                        </TD>
                    </TR>
                    </TBODY>
                </TABLE>
            </TD>
            <TD colSpan=2 rowSpan=2><IMG height=158 alt=""
                                         src="/images/crm_13.gif" width=295></TD>
            <TD rowSpan=2><IMG height=158 alt="" src="/images/crm_14.gif"
                               width=207></TD></TR>
        <TR>
            <TD rowSpan=3><IMG height=180 alt="" src="/images/crm_15.gif"
                               width=127></TD>
            <TD rowSpan=3><IMG height=180 alt="" src="/images/crm_16.gif"
                               width=24></TD>
            <TD>

                <INPUT title=登录项目平台管理系统 type=image height=48 alt="" width=86
                       src="/images/crm_17.gif" name=image onClick="validate();" >

            </TD>
            <TD><IMG height=48 alt="" src="/images/crm_18.gif" width=21></TD>
            <TD colSpan=2>
                <A >
                    <IMG title=关闭页面 type="reset" height=48 alt="" src="/images/crm_19.gif" width=84
                         border=0>
                </A>
            </TD>
            <TD><IMG height=48 alt="" src="/images/crm_20.gif" width=101></TD></TR>
        <TR>
            <TD colSpan=5 rowSpan=2><IMG height=132 alt=""
                                         src="/images/crm_21.gif" width=292></TD>
            <TD rowSpan=2><IMG height=132 alt="" src="/images/crm_22.gif"
                               width=170></TD>
            <TD colSpan=2><IMG height=75 alt="" src="/images/crm_23.gif"
                               width=332></TD></TR>
        <TR>
            <TD colSpan=2><IMG height=57 alt="" src="/images/crm_24.gif"
                               width=332></TD></TR>
        <TR>
            <TD><IMG height=1 alt="" src="/images/spacer.gif" width=59></TD>
            <TD><IMG height=1 alt="" src="/images/spacer.gif" width=127></TD>
            <TD><IMG height=1 alt="" src="/images/spacer.gif" width=24></TD>
            <TD><IMG height=1 alt="" src="/images/spacer.gif" width=86></TD>
            <TD><IMG height=1 alt="" src="/images/spacer.gif" width=21></TD>
            <TD><IMG height=1 alt="" src="/images/spacer.gif" width=28></TD>
            <TD><IMG height=1 alt="" src="/images/spacer.gif" width=56></TD>
            <TD><IMG height=1 alt="" src="/images/spacer.gif" width=101></TD>
            <TD><IMG height=1 alt="" src="/images/spacer.gif" width=170></TD>
            <TD><IMG height=1 alt="" src="/images/spacer.gif" width=125></TD>
            <TD><IMG height=1 alt="" src="/images/spacer.gif"
                     width=207></TD>
        </TR>
        </TBODY>
    </TABLE>
</FORM>
</BODY>
</HTML>
