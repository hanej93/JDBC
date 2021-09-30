package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String title = "TEST3";
		String content = "haha3";
		String files = "";
		int id = 5;
		
		
		String url = "jdbc:mysql://localhost/newlecture";
		String sql = "update notice"
				+ " set "
				+ "title = ?,"
				+ "content = ?,"
				+ "files = ?"
				+ "where id = ?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,"root","mysql");
		//Statement st = con.createStatement();
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);
		
		int result = st.executeUpdate();
		System.out.println(result);
		st.close();
		con.close();
		
	}

}
