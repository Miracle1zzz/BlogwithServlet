package com.duanle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.duanle.model.*;
import com.duanle.util.Tools;

public class DelServlet extends HttpServlet {

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
		String action=request.getParameter("action");
		String ID=request.getParameter("ID");
		String Mess_ID=request.getParameter("Mess_ID");
		String reviewed_ID=request.getParameter("reviewed_ID");
	    PrintWriter out=response.getWriter();
	    if(action==null) action="";
	    if(action.equals("delete")){
	    InfoListDO ild=new InfoListDO();
	    
	    if(ild.DelInformation(ID)){
    		out.write("<script language='javascript'> alert(\"É¾³ý³É¹¦£¡\");window.location.href='"+request.getContextPath()+"/main.jsp';</script>");
	    }
	    else{
    		out.write("<script language='javascript'> alert(\"É¾³ýÊ§°Ü£¡\");window.location.href='"+request.getContextPath()+"/main.jsp';</script>");
    	}
	    }
	    else if(action.equals("delete_mess")){//É¾³ýÁôÑÔ
	    	MessageListDO mld=new MessageListDO();
	    	if(mld.DelMessage(Mess_ID)){
	    		out.write("<script language='javascript'> alert(\"É¾³ý³É¹¦£¡\");window.location.href='"+request.getContextPath()+"/information.jsp';</script>");
	    	}
	    	else{
	    		out.write("<script language='javascript'> alert(\"É¾³ýÊ§°Ü£¡\");window.location.href='"+request.getContextPath()+"/information.jsp';</script>");
	    	}
	    }
	    else if(action.equals("delete_reviewed")){
	    	InfoListDO ild=new InfoListDO();
	    	if(ild.DelReviewed(reviewed_ID)){
	    		out.write("<script language='javascript'> alert(\"É¾³ý³É¹¦£¡\");window.location.href='"+request.getContextPath()+"/reviewed.jsp';</script>");
	    	}else{
	    		out.write("<script language='javascript'> alert(\"É¾³ýÊ§°Ü£¡\");window.location.href='"+request.getContextPath()+"/reviewed.jsp';</script>");
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
