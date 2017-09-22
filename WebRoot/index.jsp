<%@page import="com.duanle.util.Tools"%>
<%@page import="com.duanle.model.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>博客--记录</title>
    <link rel="SHORTCUT ICON" href="image/icon.png"/>
    <link href="CSS/index_div.css" rel="stylesheet" type="text/css" />
    <link href="CSS/index.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="CSS/content.css" />
 	<script src="js/jquery.min.js"></script>
    <script src="js/jquery.luara.0.0.1.min.js"></script>
    
  </head>

  <body>
  <div class="head-menu">
  <div class="header-logo"><a href="index.jsp"><i>D</i><h3 style="font-size: 25px;color:#fff;">论坛</h3></a></div>
  </div>
 <div id="head">
    <jsp:include page="head.jsp"></jsp:include>
    </div>
    <div class="index-right">
	<div class="example1">
        <ul>
            <li><img src="image/slider-1.jpg" alt="1"/></li>
            <li><img src="image/slider-2.jpg" alt="2"/></li>
            <li><img src="image/slider-3.jpg" alt="3"/></li>
            <li><img src="image/slider-4.jpg" alt="4"/></li>
            <li><img src="image/slider-5.jpg" alt="5"/></li>
        </ul>
        <ol>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ol>
    </div>
    
    <script>
        $(function(){
            $(".example1").luara({width:"100%",height:"350",interval:5000,selected:"seleted",deriction:"top"});

        });
    </script>
    </div>
<div class="index-left">
<img alt="" src="image/banner.jpg" style="width:100%;height:350px;">
    <div class="mess">
<marquee direction="up" height="220" width="100%" scrollamount="3">
<p><font style="font-size:20px;color:#666666;">从明天起<br>做一个幸福的人<br>喂马，劈柴，周游世界<br>从明天起<br>关心粮食和蔬菜<br>面朝大海，春暖花开<br>——《面朝大海 春暖花开》</font></p>
</marquee>
</div>
</div>
<div class="hotmess">
<div class="hotmess-left">
<div class="title-image">
<img alt="" src="image/menu-plus.png" style="height:100%;">
</div>
<div class="title">
    <h3>最新帖子>></h3>
  </div>
  <%

 int pageNow=1;  
String s_pageNow=request.getParameter("pageNow");
if(s_pageNow!=null){
      pageNow=Integer.parseInt(s_pageNow);
    }
    int pageSize = 5;
    String sql="select top "+pageSize+" * from infoList where ID not in(select top "+pageSize*(pageNow-1)+" ID from infoList)";
    InfoListDO ild=new InfoListDO();
     ArrayList al=ild.getUsersByPage(pageNow, sql);
     for(int i=0;i<al.size();i++){
     InfoList il=(InfoList)al.get(i);
       String Maintext=il.getMaintext();
       if(Maintext.length()>100){
       Maintext=Maintext.substring(0,100)+"...";
       }
 %>
 <table width="81%" height="161" border="0">
  <tr>
    <td width="26%" rowspan="3"><img alt="" src="<%=il.getTitleimage() %>" style="width: 100%;height: 100%;"></td>
    <td width="74%" height="37" colspan="3"><a style="font-size: 20px;color:#666666;text-decoration: none;"href="#"><%=il.getTitle() %></a></td>
  </tr>
  <tr>
    <td height="26">作者：<%=il.getIntroduced_per() %>;</td>
    <td>上传时间：<%=il.getIntroduced_date() %></td>
    <td>分类：<%=il.getCategory() %></td>
  </tr>
  <tr>
    <td colspan="2"><%=Maintext%></td>
    <td width="20%"><a href="javascript:void(0)">详情>></a></td>
  </tr>
</table>
  </div>
</div>
<%} %>
<center>
<div class="table-fun">
<%
  String sql_page="select count(*) from infoList";
  if(pageNow!=1){
     out.println("<a href=index.jsp?pageNow="+(pageNow-1)+">上页</a>"); 
  }
   
  int pageCount=ild.getPageCount(sql_page);
 
  for(int i=1;i<=pageCount;i++){
   out.println("<a href=index.jsp?pageNow="+i+">["+i+"]</a>");
  }
  if(pageNow!=pageCount&&pageCount>1){
     out.println("<a href=index.jsp?pageNow="+(pageNow+1)+">下页</a>"); 
  }
  %>
</div>
</center>
<div class="footer">
<p>Copyright &copy; 2017.Company name All rights reserved.
</p>
</div>
  </body>
</html>
