package com.duanle.model;

import java.sql.*;
import java.util.ArrayList;

import com.duanle.model.*;

public class MessageListDO {
	private Statement sm=null;
	private ResultSet rs=null;
	private Connection ct=null;
	private int pageCount = 0;
	private int rowCount = 0;
	private int pageSize = 5;
	//关闭资源
		public void Close(){
			try {
				if(rs!=null){
					rs.close();
					rs=null;
				}
				if(sm!=null){
					sm.close();
					sm=null;
				}
				if(ct!=null){
					ct.close();
					ct=null;
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		public boolean DelMessage(String Mess_ID){
			boolean b=false;
			try {
				ct = new ConnDB().getConn();
				sm=ct.createStatement();
				int a=sm.executeUpdate("delete from Message where ID='"+Mess_ID+"'");
				if(a==1){
					b=true;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				this.Close();
			}
			return b;
			
		}
		//AddMessage
				public boolean addMessage(String ID,String user_id,String user_face,String messageContent,String message_date){
					boolean b=false;
					try {
						ct = new ConnDB().getConn();
						sm=ct.createStatement();
						int a=sm.executeUpdate("insert into Message values('"+ID+"','"+user_id+"','"+user_face+"','"+messageContent+"','"+message_date+"')");
						if(a==1){
							b=true;
						}
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}finally{
						this.Close();
					}
					return b;
					
				}
				public int getPageCount() {   //返回分页的总数
					try {
						ct = new ConnDB().getConn();
						sm=ct.createStatement();
						rs = sm.executeQuery("select count(*) from Message");
						if (rs.next()) {
							rowCount = rs.getInt(1);
						}
						if (rowCount % pageSize == 0) {
							pageCount = rowCount / pageSize;
						} else {
							pageCount = rowCount / pageSize + 1;
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						this.Close();
					}
					return pageCount;
				}
				public int getrowCount() {   //返回数据库中数据个数
					try {
						ct = new ConnDB().getConn();
						sm=ct.createStatement();
						rs = sm.executeQuery("select count(*) from Message");
						if (rs.next()) {
							rowCount = rs.getInt(1);
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						this.Close();
					}
					return rowCount;
				}
				public ArrayList getUsersByPage(int pageNow,String sql) {
					ArrayList al = new ArrayList();
					try {
						ct = new ConnDB().getConn();
						sm = ct.createStatement();
						//查询要显示的内容
						rs=sm.executeQuery(sql);
						while (rs.next()) {
							MessageList ml=new MessageList();
							ml.setID(rs.getString(1));
							ml.setUser_id(rs.getString(2));
							ml.setUser_face(rs.getString(3));
							ml.setMessageContent(rs.getString(4));
							ml.setMessage_date(rs.getString(5));
							
							al.add(ml); // 将al放到arrayList中
						}

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						this.Close();
					}
					return al;
				}
			
}
