package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**********************************************************************************************
 * This class handles the database connection for the student management system.
 **********************************************************************************************/
public class DatabaseUtil {

	/*************************************************************************************
	 * This method establishes a connection to the PostgreSQL database.
	 * 
	 * @return Connection The database connection object.
	 *************************************************************************************/
	public static Connection connect() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee_db", "postgres",
					"Crevavi");
			return connect;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}