package com.newlecture.app.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.app.entity.Notice;

public class NoticeService {
	
	private String url = "jdbc:mysql://localhost/newlecture";
	private String uid = "root";
	private String pwd = "mysql";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	public List<?> getList() throws ClassNotFoundException, SQLException{
		String sql = "select * from notice where hit > 10";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<Notice> list = new ArrayList<Notice>();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String writerId = rs.getString("writer_id");
			Date regDate = rs.getDate("regdate");
			String content = rs.getString("content");
			int hit = rs.getInt("hit");
			String files = rs.getString("files");
			
			Notice notice = new Notice(
								id,
								title,
								writerId,
								regDate,
								content,
								hit,
								files
							);
			
		}
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
	
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getFiles();
		
		
		String sql = "insert into notice("
				+ "title,"
				+ "writer_id,"
				+ "content,"
				+ "files"
				+ ") values (?,?,?,?)";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
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
		return result;
	}
	
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		String title = notice.getTitle();
		String content = notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId();
		
		
		String sql = "update notice"
				+ " set "
				+ "title = ?,"
				+ "content = ?,"
				+ "files = ?"
				+ "where id = ?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		//Statement st = con.createStatement();
		PreparedStatement st= con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);
		
		int result = st.executeUpdate();
		st.close();
		con.close();
		return result;
	}
	
	public int delete(int id) throws ClassNotFoundException, SQLException {
		String sql = "delete notice where id =?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		//Statement st = con.createStatement();
		PreparedStatement st= con.prepareStatement(sql);
		st.setInt(1, id);
		
		int result = st.executeUpdate();
		st.close();
		con.close();
		return result;
	}
	
}
