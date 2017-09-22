<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    <link rel="SHORTCUT ICON" href="image/icon.png"/>
    <link rel="stylesheet" href="CSS/login.css" />
    <link rel="stylesheet" href="CSS/index.css" />
    <style type="text/css">
    li{list-style-type:none;}
    </style>
    <script language="javascript">
    function isRight(f){
  if(f.user_Id.value == "")
  {
     alert("注册名不能为空!");
	 return false;
   }
   else if(f.user_Id.value.length>20)
   {
     alert("注册名必须小于20!");
	 return false;
   }
   else if((f.password.value.length<3)||(f.password.value.length>18))
   {
      alert("密码必须是大于3小于18的数字或字母!");
	  return false;
   }
  else if(f.password.value != f.password1.value)
  {
      alert("两次输入的密码不同!");
	  return false;
  }	
   else if((f.userQQ.value.length>15)||(f.userQQ.value.length<3))
   {
      alert("QQ号码必须大于3小于15!");
	  return false;
   }
  else if((f.userEmail.value == "")||(f.userEmail.value.indexOf('@',0) == -1)||(f.userEmail.value.indexOf('.',0) == -1))
  {
      alert("请输入合法的邮箱地址!");
	  return false;
  }
  else
  { 
     return true;
   }
  
}
 </script>
 <script type="text/javascript">
	window.onload=function()
    {
      var nameElement=document.getElementsByName("user_id")[0];
      //为昵称选项注册onblur事件
      nameElement.onblur=function()
      {
        var user_id=this.value;
        //1.获取XMLHttpRequest对象
        var req=getXMLHttpRequest();
        //4.处理响应结果
        req.onreadystatechange=function(){
          if(req.readyState==4){//XMLHttpRequest对象读取成功
            if(req.status==200){//服务器相应正常
              var msg1=document.getElementById("msg1");
              //根据返回的结果显示不同的信息
              if(req.responseText=="true"){
                msg1.innerHTML="<font color='red'>该昵称已注册</font>";
              }else{
                msg1.innerHTML="<font color='green'>可以使用</font>";
              }
            }
          }
        }
        //2.建立一个连接
        req.open("get","${pageContext.request.contextPath}/servlet/servlet?user_id="+user_id);
        //3.发送get请求
        req.send(null);
      }
    }
	</script>
	<script type="text/javascript">
	
	function getXMLHttpRequest(){
  var xmlhttp;
    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
      xmlhttp = new XMLHttpRequest();
    } else {// code for IE6, IE5
      xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xmlhttp;
}
	</script>

  </head>
  
  <body>
  <!-- head -->
  <div id="head">
    <jsp:include page="head.jsp"></jsp:include>
    </div>
    <!-- 注册 -->
    <div id="all">
    <div class="loginwarrp">
		<div class="logo">新用户注册:（带'*'的内容必须填写）</div>
        <div class="login_form">
			<form id="Login" method="get"  onsubmit="return isRight(this);" action="RegisterServlet">
				<li class="login-item">登 录 名<span>：</span>
					<input type="text" name="user_id" class="login_input">
					<span id="msg1">请输入昵称</span>
				</li>
                <li class="login-item">密 码<span>：</span>
					<input type="password" name="password" class="login_input">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*
				</li>
				<li class="login-item">密码确认<span>：</span>
					<input type="password" name="password1" class="login_input"/>&nbsp;&nbsp;*
				</li>
				<li class="login-item">头像<span>：</span>
					<select  name="face" size=1 onChange="document.images['face'].src=options[selectedIndex].value;" style="BACKGROUND-COLOR: #99CCFF; BORDER-BOTTOM: 1px double; BORDER-LEFT: 1px double; BORDER-RIGHT: 1px double; BORDER-TOP: 1px double; COLOR: #000000">

					<option value="image/faceImage1.gif">Image1</option>
					<option value="image/face/Image2.gif">Image2</option>
					<option value="image/face/Image3.gif">Image3</option>
					<option value="image/face/Image4.gif">Image4</option>
					<option value="image/face/Image5.gif">Image5</option>
					<option value="image/face/Image6.gif">Image6</option>
					<option value="image/face/Image7.gif">Image7</option>
					<option value="image/face/Image8.gif">Image8</option>
					<option value="image/face/Image9.gif">Image9</option>
					<option value="image/face/Image10.gif">Image10</option>
					<option value="image/face/Image11.jpg">Imag11</option>
					<option value="image/face/Image12.jpg">Image12</option>
					<option value="image/face/Image13.jpg">Image13</option>
					<option value="image/face/Image14.jpg">Image14</option>
					<option value="image/face/Image15.jpg">Image15</option>
					<option value="image/face/Image16.jpg">Image16</option>
					<option value="image/face/Image17.jpg">Image17</option>
					<option value="image/face/Image18.jpg">Image18</option>
					
					</select>
					&nbsp;<img id="face" src="image/face/Image1.gif">
				</li>
				<li class="login-item">性别<span>：</span>
					<input type="radio" name="userSex" value="男" checked="checked" />男
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="userSex" value="女"/>女
				</li>

				<li class="login-item">
					<span>Q Q：</span>
					<input type="text" name="userQQ" class="login_input"/>
				</li>
				<li class="login-item">
					邮箱地址<span>：</span>
					<input type="text" name="userEmail" class="login_input"/>&nbsp;&nbsp;*
				</li>
				
			  <div class="clearfix"></div>
				<li class="login-sub">
					<input type="submit" name="Submit" value="确认" />
				</li>
                <div style="text-align:right;color:#ADADAD;"><a href="Login.jsp">返回登录?</a></div>                             
           </form>
		</div>
	</div>
    </div>
  </body>
</html>
