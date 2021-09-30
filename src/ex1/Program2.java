package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String title = "TEST2";
		String writerId = "newlec";
		String content = "haha";
		String files = "";
		
		
		String url = "jdbc:mysql://localhost/newlecture";
		String sql = "insert into notice("
				+ "title,"
				+ "writer_id,"
				+ "content,"
				+ "files"
				+ ") values (?,?,?,?)";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,"root","mysql");
		//Statement st = con.createStatement();
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		
		int result = st.executeUpdate();
		System.out.println(result);
		st.close();
		con.close();
		
	}

}
