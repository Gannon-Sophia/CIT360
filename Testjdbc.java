package com.testCode.jdbc;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_gannon_tracker?useSSL=false";
		String user = "root";
		String pass = "Ziks2018!";
		
				try{
					System.out.println("Connecting to database: " + jdbcUrl);
					
					Connection myConn = 
							(Connection) DriverManager.getConnection(jdbcUrl, user, pass);
					
					System.out.println("Connection successful");
				}
				catch(Exception exc){
					exc.printStackTrace();
					
			}

	}
