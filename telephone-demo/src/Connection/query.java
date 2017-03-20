package Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class query {

	private String sql=null;
	
	public List<User> getinfo(String sql){
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
		List<User> list=new ArrayList<User>();
		try {
			connection=jdbc_connection.getConnection();
			statement=connection.createStatement();
			this.sql=sql;
			resultset=statement.executeQuery(sql);
			while(resultset.next()){
				User user=new User();
				user.setId(resultset.getInt("id"));
				user.setTele_name(resultset.getString("tele_name"));
				user.setTele_num(resultset.getString("tele_num"));
				list.add(user);
			}
			System.out.println("Have got all the info from the database!...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


	public static void main(String[] args) {
		query qu = new query();
		String sql="SELECT * FROM contactors";
		List<User> list=qu.getinfo(sql);

				if(list!=null){
					System.out.print("id	");
					System.out.print("name	");
					System.out.print("tel		");
					System.out.println();
					for (int i = 0; i < list.size(); i++) {
						System.out.print(list.get(i).getId()+"\t");
						System.out.print(list.get(i).getTele_name()+"\t");
						System.out.print(list.get(i).getTele_num()+"\t");
						System.out.println();
					}
				}
	}

}
