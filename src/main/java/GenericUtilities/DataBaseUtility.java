package GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

    // Method to execute SELECT queries
    public void executeSelectQuery(String query) throws SQLException {
        // Step 1: Create an Object
        Driver d = new Driver();
        // Step 2: Register the driver
        DriverManager.registerDriver(d);
        // Step 3: Connect to Database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "TIGER");
        // Step 4: Issue/Create Statement
        Statement state = con.createStatement();
        
        // Execute the query
        ResultSet resSet = state.executeQuery(query);
     
        // Process the result set
        ResultSetMetaData rsmd = resSet.getMetaData();
        int columnCount = rsmd.getColumnCount();
        
        // Process the result set
        while (resSet.next()) {
            // Assuming you want to print out the first column value
        	for(int i=1;i<=columnCount;i++) {
            System.out.println(resSet.getString(i)+"\t");
        }
        	System.out.println();
        }
        
        con.close();
        System.out.println("DB Connection Closed");
    }

    // Method to execute INSERT, UPDATE, DELETE queries
    public void executeUpdateQuery(String query) throws SQLException {
        // Step 1: Create an Object
        Driver d = new Driver();
        // Step 2: Register the driver
        DriverManager.registerDriver(d);
        // Step 3: Connect to Database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "TIGER");
        // Step 4: Issue/Create Statement
        Statement state = con.createStatement();
        
        // Execute the query
        int result = state.executeUpdate(query);
        
        System.out.println("Rows affected: " + result);
        
        con.close();
        System.out.println("DB Connection Closed");
    }
    
}
