package java_package;

import java.sql.*;
import java.util.*;

public class del_song {

	public void main() {
		Connection connection = null;
		Scanner sc = new Scanner(System.in);
		
		Studio connect_db = new Studio();
		
		connection = connect_db.get_connection();

		try {
			
			System.out.println("Enter the Song ID to be deleted : \n");
			int song_id = sc.nextInt();
			
			String query = "delete from song where id = ?"; 
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, song_id);
			
			statement.executeUpdate();
			
			System.out.println("Song removed successfully!");
			
			statement.close();
			connection.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
	}

}
