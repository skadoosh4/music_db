package java_package;
import java.sql.*;
import java.util.*;
public class del_musician {

	public void main() {
		Connection connection = null;
		Scanner sc = new Scanner(System.in);
		
		Studio connect_db = new Studio();
		
		connection = connect_db.get_connection();

		try {
			
			System.out.println("Enter the musician's SSN to be deleted : \n");
			String ssn = sc.nextLine();
			
			String query = "delete from musician where ssn = ?"; 
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, ssn);
			
			statement.executeUpdate();
			
			System.out.println("Musician Details Deleted successfully!");
			
			statement.close();
			connection.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
}
