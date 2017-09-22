package com.duanle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.duanle.model.*;

public class LoginServlet extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
	    //�����û���������
	    String u=request.getParameter("user_Id");
	    String p=request.getParameter("passWd");
	    String actor=request.getParameter("check_select");
	    HttpSession session=request.getSession();
	    PrintWriter pw=response.getWriter();
	    AdminDO ado=new AdminDO();
	    UserBeanDO ubd=new UserBeanDO();
	    if(actor.equals("Administrator"))
	    {
	    if(ado.checkAdmin(u, p)){
	   // session.setAttribute("result", "��¼�ɹ�!");
	    session.setAttribute("user_Id", u);
	    response.sendRedirect("reviewed.jsp");
	    }else{
	    	pw.write("<script language='javascript'> alert(\"����Ա�����ڣ������������!\");window.location.href='"+request.getContextPath()+"/Login.jsp';</script>");
	    	//session.setAttribute("result", "����Ա�����ڣ������������!");
	    	//request.getRequestDispatcher("Login.jsp").forward(request, response);
	    	
	    }
	    }
	    else if(actor.equals("USER"))
	    {
	    	if(ubd.checkUser(u, p)){
	    	session.setAttribute("user_Id", u);
	    	response.sendRedirect("main.jsp");
	    	}
	    	else{
	    		pw.write("<script language='javascript'> alert(\"�û������ڣ�����ע��!\");window.location.href='"+request.getContextPath()+"/register.jsp';</script>");	    		
	    		//request.getRequestDispatcher("register.jsp").forward(request, response);
	    }
	    }
	    else{
	    	pw.write("<script language='javascript'> alert(\"��ѡ�����!\");window.location.href='"+request.getContextPath()+"/Login.jsp';</script>");
	    	
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
