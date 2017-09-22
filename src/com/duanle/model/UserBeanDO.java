package com.duanle.model;

import java.sql.*;
import java.util.ArrayList;
import com.duanle.model.*;

public class UserBeanDO {
	private Statement sm=null;
	private ResultSet rs=null;
	private Connection ct=null;
	
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
		//验证用户
		public boolean checkUser(String u,String p)
		{
			boolean b=false;
			try {
		
			    
			    ct=new ConnDB().getConn();
			    
			    sm=ct.createStatement();
			    
			    rs=sm.executeQuery("select user_pwd from users where user_id='"+u+"'");
			    
			    if(rs.next()){
			    //说明用户存在
			    	if(rs.getString(1).equals(p)){
			    	b=true;
			    	}
			    	
			    }

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				this.Close();
			}
			return b;
		}
		
		//添加用户（用户注册）
		public boolean addUser(String user_Id,String user_pwd,String user_face,String user_sex,String user_qq,String user_email){   
			
			boolean b=false;
			try{
				ct=new ConnDB().getConn();
				sm=ct.createStatement();
				int a=sm.executeUpdate("INSERT into users(user_id,user_pwd,user_face,user_sex,user_qq,user_email) VALUES( '"+user_Id+
						"', '"+user_pwd+"','"+user_face+"','"+user_sex+"','"+user_qq+"','"+user_email+"')");
				//a是添加的记录数
				if(a==1){
					b=true;
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.Close();
			}
			return b;
		}
		//用户信息更改
		public boolean updateUser(String user_Id,String user_pwd,String user_face,String user_sex,String user_qq,String user_email){   //修改用户
			
			boolean b=false;
			try{
				ct=new ConnDB().getConn();
				sm=ct.createStatement();
				int a=sm.executeUpdate("update users SET user_pwd='"+user_pwd+"',user_face='"+user_face+"',user_sex='"+user_sex+"',user_qq='"+user_qq+"',user_email='"+user_email+"' where user_id='"+user_Id+"'");
				//a是修改的记录数
				if(a==1){
					b=true;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return b;
		}
		public ArrayList getUsers(String user_id) {
			ArrayList al = new ArrayList();
			try {
				ct = new ConnDB().getConn();
				sm = ct.createStatement();
				//查询要显示的内容
				rs=sm.executeQuery("select * from users where user_id='"+user_id+"'");
				while (rs.next()) {
				 UserBean ub=new UserBean();
				 ub.setUser_id(rs.getString(1));
				 ub.setUser_pwd(rs.getString(2));
				 ub.setUser_face(rs.getString(3));
				 ub.setUser_sex(rs.getString(4));
				 ub.setUser_qq(rs.getString(5));
				 ub.setUser_email(rs.getString(6));
					al.add(ub); // 将al放到arrayList中
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.Close();
			}
			return al;
		}
}
