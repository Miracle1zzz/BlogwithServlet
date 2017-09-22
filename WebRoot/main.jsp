<%@page import="com.duanle.util.Tools"%>
<%@ page language="java" import="java.util.*,com.duanle.model.*,java.text.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="SHORTCUT ICON" href="image/icon.png"/>
        <link href="CSS/main.css" rel="stylesheet" type="text/css" />
        <link href="CSS/index.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="CSS/content.css" />
    <title>个人博客</title>
  </head>
  
  <body>
  <%
      //防止用户非法登陆
      String u=(String)session.getAttribute("user_Id");
      
      //如果用户没有登录
      if(u==null){
      %>
      <script> 
            alert("你还没有登录！请先登录！");
            window.location.href="Login.jsp";
        </script>
      <% 
       return ;
      }
      UserBeanDO ubd=new UserBeanDO();
	    ArrayList alx=ubd.getUsers(u);
	    for(int i=0;i<alx.size();i++){
	    UserBean ub=(UserBean)alx.get(i);
   %>
    <div class="all">
       <div class="header-menu-left">
    <div class="header-logo"><a href="index.jsp"><i>D</i><h3 style="font-size: 25px;color:#fff;">论坛</h3></a></div>
    </div>
    <div class="header-user">
				<p class="user-name"><a style="font-size:14px;text-align:right;color:#ADADAD;text-decoration: none;" href="Update.jsp?action=update&user_Id=<%=u%>&user_pwd=<%=ub.getUser_pwd()%>&user_face=<%=ub.getUser_face()%>&user_qq=<%=ub.getUser_qq()%>&user_email=<%=ub.getUser_email()%>"><%=u%></a>
				<span>用户您好！<a style="font-size:14px;text-align:right;color:#ADADAD;text-decoration: none;"href="index.jsp">退出</a></span></p>
	</div>
	<%} %>
  <!-- top显示 -->
    <div id="top" style="height: 265px;">
    <img alt="" src="image/banner_top.jpg" style="width: 100%;height: 80%;">
    </div>
    <!-- 导航栏 -->
    <div ></div>
    <div id="menu">
    <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="1000" height="40">
      <param name="movie" value="image/menu.swf">
      <param name="quality" value="high">
      <embed src="image/menu.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="1000" height="40"></embed>
    </object>
    </div>
	<div class="hotmess">
<div class="hotmess-left">
<div class="title-image">
<img alt="" src="image/menu-plus.png" style="width: 6px;height:100%;">
</div>
<div class="title">
    <h3>我的帖子>></h3>
  </div>
  <%
 int pageNow=1;  
String s_pageNow=request.getParameter("pageNow");
if(s_pageNow!=null){
      pageNow=Integer.parseInt(s_pageNow);
    }
    int pageSize = 5;
    String sql="select top "+pageSize+" * from infoList where Introduced_per='"+u+"'";
    InfoListDO ild=new InfoListDO();
     ArrayList al=ild.getUsersByPage(pageNow, sql);
     for(int m=0;m<al.size();m++){
     InfoList il=(InfoList)al.get(m);
       String Maintext=il.getMaintext();
       if(Maintext.length()>100){
       Maintext=Maintext.substring(0,100)+"...";
       }
 %>
 <table width="81%" height="161" border="0">
  <tr>
    <td width="26%" rowspan="3"><img alt="" src="<%=il.getTitleimage()%>" style="width: 100%;height: 100%;"></td>
    <td width="74%" height="37" colspan="3"><a style="font-size: 20px;color:#666666;text-decoration: none;"href="#"><%=il.getTitle() %></a></td>
  </tr>
  <tr>
    <td height="26">作者：<%=il.getIntroduced_per() %></td>
    <td>上传时间：<%=il.getIntroduced_date() %></td>
    <td>分类：<%=il.getCategory() %></td>
  </tr>
  <tr>
    <td colspan="2"><%=Maintext%></td>
    <td width="20%">
    <a href="DelServlet?action=delete&ID=<%=il.getID() %>">删除</a>
    <a href="javascript:void(0)">详情>></a></td>
  </tr>
</table>
  </div>
</div>
</div>
<%}%>
<center>
<div class="table-fun">
<%
  String sql_page="select count(*) from infoList where Introduced_per='"+u+"'";
  if(pageNow!=1){
     out.println("<a href=main.jsp?pageNow="+(pageNow-1)+">上页</a>"); 
  }
  int pageCount=ild.getPageCount(sql_page);
  for(int n=1;n<=pageCount;n++){
   out.println("<a href=main.jsp?pageNow="+n+">["+n+"]</a>");
  }
  if(pageNow!=pageCount&&pageCount>1){
     out.println("<a href=main.jsp?pageNow="+(pageNow+1)+">下页</a>"); 
  }
  int rowCount=ild.getrowCount(sql_page);
  if(rowCount==0){
  %>
  <div> 
            <p style="font-size: 20px;color:red;">你还没有发布帖子！</p>
  </div>
  <%
  }
  %>
  
</div>
</center>
<div class="monner">
<img alt="" src="image/monner.jpg" style="width: 100%;height: 212px;">
</div>
<div class="title-image">
<img alt="" src="image/menu-plus.png" style="height:100%;">
</div>
<div class="title">
    <h3>发&nbsp;&nbsp;帖>></h3>
  </div>

    <%
    String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //获取系统时间 
     %>
	<div class="container">
			<div class="public-content-cont">
			<form action="inforListServlet" method="get">
				<div class="form-group">
					<label for="">信息分类</label>
					<input class="form-input-txt" type="text" name="Category" value="" />
				</div>
				<div class="form-group">
					<label for="">信息标题</label>
					<input class="form-input-txt" type="text" name="title" value="" />
				</div>
				<div class="form-group">
					<label for="">标题图像:</label>
					<select name="titleimage" class="form-select" size=1 onChange="document.images['titleimage'].src=options[selectedIndex].value;">
						<option value="image/face/1.jpg">1</option>
						<option value="image/face/2.jpg">2</option>
						<option value="image/face/3.jpg">3</option>
						<option value="image/face/4.jpg">4</option>
						<option value="image/face/5.jpg">5</option>
						<option value="image/face/6.jpg">6</option>
						<option value="image/face/7.jpg">7</option>
						<option value="image/face/8.jpg">8</option>
						<option value="image/face/9.jpg">9</option>
						<option value="image/face/10.jpg">10</option>
						<option value="image/face/11.jpg">11</option>
						<option value="image/face/12.jpg">12</option>
					</select>
                 &nbsp;<img id="titleimage" src="image/face/1.jpg" style="height: 120px;width:180px">
				</div>
			  <div class="form-group">
				<label for="">正文内容</label>
					<textarea id="editor_id" name="Maintext"  class="form-input-textara" style="width:700px;height:300px;">
						
					</textarea> 
				</div>
			  <div class="form-group">
					<label for="">发布人</label>
					<input class="form-input-txt" type="text" name="Introduced_per" value="<%=u%>" readonly="readonly" />
				</div>
			  <div class="form-group">
			    <label for="">发布时间</label>
					<input class="form-input-txt" name="Introduced_date" value="<%=datetime%>" readonly="readonly">
				</div>
				<div class="form-group" style="margin-left:150px;">
					<input type="submit" class="sub-btn" value="提  交" />
					<input type="reset" class="sub-btn" value="重  置" />
				</div>
			  </form>
			</div>
		</div>
		
  </body>
<div class="footer">
<p>Copyright &copy; 2017.Company name All rights reserved.
</p>
</div>

  </body>
</html>
