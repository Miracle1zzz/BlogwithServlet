package com.duanle.model;

import java.sql.*;

public class AdminDO {
	private Statement sm=null;
	private ResultSet rs=null;
	private Connection ct=null;
	
	//�ر���Դ
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
		//��֤����Ա
		public boolean checkAdmin(String u,String p)
		{
			boolean b=false;
			try {
		
			    
			    ct=new ConnDB().getConn();
			    
			    sm=ct.createStatement();
			    
			    rs=sm.executeQuery("select admin_pwd from admin where admin_id='"+u+"'");
			    
			    if(rs.next()){
			    //˵������Ա����
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
}
