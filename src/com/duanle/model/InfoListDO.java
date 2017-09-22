package com.duanle.model;

import java.sql.*;
import java.util.ArrayList;

public class InfoListDO {
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
				//DelInformation
				public boolean DelInformation(String ID){
					boolean b=false;
					try {
						ct = new ConnDB().getConn();
						sm=ct.createStatement();
						int a=sm.executeUpdate("delete from infoList where ID='"+ID+"'");
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
				public boolean DelReviewed(String reviewed_ID){
					boolean b=false;
					try {
						ct = new ConnDB().getConn();
						sm=ct.createStatement();
						int a=sm.executeUpdate("delete from reviewed where ID='"+reviewed_ID+"'");
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
				//tianjia
				public boolean AddInformation(String ID,String Category,String Title,String Introduced_date,String Introduced_per,String Maintext,String titleimage ){
					boolean b=false;
					try {
						ct = new ConnDB().getConn();
						sm=ct.createStatement();
						int a=sm.executeUpdate("insert into reviewed(ID,category,title,introduced_date,introduced_per,Maintext,titleimage) values('"+ID+"','"+Category+"','"+Title+"','"+Introduced_date+"','"+Introduced_per+"','"+Maintext+"','"+titleimage+"')");
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
				public boolean AddInformation1(String infor_ID,String Category,String Title,String Introduced_date,String Introduced_per,String Maintext,String titleimage ){
					boolean b=false;
					try {
						ct = new ConnDB().getConn();
						sm=ct.createStatement();
						int a=sm.executeUpdate("insert into infoList(ID,category,title,introduced_date,introduced_per,Maintext,titleimage) values('"+infor_ID+"','"+Category+"','"+Title+"','"+Introduced_date+"','"+Introduced_per+"','"+Maintext+"','"+titleimage+"')");
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
				
				public int getPageCount(String sql_page) {   //返回分页的总数
					try {
						ct = new ConnDB().getConn();
						sm=ct.createStatement();
						rs = sm.executeQuery(sql_page);
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
				public int getrowCount(String sql_page) {   //返回数据库中数据个数
					try {
						ct = new ConnDB().getConn();
						sm=ct.createStatement();
						rs = sm.executeQuery(sql_page);
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
							InfoList il=new InfoList();
							il.setID(rs.getInt(1));
							il.setIntroduced_per(rs.getString(2));
							il.setTitleimage(rs.getString(3));
							il.setCategory(rs.getString(4));
							il.setTitle(rs.getString(5));
							il.setIntroduced_date(rs.getString(6));
							il.setMaintext(rs.getString(7));
							al.add(il); // 将al放到arrayList中
						}

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						this.Close();
					}
					return al;
				}
				
}
