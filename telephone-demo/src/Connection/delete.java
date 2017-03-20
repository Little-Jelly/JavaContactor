package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Tools.interaction;

public class delete {

	/**
	 * @param args
	 */
	String username=null;
//	public delete(){
//		Connection connection=null;
//		PreparedStatement statement=null;
//		try {
//			connection=jdbc_connection.getConnection();
//			String sql = "delete from contactors where tele_name=?";
//			statement = connection.prepareStatement(sql);
//			statement.setString(1, "777");
//			statement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	public int delete_according_username(String u){
		username=u;
		Connection connection=null;
		PreparedStatement statement=null;
		
		try {
			connection=jdbc_connection.getConnection();
			String sql = "delete from contactors where tele_name=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) {
		delete d = new delete();
		System.out.println("input a username!..");
		String username = interaction.get_a_string_from_keyboard();
		d.delete_according_username(username);

	}

}
