package recipes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import recipes.exception.DbException;

public class DbConnection {
	private static final String SCHEMA = "recipes"; // Added constants (Uppercase) so if change them can easily change here
	private static final String USER = "recipes";
	private static final String PASSWORD = "recipes";
	private static final String HOST = "localhost";
	private static final int PORT = 3306;

	public static Connection getConnection() { // connection string. Created format string with these format specifiers (%s etc). 
		String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER,
				PASSWORD);

		System.out.println("Connecting with urls=" + url);

		try {
			Connection conn = DriverManager.getConnection(url); //Asked driver manager to look up the driver for us + make the connection.
			System.out.println("Successfully obtained connection!"); //If get here, have got a connection or will throw a checked exception and we'll throw an unchecked exception.
			return conn; 
		} catch (SQLException e) {
			System.out.println("Error getting connection."); //Will print if don't get a connection. 
			throw new DbException(e);  //changed into unchecked exception so don't have to handle the throws declaration everywhere. still want to throw an exception because getting an unchecked exception is bad. 
		}

	}
}
