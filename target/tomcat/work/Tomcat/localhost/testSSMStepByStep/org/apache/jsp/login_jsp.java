/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-02-13 03:54:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<HTML>\r\n");
      out.write("<HEAD>\r\n");
      out.write("    <TITLE>欢迎登陆项目平台管理系统</TITLE>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <LINK href=\"/testSSMStepByStep/images/css1.css\" type=text/css rel=stylesheet>\r\n");
      out.write("    <LINK href=\"/testSSMStepByStep/images/newhead.css\" type=text/css rel=stylesheet>\r\n");
      out.write("</HEAD>\r\n");
      out.write("<script>\r\n");
      out.write("    var code ;\r\n");
      out.write("    function createCode(){\r\n");
      out.write("        code = new Array();\r\n");
      out.write("        var codeLength = 4;\r\n");
      out.write("        var checkCode = document.getElementById(\"checkCode\");\r\n");
      out.write("        checkCode.value = \"\";\r\n");
      out.write("        var selectChar = new Array(2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');\r\n");
      out.write("        for(var i=0;i<codeLength;i++) {\r\n");
      out.write("            var charIndex = Math.floor(Math.random()*32);\r\n");
      out.write("            code +=selectChar[charIndex];\r\n");
      out.write("        }\r\n");
      out.write("        checkCode.value = code;\r\n");
      out.write("    }\r\n");
      out.write("    function validate () {\r\n");
      out.write("        var inputCode = document.getElementById(\"yzm\").value.toUpperCase();\r\n");
      out.write("        if(inputCode != code ){\r\n");
      out.write("            alert(\"验证码错误！\");\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("        else {\r\n");
      out.write("            return true;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("    function createXMLHttpRequest() {\r\n");
      out.write("        try{\r\n");
      out.write("            return new XMLHttpRequest();\r\n");
      out.write("        }catch (e) {\r\n");
      out.write("            try {\r\n");
      out.write("                return  new ActiveXObject(\"Msxml2.XMLHTTP\")\r\n");
      out.write("            }catch (e) {\r\n");
      out.write("                try{\r\n");
      out.write("                    return  new ActiveXObject(\"Microsoft.XMLHTTP\")\r\n");
      out.write("                }catch (e) {\r\n");
      out.write("\r\n");
      out.write("                    throw e;\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("    function passwordIsTrue() {\r\n");
      out.write("        var username = document.getElementById(\"username\")\r\n");
      out.write("        var password = document.getElementById(\"password\")\r\n");
      out.write("        var msg=document.getElementById(\"msg\");\r\n");
      out.write("                var xmlHttp = createXMLHttpRequest();\r\n");
      out.write("                xmlHttp.open(\"POST\", \"/testSSMStepByStep/yiBu.do\", true);\r\n");
      out.write("                xmlHttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\r\n");
      out.write("                var param = \"username=\"+username.value+\"&password=\"+password.value;\r\n");
      out.write("                        xmlHttp.send(param);\r\n");
      out.write("                xmlHttp.onreadystatechange = function () {\r\n");
      out.write("                    var responseContent;\r\n");
      out.write("                    if (xmlHttp.status == 200 && xmlHttp.readyState == 4) {\r\n");
      out.write("                        responseContent = xmlHttp.responseText;\r\n");
      out.write("                        if(responseContent=='false'){\r\n");
      out.write("                            msg.innerHTML='用户名密码错误';\r\n");
      out.write("                            return false;\r\n");
      out.write("                        }else if(responseContent=='true'){\r\n");
      out.write("                            msg.innerHTML='用户名密码正确';\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<BODY bgColor=#eef8e0 leftMargin=0 topMargin=0 MARGINWIDTH=\"0\" MARGINHEIGHT=\"0\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<FORM action=\"/testSSMStepByStep/login.do\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("    <TABLE cellSpacing=0 cellPadding=0 width=1004 border=0 align=\"center\">\r\n");
      out.write("        <TBODY>\r\n");
      out.write("        <TR>\r\n");
      out.write("            <TD colSpan=6><IMG height=92 alt=\"\" src=\"/testSSMStepByStep/images/crm_1.gif\"\r\n");
      out.write("                               width=345></TD>\r\n");
      out.write("            <TD colSpan=4><IMG height=92 alt=\"\" src=\"/testSSMStepByStep/images/crm_2.gif\"\r\n");
      out.write("                               width=452></TD>\r\n");
      out.write("            <TD><IMG height=92 alt=\"\" src=\"/testSSMStepByStep/images/crm_3.gif\" width=207></TD></TR>\r\n");
      out.write("        <TR>\r\n");
      out.write("            <TD colSpan=6><IMG height=98 alt=\"\" src=\"/testSSMStepByStep/images/crm_4.gif\"\r\n");
      out.write("                               width=345></TD>\r\n");
      out.write("            <TD colSpan=4><IMG height=98 alt=\"\" src=\"/testSSMStepByStep/images/crm_5.gif\"\r\n");
      out.write("                               width=452></TD>\r\n");
      out.write("            <TD><IMG height=98 alt=\"\" src=\"/testSSMStepByStep/images/crm_6.gif\" width=207></TD></TR>\r\n");
      out.write("        <TR>\r\n");
      out.write("            <TD rowSpan=5><IMG height=370 alt=\"\" src=\"/testSSMStepByStep/images/crm_7.gif\"\r\n");
      out.write("                               width=59></TD>\r\n");
      out.write("            <TD colSpan=5><IMG height=80 alt=\"\" src=\"/testSSMStepByStep/images/crm_8.gif\"\r\n");
      out.write("                               width=286></TD>\r\n");
      out.write("            <TD colSpan=4><IMG height=80 alt=\"\" src=\"/testSSMStepByStep/images/crm_9.gif\"\r\n");
      out.write("                               width=452></TD>\r\n");
      out.write("            <TD><IMG height=80 alt=\"\" src=\"/testSSMStepByStep/images/crm_10.gif\" width=207></TD></TR>\r\n");
      out.write("        <TR >\r\n");
      out.write("            <TD><IMG height=110 alt=\"\" src=\"/testSSMStepByStep/images/crm_11.gif\" width=127></TD>\r\n");
      out.write("            <TD background=/testSSMStepByStep/images/crm_12.gif colSpan=6>\r\n");
      out.write("                <TABLE id=table1 cellSpacing=0 cellPadding=0 width=\"98%\" border=0>\r\n");
      out.write("                    <TBODY>\r\n");
      out.write("                    <TR>\r\n");
      out.write("                        <TD>\r\n");
      out.write("                            <TABLE id=table2 cellSpacing=1 cellPadding=0 width=\"100%\"\r\n");
      out.write("                                   border=0><TBODY>\r\n");
      out.write("                            <TR>\r\n");
      out.write("                                <TD align=middle width=81><FONT color=#ffffff style=\"font-size: 12px;font-family:宋体;\">用户名：</FONT></TD>\r\n");
      out.write("                                <TD>\r\n");
      out.write("                                    <INPUT class=regtxt title=请填写用户名 maxLength=16 size=16 name=username id=\"username\">\r\n");
      out.write("\r\n");
      out.write("                                </TD>\r\n");
      out.write("                            </TR>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <tr> <td colspan=\"2\"style=\"padding-left: 60px;\"><span id=\"msg\" style=\"color: red;font-size: 12px;font-family: 宋体\"></span>\r\n");
      out.write("                            </td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <TR>\r\n");
      out.write("                                <TD align=middle width=81>\r\n");
      out.write("                                    <FONT color=#ffffff style=\"font-size: 12px;font-family:宋体;\">密码：</FONT>\r\n");
      out.write("                                </TD>\r\n");
      out.write("                                <TD>\r\n");
      out.write("                                    <INPUT class=regtxt title=请填写密码 type=password maxLength=16 size=16 id=\"password\" name=password onblur=\"passwordIsTrue()\">\r\n");
      out.write("                                </TD>\r\n");
      out.write("                            </TR>\r\n");
      out.write("                            <TR>\r\n");
      out.write("                                <TD align=middle width=81><FONT color=#ffffff style=\"font-size: 12px;font-family:宋体;\">验证码：</FONT></TD>\r\n");
      out.write("                                <TD>\r\n");
      out.write("                                    <input type=\"text\" id=\"yzm\" size=\"5\" maxLength=50 size=16 />\r\n");
      out.write("                                </TD>\r\n");
      out.write("                                <td>\r\n");
      out.write("                                    <input type=\"button\" id=\"checkCode\" onClick=\"createCode()\" title=\"刷新验证码\" style=\"width: 80px;height: 20px;cursor: pointer\" />\r\n");
      out.write("                                    ");
      out.write("\r\n");
      out.write("                                </td>\r\n");
      out.write("                            </TR>\r\n");
      out.write("                            <tr> <td colspan=\"2\"style=\"padding-left: 60px;\">\r\n");
      out.write("                            </td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            </TBODY>\r\n");
      out.write("                            </TABLE>\r\n");
      out.write("                        </TD>\r\n");
      out.write("                    </TR>\r\n");
      out.write("                    </TBODY>\r\n");
      out.write("                </TABLE>\r\n");
      out.write("            </TD>\r\n");
      out.write("            <TD colSpan=2 rowSpan=2><IMG height=158 alt=\"\"\r\n");
      out.write("                                         src=\"/testSSMStepByStep/images/crm_13.gif\" width=295></TD>\r\n");
      out.write("            <TD rowSpan=2><IMG height=158 alt=\"\" src=\"/testSSMStepByStep/images/crm_14.gif\"\r\n");
      out.write("                               width=207></TD></TR>\r\n");
      out.write("        <TR>\r\n");
      out.write("            <TD rowSpan=3><IMG height=180 alt=\"\" src=\"/testSSMStepByStep/images/crm_15.gif\"\r\n");
      out.write("                               width=127></TD>\r\n");
      out.write("            <TD rowSpan=3><IMG height=180 alt=\"\" src=\"/testSSMStepByStep/images/crm_16.gif\"\r\n");
      out.write("                               width=24></TD>\r\n");
      out.write("            <TD>\r\n");
      out.write("\r\n");
      out.write("                <INPUT title=登录项目平台管理系统 type=image height=48 alt=\"\" width=86\r\n");
      out.write("                       src=\"/testSSMStepByStep/images/crm_17.gif\" name=image onClick=\"validate();\" >\r\n");
      out.write("\r\n");
      out.write("            </TD>\r\n");
      out.write("            <TD><IMG height=48 alt=\"\" src=\"/testSSMStepByStep/images/crm_18.gif\" width=21></TD>\r\n");
      out.write("            <TD colSpan=2>\r\n");
      out.write("                <A >\r\n");
      out.write("                    <IMG title=关闭页面 type=\"reset\" height=48 alt=\"\" src=\"/testSSMStepByStep/images/crm_19.gif\" width=84\r\n");
      out.write("                         border=0>\r\n");
      out.write("                </A>\r\n");
      out.write("            </TD>\r\n");
      out.write("            <TD><IMG height=48 alt=\"\" src=\"/testSSMStepByStep/images/crm_20.gif\" width=101></TD></TR>\r\n");
      out.write("        <TR>\r\n");
      out.write("            <TD colSpan=5 rowSpan=2><IMG height=132 alt=\"\"\r\n");
      out.write("                                         src=\"/testSSMStepByStep/images/crm_21.gif\" width=292></TD>\r\n");
      out.write("            <TD rowSpan=2><IMG height=132 alt=\"\" src=\"/testSSMStepByStep/images/crm_22.gif\"\r\n");
      out.write("                               width=170></TD>\r\n");
      out.write("            <TD colSpan=2><IMG height=75 alt=\"\" src=\"/testSSMStepByStep/images/crm_23.gif\"\r\n");
      out.write("                               width=332></TD></TR>\r\n");
      out.write("        <TR>\r\n");
      out.write("            <TD colSpan=2><IMG height=57 alt=\"\" src=\"/testSSMStepByStep/images/crm_24.gif\"\r\n");
      out.write("                               width=332></TD></TR>\r\n");
      out.write("        <TR>\r\n");
      out.write("            <TD><IMG height=1 alt=\"\" src=\"/testSSMStepByStep/images/spacer.gif\" width=59></TD>\r\n");
      out.write("            <TD><IMG height=1 alt=\"\" src=\"/testSSMStepByStep/images/spacer.gif\" width=127></TD>\r\n");
      out.write("            <TD><IMG height=1 alt=\"\" src=\"/testSSMStepByStep/images/spacer.gif\" width=24></TD>\r\n");
      out.write("            <TD><IMG height=1 alt=\"\" src=\"/testSSMStepByStep/images/spacer.gif\" width=86></TD>\r\n");
      out.write("            <TD><IMG height=1 alt=\"\" src=\"/testSSMStepByStep/images/spacer.gif\" width=21></TD>\r\n");
      out.write("            <TD><IMG height=1 alt=\"\" src=\"/testSSMStepByStep/images/spacer.gif\" width=28></TD>\r\n");
      out.write("            <TD><IMG height=1 alt=\"\" src=\"/testSSMStepByStep/images/spacer.gif\" width=56></TD>\r\n");
      out.write("            <TD><IMG height=1 alt=\"\" src=\"/testSSMStepByStep/images/spacer.gif\" width=101></TD>\r\n");
      out.write("            <TD><IMG height=1 alt=\"\" src=\"/testSSMStepByStep/images/spacer.gif\" width=170></TD>\r\n");
      out.write("            <TD><IMG height=1 alt=\"\" src=\"/testSSMStepByStep/images/spacer.gif\" width=125></TD>\r\n");
      out.write("            <TD><IMG height=1 alt=\"\" src=\"/testSSMStepByStep/images/spacer.gif\"\r\n");
      out.write("                     width=207></TD>\r\n");
      out.write("        </TR>\r\n");
      out.write("        </TBODY>\r\n");
      out.write("    </TABLE>\r\n");
      out.write("</FORM>\r\n");
      out.write("</BODY>\r\n");
      out.write("</HTML>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
