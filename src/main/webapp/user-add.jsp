<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>添加用户</title>
    <link rel="stylesheet" type="text/css" href="/skin/css/base.css">
</head>

<script>

    /*表单的onsubmit属性，在表单提交前检查表单的参数内容，若为false，则无法提交！*/
    function validateForm() {
        //    校验表单
       /* var name = document.getElementById("name").value;
        if (name == "" || name.trim().length == 0) {
            alert("客户名称不能为空！！！");
            return false;
        }

        //校验公司名称
        var genderjudge = false;
        var gender = document.getElementsByName("gender");


        for (var i = 0; i < gender.length; i++) {
            //console.log(gender[i].value);
            // console.log(gender[i].checked);
            if (gender[i].checked) {
                genderjudge = true;
                break
            }
        }
        //console.log(genderjudge)
        if (genderjudge == false) {
            alert("请选择你的性别！");
            return false;
        }

        //校验生日

        var birthday = document.getElementById("birthday").value;
        console.log(birthday)
        if (birthday == "") {
            alert("请选择你的生日！");
            return false;
        }

        //    校验手机号
        var cellphone = document.getElementById("cellphone").value;
        if (cellphone.match("^1(3|4|5|7|8|9)\\d{9}$") == null) {
            alert("手机号格式有误！");
            return false;
        }

        //校验邮箱
        var email = document.getElementById("email");
        console.log(email.value);
        //var reg = "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$";
        var reg = "\\w+@(\\w+.)+[a-z]{2,3}";
        if (email.value == "") {
            alert("邮箱为空!")
            return false;
        }
        if (email.value.match(reg) == null) {
            alert("请输入正确的邮箱格式！")
            return false;
        }

        //校验爱好
        var hobbyjudge = false;
        var hobby = document.getElementsByName("hobby");
        for (var i = 0; i < hobby.length; i++) {
            if (hobby[i].checked) {
                hobbyjudge = true;
                break;
            }
        }
        if (hobbyjudge == false) {
            var ishobby = confirm("你确定没有爱好吗？");
            if (!ishobby) {
                return false;
            }
        }

        //验证type
        var type = document.getElementById("type").value;
        console.log(type)
        if (type == "普通用户") {
            var istype = confirm("你确定你是普通用户吗？");
            if (!istype) {
                return false;
            }
        }

        //验证描述
        var description = document.getElementById("description").value;
        if (description == "" || description.trim().length == 0) {
            alert("请输入正确的描述！");
            return false;
        }*/

        //验证提交

        var issub = confirm("确定要提交吗？");
        if (!issub) {
            return false;
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
                        当前位置:权限管理>>添加用户信息
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form name="form2" method="post" action="/testSSMStepByStep/addUser.do" onsubmit="return validateForm()";>

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="2" background="/skin/images/tbg.gif">&nbsp;添加用户&nbsp;</td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">职位：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="position">
                <option value="初级开发工程师">初级开发工程师</option>
                <option value="中级开发工程师">中级开发工程师</option>
                <option value="高级开发工程师">高级开发工程师</option>
                <option value="项目经理">项目经理</option>
                <option value="其它">其它</option>
            </select>
            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">姓名：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="userName"/>
                </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">性别：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="gender">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">年龄：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="age"/>
            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="cellPhone"/>
            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">入职时间：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="addTime"/>
            </td>
        </tr>
        <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">身份证号码：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="idCard"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">赋角色：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">




               <%--此处值是插角色表查出来的！--%>
                <c:forEach var="role" items="${queRoleAndtoUserAddjsp}">
                   <input type="radio" name="role" value="${role.r_id}"/>${role.roleName}
                </c:forEach>



            </td>
        </tr>

        <tr >
            <td align="right" bgcolor="#FAFAF1" >备注：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
                <textarea rows=10 cols=130 name="remarks"></textarea>
            </td>
        </tr>


        <tr bgcolor="#FAFAF1">
            <td height="28" colspan=4 align=center>
                &nbsp;
                <%--<a href="user.html" class="coolbg">添加</a>--%>
                <input type="submit" value="保存" class="coolbg">
                <a href="/testSSMStepByStep/queUser.do?pageNum=1&&conditionname=username&&conditionvalue=&&orderByMethod=initiationtime" class="coolbg">返回</a>

            </td>
        </tr>
    </table>

</form>


</body>
</html>
