package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Tools.interaction;

/*
 * to insert a item
 * id:1001
 * tele_name:test_name
 * tele_num:test_num
 */
public class add {
	private int id;
	private String tele_name;
	private String tele_num;
	public add(){
		System.out.println("please input your tele_name");
		tele_name = interaction.get_a_string_from_keyboard();
		System.out.println("please input your tele_num");
		tele_num = interaction.get_a_string_from_keyboard();
	}
	public add(int id, String tele_name, String tele_num){
		this.id=id;
		this.tele_name=tele_name;
		this.tele_num=tele_num;
	}

	
	public int add_a_item(){
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultset=null;
		
		
		try {
			connection=jdbc_connection.getConnection();
			String sql="INSERT INTO contactors(id, tele_name, tele_num) VALUES(?,?,?)";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, 1001);
			statement.setString(2, tele_name);
			statement.setString(3, tele_num);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	public static void main(String[] args) {
		
		User user = new User();
		add a=new add();
		a.add_a_item();
	}

}
