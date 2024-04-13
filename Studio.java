package java_package;
import java.sql.*;

public class Studio {

	public Connection get_connection() {
		
		Connection connection = null;
		
		try {
			
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s58","cs4222s58","uiMfJFyt");
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return connection;
	}
}


