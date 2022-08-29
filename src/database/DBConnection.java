package database;

import java.sql.*;

public class DBConnection {

	private static DBConnection db = new DBConnection();
	private Connection conn = null;
	
	private final String IPADDRESS = "localhost";
	private final String USERNAME = "spg111";
	private final String PASSWORD = "비밀번호";
	private final String DBNAME = "spg111";
	
	private final String JDBCDRIVER = "org.mariadb.jdbc.Driver";
	private final String JDBCURL = "jdbc:mariadb://" + IPADDRESS + "/" + DBNAME + "?useSSL=false";

	protected static DBConnection getInstance() {
		return db;
	}

	protected Connection getConnection() {
		
		try {
			Class.forName(JDBCDRIVER);
			conn = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}