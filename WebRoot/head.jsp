<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="SHORTCUT ICON" href="image/icon.png"/>
  <link href="CSS/index.css" rel="stylesheet" type="text/css" />
    <link href="CSS/index_div.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
    <div id="all">
    <!-- top显示 -->
    <div id="top" style="height:265px; ">
    <img alt="" src="image/banner_top.jpg" style="width: 100%;height: 100%;">
    </div>
    <!-- 导航栏 -->
    <div id="menu">
    <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="1000" height="40">
      <param name="movie" value="image/menu.swf">
      <param name="quality" value="high">
      <embed src="image/menu.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="1000" height="40"></embed>
    </object>
    </div>
    </div>
  </body>
</html>
