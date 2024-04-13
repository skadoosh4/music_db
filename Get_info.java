package java_package;
import java.sql.*;
public class Get_info {

	public void main(){
		Connection connection = null;
		
		Studio connect_db = new Studio();
				
		connection = connect_db.get_connection();
		
		try (Statement statement = connection.createStatement()){
			String query = "select * from album; select * from home; select * from instrument; select * from musician; select * from perform; select * from play; select * from song";
			boolean results = statement.execute(query);
			System.out.println("Following are the tables : \n");
			
			do {
				if(results) {
					ResultSet rs = statement.getResultSet();
					
					ResultSetMetaData rsmd = rs.getMetaData();
					int cols = rsmd.getColumnCount();
					System.out.println("----------------------------------"+rsmd.getTableName(2) +"--------------------------------------");
					for(int i=1 ; i<=cols ; i++) {
						System.out.print(rsmd.getColumnName(i) + "\t\t\t");
					}
					System.out.println();
					while(rs.next()) {
						System.out.println();
						for(int i=1 ; i <= cols ; i++) {
							System.out.print(rs.getString(i) + "\t\t\t");
						}
						System.out.println();
					}
				}
				System.out.println("\n");
				results = statement.getMoreResults();
			}
			while(results);
				
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
}
}
	