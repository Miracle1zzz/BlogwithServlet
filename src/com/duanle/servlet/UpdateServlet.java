package com.duanle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.duanle.model.UserBeanDO;
import com.duanle.util.Tools;

public class UpdateServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=GBK");
	    String user_Id=request.getParameter("user_Id");
	    String user_face=request.getParameter("face");
	    String user_pwd=request.getParameter("password");
	    String user_sex=Tools.toChinese(request.getParameter("userSex"));
	    String user_qq=request.getParameter("userQQ");
	    String user_email=request.getParameter("userEmail");
	    PrintWriter out=response.getWriter();
	    HttpSession session=request.getSession();
	    UserBeanDO ubd=new UserBeanDO();
	    
		if(ubd.updateUser(user_Id, user_pwd, user_face, user_sex, user_qq, user_email)){
			out.print("<script> alert(\"修改成功，将跳转登录界面!\");window.location.href='"+request.getContextPath()+"/Login.jsp'; </script>");
		}
		else{
			out.print("<script> alert(\"修改失败，将返回修改界面!\");window.location.href='"+request.getContextPath()+"/Update.jsp'; </script>");
	
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
