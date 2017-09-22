package com.duanle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.duanle.model.InfoListDO;
import com.duanle.util.Tools;

public class inforListServlet extends HttpServlet {

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
    	String Category=Tools.toChinese(request.getParameter("Category"));
    	String titleimage=Tools.toChinese(request.getParameter("titleimage"));
    	String Title=Tools.toChinese(request.getParameter("title"));
    	String Maintext=Tools.toChinese(request.getParameter("Maintext"));
    	String Introduced_per=Tools.toChinese(request.getParameter("Introduced_per"));
    	String Introduced_date=Tools.toChinese(request.getParameter("Introduced_date"));
    	HttpSession session=request.getSession();
	    PrintWriter out=response.getWriter();
    	InfoListDO ild=new InfoListDO();
    	String sql_page="select count(*) from reviewed";
		String ID=Integer.toString(ild.getrowCount(sql_page)+1);
    	if(ild.AddInformation(ID, Category, Title, Introduced_date, Introduced_per, Maintext, titleimage)){
    		session.setAttribute("Introduced_per", Introduced_per);
    		out.write("<script language='javascript'> alert(\"添加成功！\");window.location.href='"+request.getContextPath()+"/main.jsp';</script>");
    	}
    	else{
    		out.write("<script language='javascript'> alert(\"添加失败！\");window.location.href='"+request.getContextPath()+"/main.jsp';</script>");
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
