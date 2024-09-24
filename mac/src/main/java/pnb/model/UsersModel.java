package pnb.model;
import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pnb.Config.DatabaseConfig;
import pnb.entity.User;
public class UsersModel {
	public List<User> listuser(){
		List<User> listusers =new ArrayList<User>();
		Connection connect= DatabaseConfig.getConnection();
		
		Statement stmt=null;
		ResultSet rs=null;
		String query="Select * from users";
		try {
			stmt=connect.createStatement();
			
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				listusers.add(new User(rs.getString("CaseID"), rs.getString("Description"), rs.getInt("Number_Of_Files")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return listusers;
	}
}
