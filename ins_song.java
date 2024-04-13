package java_package;
import java.sql.*;
import java.util.*;
public class ins_song {

	public void main() {
		Connection connection = null;
		Scanner sc = new Scanner(System.in);
		
		Studio connect_db = new Studio();
		
		connection = connect_db.get_connection();
		
		try {
			
			System.out.println("Enter the song details to be added : ");
			System.out.print("Song ID : \t");
			int song_id = sc.nextInt();
			System.out.print("Song title : \t");
			String title = sc.next();
			System.out.print("Song Author : \t");
			String author = sc.next();
			System.out.print("Album ID : \t");
			int album_id = sc.nextInt();
			
			String query  = "insert into song" + "(id,title,author,album_id)"  + "values(?,?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, song_id);
			statement.setString(2, title);
			statement.setString(3, author);
			statement.setInt(4, album_id);
			
			statement.executeUpdate();
			System.out.println("Song Details added successfully!");
			
			statement.close();
			connection.close();	
			
		}
		
		catch (Exception e){
			e.printStackTrace();
		}
	
		sc.close();
	}

}
