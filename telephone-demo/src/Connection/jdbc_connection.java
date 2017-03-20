package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc_connection {
	static String drivename ="com.mysql.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3308/myworld";
	static String username="root";
	static String password="1Qaz2wsx3edc";
	
	static{
		try {
			Class.forName(drivename);
			System.out.println("create driver successfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection(){
		Connection conn=null;
		try {
			conn = (Connection) DriverManager.getConnection(url, username, password);
			System.out.println("connect to database successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	public static void free(ResultSet rs, Connection conn, Statement stmt){

		try {
			if(rs !=null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("close the database failed!");
			e.printStackTrace();
		} finally{
			try {
				if(conn !=null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("close the connection failed!!");
				e.printStackTrace();
			} finally{
				try {
					if(stmt !=null){
						stmt.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("close the statement failed!!");
					e.printStackTrace();
				}
			}
		}

	}
	
//	public static void main(String[] args){
//		jdbc_connection.getConnection();
//	}
}

