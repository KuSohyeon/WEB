package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {

	/*
	 * public static Connection getConnection() throws Exception {
	 * 
	 * Context ctx = new InitialContext(); DataSource ds = (DataSource)
	 * ctx.lookup("java:comp/env/jdbc/ssafy"); Connection conn = ds.getConnection();
	 * 
	 * return conn;
	 * 
	 * }
	 */
	public static void close(AutoCloseable c) {
		if (c != null) {
			try {
				c.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
