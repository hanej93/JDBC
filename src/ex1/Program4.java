package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		int id = 5;
		
		String url = "jdbc:mysql://localhost/newlecture";
		String sql = "delete notice where id =?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,"root","mysql");
		//Statement st = con.createStatement();
		PreparedStatement st= con.prepareStatement(sql);
		st.setInt(1, id);
		
		int result = st.executeUpdate();
		System.out.println(result);
		st.close();
		con.close();
		
	}

}
