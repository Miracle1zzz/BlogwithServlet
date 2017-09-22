package com.duanle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.duanle.model.UserBean;
import com.duanle.model.UserBeanDO;
import com.duanle.util.Tools;

public class RegisterServlet extends HttpServlet {

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
	    String user_id=request.getParameter("user_id");
	    PrintWriter pw=response.getWriter();
	    PrintWriter out=response.getWriter();
	   String user_face=request.getParameter("face");
	    String user_pwd=request.getParameter("password");
	    String user_sex=Tools.toChinese(request.getParameter("userSex"));
	    String user_qq=request.getParameter("userQQ");
	    String user_email=request.getParameter("userEmail");
	    
	    HttpSession session=request.getSession();
	    session.setMaxInactiveInterval(Integer.MAX_VALUE);
	    UserBeanDO ubd=new UserBeanDO();
	    UserBean ub=new UserBean();
	    //判断用户名是否被使用
	    ArrayList al=ubd.getUsers(user_id);
	   /* for(int i=0;i<al.size();i++){
	    ub=(UserBean)al.get(i);
	    
	    if(ub.getUser_id().equals(user_id)){
	    	pw.print(true);
		}
		else{
			pw.print(false);
			 
			
		}
	   
	    }*/
	    if(ubd.addUser(user_id, user_pwd, user_face, user_sex, user_qq, user_email)){
 			session.setAttribute("user_face", user_face);
 			out.print("<script> alert(\"注册成功，将跳转登录界面!\");window.location.href='"+request.getContextPath()+"/Login.jsp'; </script>");
 		}
 		else{
 			out.print("<script> alert(\"注册失败，将返回注册界面!\");window.location.href='"+request.getContextPath()+"/register.jsp'; </script>");
 	
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
		this.doGet(request, response);
	}

}
