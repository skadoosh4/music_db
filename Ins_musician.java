package java_package;
import java.util.*;
import java.sql.*;
public class Ins_musician {

	public void main() {
		Connection connection = null;
		Scanner sc = new Scanner(System.in);
		
		Studio connect_db = new Studio();
		
		connection = connect_db.get_connection();
		
		try {
			
			System.out.println("Enter the Musician's details to be added : ");
			System.out.println("SSN : \t");
			String ssn = sc.nextLine();
			System.out.println("Name : \t");
			String name = sc.nextLine();
			System.out.println("Home ID : ");
			int home = sc.nextInt();
			
			String query  = "insert into musician" + "(ssn,name,home_id)"  + "values(?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, ssn);
			statement.setString(2, name);
			statement.setInt(3, home);
			
			statement.executeUpdate();
			System.out.println("Musician Details added successfully!");
			
			statement.close();
			connection.close();
		}
		
		catch (Exception e){
			e.printStackTrace();
		}
		sc.close();
	}

}
