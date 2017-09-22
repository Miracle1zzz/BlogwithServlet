<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*,com.duanle.model.*" pageEncoding="utf-8"%>
<!-- 引入jstl标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
        <link href="CSS/main.css" rel="stylesheet" type="text/css" />
        <link href="CSS/index.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="CSS/content.css" />
        <link rel="stylesheet" href="CSS/Anscss.css" />
        <link rel="SHORTCUT ICON" href="image/icon.png"/>    
        <script type="text/javascript" src="js/jquery.min.js"></script>
        
        <script type="text/javascript">
$(function(){
	$(".hf").click(function(){	
		var focus = $(this).parents(".wrapper").find("#focus");
		if(focus.css("display")=="none")
		{
		   focus.show();this.innerHTML = "收起";
		}else
		{
		  focus.hide(); this.innerHTML = "回复";
		}
    });
	$("form").submit(function(){
	   var textarea = $(this).find("#textarea");
	   if(textarea.val()==""||textarea.val()=="请输入内容")
	   {
	      textarea.blur();
	      return false;
	   }
	});
});

</script>
    <title>留言板</title>
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
	    ArrayList alm=ubd.getUsers(u);
	    for(int i=0;i<alm.size();i++){
	    UserBean ub=(UserBean)alm.get(i);
   %>
   
    <div class="all">
       <div class="header-menu-left">
    <div class="header-logo"><a href="index.jsp"><i>D</i><h3 style="font-size: 25px;color:#fff;">论坛</h3></a></div>
    </div>
    <div class="header-user">
				<p class="user-name"><a style="font-size:14px;text-align:right;color:#ADADAD;text-decoration: none;" href="Update.jsp?action=update&user_Id=<%=u%>&user_pwd=<%=ub.getUser_pwd()%>&user_face=<%=ub.getUser_face()%>&user_qq=<%=ub.getUser_qq()%>&user_email=<%=ub.getUser_email()%>"><%=u%></a>
				<span>用户您好！<a style="font-size:14px;text-align:right;color:#ADADAD;text-decoration: none;"href="Login.jsp">退出</a></span></p>
	</div>
	<%} %>
  <!-- top显示 -->
    <div id="top" style="height: 265px;">
    <img alt="" src="image/banner_top.jpg" style="width: 100%;height: 85%;">
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
    <div class="Message_border" style="height: 300px">
    <div class="title-image">
<img alt="" src="image/menu-plus.png" style="width: 6px;height:100%;">
</div>
<%
    String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //获取系统时间 
     %>
<div class="title">
    <h3>快点留下你的脚印吧！>></h3>
  </div>
    <form action="AddMessageServlet" method="get">
    <div class="form-group">
			    <label for="">发布时间</label>
					<input class="form-input-txt" name="message_date" value="<%=datetime%>" readonly="readonly">
				</div>
    <div class="form-group">
			    <label for="">留言内容：</label>
					<textarea class="form-input-textara" type="text" name="messageContent" placeholder="我有话说（少于500字）"></textarea>
				</div>
				<div class="clearfix"></div>
			  <div class="form-group" style="margin-left:150px;">
					<input type="submit" class="sub-btn" value="提  交" />
					<input type="reset" class="sub-btn" value="重  置" />
				</div>
				</form>
				</div>
<div class="title-image">
<img alt="" src="image/menu-plus.png" style="width: 6px;height:100%;">
</div>
<div class="title">
    <h3>最新留言>></h3>
  </div>
  <%

 int pageNow=1;  
String s_pageNow=request.getParameter("pageNow");
if(s_pageNow!=null){
      pageNow=Integer.parseInt(s_pageNow);
    }
    int pageSize = 5;
    String sql="select top "+pageSize+" * from Message where ID not in(select top "+pageSize*(pageNow-1)+" ID from Message)";
    MessageListDO mld=new MessageListDO();
    Mess_replyDO mrd=new Mess_replyDO();
    	
     ArrayList al=mld.getUsersByPage(pageNow, sql);
     for(int i=0;i<al.size();i++){
     MessageList il=(MessageList)al.get(i);
       String MessageContent=il.getMessageContent();
       if(MessageContent.length()>100){
       MessageContent=MessageContent.substring(0,100)+"...";
       }
       String ID=(String)il.getID();

 %>
<div class="wrapper">
		<div class="top01-hf"  style="width:658px;">
		  <table width="90%" border="0" align="center">
		    <tr>
		      <td width="8%" rowspan="2"><img alt="" src="<%=il.getUser_face()%>" style="width: 100%;height: 100%;"></td>
		      <td colspan="2" style="color:#44708E;font-size: 15px;"><strong><%=il.getUser_id() %></strong></td>
	        </tr>
		    <tr>
		      <td colspan="2" style="font-size: 20px;color:#666666;text-decoration: none;"><b><%=il.getMessageContent()%></b></td>
	        </tr>
	      </table>
			<p class="p2"><a href="javascript:;" class="hf">回复</a><a><%=il.getMessage_date() %></a></p>
		</div>
		<div id="focus" style="display:none">
		  <form action="Mess_replyServlet?ID=<%=il.getID() %>" method="post">
			<textarea class="textarea" onfocus="if(this.innerHTML=='请输入内容'){this.innerHTML=''}"  onblur="if(this.innerHTML==''){this.innerHTML='请输入内容'}" name="textarea" id="textarea"></textarea>
			<input type="submit" id="submit" value="请输入内容"/>
		  </form>
		</div>
	</div>
	<%

	ArrayList alx=mrd.getMess_replyByPage(ID);
        for(int m=0;m<alx.size();m++){
     Mess_reply ilx=(Mess_reply)alx.get(m);
	 %>
	<div class="wrapper">
		<div class="top01-hf"  style="width:658px;">
		  <table width="90%" border="0" align="center"style="float: right;">
		    <tr>
		      <td width="8%" rowspan="2"><img alt="" src="<%=ilx.getUser_face()%>" style="width: 100%;height: 100%;"></td>
		      <td width="45%" style="color:#44708E;font-size: 15px;"><b><%=ilx.getUser_id() %></b></td>
		      <td width="45%" style="color:#ccc;"><%=ilx.getMess_reply_date() %></td>
	        </tr>
		    <tr>
		      <td colspan="2"style="font-size: 20px;color:#666666;text-decoration: none;"><b><%=ilx.getMess_reply_content() %></b></td>
	        </tr>
	      </table>
		</div>
		
	</div>
  </div>
<%} 
}%>
<center>
<div class="table-fun">
<%
  if(pageNow!=1){
     out.println("<a href=information.jsp?pageNow="+(pageNow-1)+">上页</a>"); 
  }
  int pageCount=mld.getPageCount();
  for(int i=1;i<=pageCount;i++){
   out.println("<a href=information.jsp?pageNow="+i+">["+i+"]</a>");
  }
  if(pageNow!=pageCount&&pageCount>1){
     out.println("<a href=information.jsp?pageNow="+(pageNow+1)+">下页</a>"); 
  }
  int rowCount=mld.getrowCount();
  if(rowCount==0){
  %>
  <div> 
            <p style="font-size: 20px;color:red;">您还没有留言！</p>
  </div>
  <%
  }
  %>
</div>
<div class="footer">
<p>Copyright &copy; 2017.Company name All rights reserved.
</p>
</div>
</center>
  </body>
</html>
