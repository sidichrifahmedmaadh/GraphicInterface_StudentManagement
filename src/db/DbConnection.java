
package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static Connection con = null;

	static {
		String url = "jdbc:mysql://localhost:3306/universitySystem";
		String user = "root";
		String pass = "";
		try {
			// Tester la disponibilité du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//
			con = DriverManager.getConnection(url, user, pass);
			//DatabaseConnectionout.println("Connectin etablie");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return con;
	}

	public static void main(String[] args) {
		//DatabaseConnection.getConnection();
	}

}