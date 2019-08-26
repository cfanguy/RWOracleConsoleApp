package cfanguy.readWriteOracle;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        OracleDataSource ods;
		try {
			ods = new OracleDataSource();
	        ods.setURL("jdbc:oracle:thin:@//localhost:1521/XE");
	        ods.setUser("AppAccount");
	        ods.setPassword("test123");
	        Connection conn = ods.getConnection();
	        
	        PreparedStatement stmt = conn.prepareStatement("INSERT INTO PERSONS (PERSONID, LASTNAME, FIRSTNAME) VALUES ('0', 'John', 'Smith')");
	        stmt.executeQuery();
	        
	        stmt = conn.prepareStatement("Select * FROM PERSONS");	        
	        ResultSet rslt = stmt.executeQuery();
	        while (rslt.next()) {
	            System.out.println(rslt.getString(1) + ", " + rslt.getString(2) + ", " +rslt.getString(3));
	        }
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
