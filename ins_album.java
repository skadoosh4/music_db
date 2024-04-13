package java_package;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ins_album {

	public void main() {
		Connection connection = null;
		Scanner sc = new Scanner(System.in);
		
		Studio connect_db = new Studio();
		
		connection = connect_db.get_connection();
		
		try {
			
			System.out.println("Enter the Album details to be added : ");
			System.out.print("UID : \t");
			int uid = sc.nextInt();
			System.out.print("Title : \t");
			String title = sc.next();
			System.out.print("Copyright Date : \t");
			String copyright_date = sc.next();
			System.out.print("Format : \t");
			String format = sc.next();
			System.out.print("Album Identifier : \t");
			int album_identifier = sc.nextInt();
			System.out.print("Musician ID : \t");
			String musician_id = sc.next();
			
			String query  = "insert into album" + "(uid,title,copyright_date,format,album_identifier,musician_id)"  + "values(?,?,?,?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, uid);
			statement.setString(2, title);
			statement.setDate(3, Date.valueOf(copyright_date));
			statement.setString(4, format);
			statement.setInt(5, album_identifier);
			statement.setString(6, musician_id);
			
			statement.executeUpdate();
			System.out.println("Album Details added successfully!");
			
			statement.close();
			connection.close();	
			
		}
		
		catch (Exception e){
			e.printStackTrace();
		}
	
		sc.close();
	}

}

