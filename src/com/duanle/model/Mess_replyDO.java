package com.duanle.model;
import java.sql.*;
import java.util.ArrayList;

public class Mess_replyDO {
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
		public boolean addMess_reply(String ID,String user_id,String user_face,String mess_reply_content,String mess_reply_date){
			boolean b=false;
			try {
				ct = new ConnDB().getConn();
				sm=ct.createStatement();
				int a=sm.executeUpdate("insert into mess_reply values('"+ID+"','"+user_id+"','"+user_face+"','"+mess_reply_content+"','"+mess_reply_date+"')");
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
				rs = sm.executeQuery("select count(*) from mess_reply");
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
				rs = sm.executeQuery("select count(*) from mess_reply");
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
		public ArrayList getMess_replyByPage(String ID) {
			ArrayList alx = new ArrayList();
			try {
				ct = new ConnDB().getConn();
				sm = ct.createStatement();
				//查询要显示的内容
				rs=sm.executeQuery("select * from mess_reply where ID='"+ID+"'");
				while (rs.next()) {
					Mess_reply mr=new Mess_reply();
					mr.setID(rs.getString(1));
					mr.setUser_id(rs.getString(2));
					mr.setUser_face(rs.getString(3));
					mr.setMess_reply_content(rs.getString(4));
					mr.setMess_reply_date(rs.getString(5));
					
					alx.add(mr); // 将al放到arrayList中
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.Close();
			}
			return alx;
		}

}
