package it.unina.IS.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

	private static Connection conn = null;
	private DBManager() {}
	public static Connection getConnection() throws SQLException{
		if(conn==null)
			conn= DriverManager.getConnection("jdbc:h2:./prova","sa","");
		return conn;
	}


	public static void closeConnection() throws SQLException{
		if(conn != null)
			conn.close();
	}

}
