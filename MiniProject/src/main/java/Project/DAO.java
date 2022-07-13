package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	public Connection myGetConnection() {

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/MiniProject";
			String uname = "root";
			String pwd = "Sajet@1299";

			con = DriverManager.getConnection(url, uname, pwd);

		} catch (ClassNotFoundException | SQLException E) {
			System.out.println("The Connection Could Not be Made : " + E);
		}
		return con;
	}

	public ResultSet getRows(String sql) {

		Connection con = myGetConnection();
		ResultSet rs = null;
		Statement stmt;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException E) {
			E.printStackTrace();
		}

		return rs;
	}

	public void addUser(String Name, String LName, String DOB, String Gender, String Contact, String UserName,
			String Password) {

		Connection con = myGetConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into login values(?,?,?,?,?,?,?) ");
			pstmt.setString(1, Name);
			pstmt.setString(2, LName);
			pstmt.setString(3, DOB);
			pstmt.setString(4, Gender);
			pstmt.setString(5, Contact);
			pstmt.setString(6, UserName);
			pstmt.setString(7, Password);

			pstmt.executeUpdate();
		} catch (SQLException E) {
			E.printStackTrace();
		}
	
	}

}
