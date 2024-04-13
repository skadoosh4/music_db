package java_package;

import java.sql.*;
import java.util.*;

public class del_album {

	public void main() {
		Connection connection = null;
		Scanner sc = new Scanner(System.in);
		
		Studio connect_db = new Studio();
		
		connection = connect_db.get_connection();

		try {
			
			System.out.println("Enter the Album UID to be deleted : \n");
			int uid = sc.nextInt();
			
			String query = "delete from album where uid = ?"; 
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, uid);
			
			statement.executeUpdate();
			
			System.out.println("Album removed successfully!");
			
			statement.close();
			connection.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
	}

}

