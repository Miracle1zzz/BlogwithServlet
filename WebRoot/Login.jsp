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
    <title>��¼����</title>
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
    <!-- ��¼ -->
	<div class="loginwarrp">
		<div class="logo">�˺ŵ�¼</div>
        <div class="login_form">
        <script charset="GB2312" language="javascript">
			function isLoginOK(f)
			{
  					if(f.user_Id.value=="")
  						{
     						alert("��¼������Ϊ��!");
	 						return false;
   						}
   						else if((f.passWd.value.length<3)||(f.passWd.value.length>18))
   						{
      						alert("��������Ǵ���3С��18�����ֻ���ĸ!");
	  						return false;
   						}
   						else{  
   						return true;  
   						}
			}
</script> 
			<form  action="LoginServlet" id="Login" name="Login" method="get" onsubmit="return isLoginOK(this);">
				<li class="login-item">
					<span>�û�����</span>
					<input type="text" name="user_Id" class="login_input">
				</li>
				<li class="login-item">
					<span>�ܡ��룺</span>
					<input type="password" name="passWd" class="login_input">
				</li>
				<div class="form-group">
					<label for="">��ѡ�����</label>
					<select name="check_select" class="form-select">
						<option value="">��ѡ�����</option>
						<option value="Administrator">����Ա��¼</option>
						<option value="USER">�û���¼</option>
					</select>
				</div>
				<li class="login-sub">
					<input type="submit" name="Submit" value="��¼" />
				</li>                          
           </form>
		</div>
	</div>
  </body>

</html>
