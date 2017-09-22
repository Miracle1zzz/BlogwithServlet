package com.duanle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.duanle.model.MessageList;
import com.duanle.model.MessageListDO;
import com.duanle.model.UserBean;
import com.duanle.model.UserBeanDO;
import com.duanle.util.Tools;

public class AddMessageServlet extends HttpServlet {

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
		HttpSession session=request.getSession();
	    PrintWriter out=response.getWriter();
	    
	    String user_id=(String)session.getAttribute("user_Id");
	   
	    String messageContent=Tools.toChinese(request.getParameter("messageContent"));
	    String message_date=request.getParameter("message_date");
	    MessageListDO mld=new MessageListDO();
	    
	    UserBeanDO ubd=new UserBeanDO();
	    ArrayList al=ubd.getUsers(user_id);
	    for(int i=0;i<al.size();i++){
	    UserBean ub=(UserBean)al.get(i);
	    String user_face=(String)ub.getUser_face();
	
	    
	    String ID=Integer.toString(mld.getrowCount()+1);
	    if(mld.addMessage(ID, user_id, user_face, messageContent, message_date)){
	    	out.write("<script language='javascript'> alert(\"¡Ù—‘ÕÍ≥…!\");window.location.href='"+request.getContextPath()+"/information.jsp';</script>");
	    }
	    else{
	    	out.write("<script language='javascript'> alert(\"¡Ù—‘ ß∞‹!\");window.location.href='"+request.getContextPath()+"/information.jsp';</script>");
	    }
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
