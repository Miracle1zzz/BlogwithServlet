package com.duanle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duanle.model.UserBean;
import com.duanle.model.UserBeanDO;

public class servlet extends HttpServlet {

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

		PrintWriter pw=response.getWriter();
	    String user_id=request.getParameter("user_id");
	    UserBeanDO ubd=new UserBeanDO();
	    UserBean ub=new UserBean();
	    //判断用户名是否被使用
	    ArrayList al=ubd.getUsers(user_id);
	    for(int i=0;i<al.size();i++){
	    ub=(UserBean)al.get(i);
	    if(ub.getUser_id().equals(user_id)){
	    	
	    	pw.print(true);
		}
		else{
			pw.print(false);
			 
			
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
