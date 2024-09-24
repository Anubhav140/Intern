package pnb.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory;
public class DatabaseConfig {
	public static Connection getConnection()
	
	{
		String dbURL="jdbc:mysql://localhost:3306/try?useSSL=false";
		String dbUsername="root";
		String dbPassword="admin";
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dbURL, dbUsername, dbPassword);

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}

}
