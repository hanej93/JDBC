package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost/newlecture";
//		String sql = "select * from notice where hit > 10";
		String sql = "select * from notice";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,"root","mysql");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String writerId = rs.getString("writer_id");
			Date regDate = rs.getDate("regdate");
			String content = rs.getString("content");
			int hit = rs.getInt("hit");
			System.out.printf("id: %d\n"
					+ "title: %s\n"
					+ "writerId: %s\n"
					+ "regDate: %s\n"
					+ "content: %s\n"
					+ "hit: %s\n"
					, id, title, writerId, regDate, content, hit);
		}
		rs.close();
		st.close();
		con.close();
		
	}

}
