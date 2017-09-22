<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page contentType="text/html; charset=GBK" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登录博客</title>
    <link rel="SHORTCUT ICON" href="image/icon.png"/>
	<link href="CSS/index.css" rel="stylesheet" type="text/css" />
    <link href="CSS/login.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
    li{list-style-type:none;}
    </style>
  </head>
  
  <body>
  <!-- head -->
  <div id="head">
  <jsp:include page="head.jsp"></jsp:include>
  </div>
    <!-- 登录 -->
	<div class="loginwarrp">
		<div class="logo">账号登录</div>
        <div class="login_form">
        <script charset="GB2312" language="javascript">
			function isLoginOK(f)
			{
  					if(f.user_Id.value=="")
  						{
     						alert("登录名不能为空!");
	 						return false;
   						}
   						else if((f.passWd.value.length<3)||(f.passWd.value.length>18))
   						{
      						alert("密码必须是大于3小于18的数字或字母!");
	  						return false;
   						}
   						else{  
   						return true;  
   						}
			}
</script> 
			<form  action="LoginServlet" id="Login" name="Login" method="get" onsubmit="return isLoginOK(this);">
				<li class="login-item">
					<span>用户名：</span>
					<input type="text" name="user_Id" class="login_input">
				</li>
				<li class="login-item">
					<span>密　码：</span>
					<input type="password" name="passWd" class="login_input">
				</li>
				<div class="form-group">
					<label for="">请选择分类</label>
					<select name="check_select" class="form-select">
						<option value="">请选择分类</option>
						<option value="Administrator">管理员登录</option>
						<option value="USER">用户登录</option>
					</select>
				</div>
				<li class="login-sub">
					<input type="submit" name="Submit" value="登录" />
				</li>                          
           </form>
		</div>
	</div>
  </body>

</html>
