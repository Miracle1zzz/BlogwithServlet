package com.duanle.model;

import java.sql.*;

public class ConnDB {
public Connection ct=null;
	
	public Connection getConn(){
		try {
			 Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			    
			 ct=DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=Blog_data","sa","521122");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ct;
	}
}
