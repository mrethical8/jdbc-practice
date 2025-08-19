/*
 * for mysql
 * 1. import ----> java.sql
 * 2. load and register the driver ----> com.mysql.jdbc.Driver
 * 3. Create connection ----> Connection
 * 4. create a statement ----> Statement
 * 5. execute the query ---->
 * 6. process the results ---->
 * 7. close
 * 
 * for oracle
 * 1. import ----> java.sql.*;
 * 2. load and register the driver ----> oracle.jdbc.driver.OracleDriver
 * 3. Create connection ----> Connection
 * 4. create a statement ----> Statement
 * 5. execute the query ---->
 * 6. process the results ---->
 * 7. close
 */
package com.telusko.learning;

import java.sql.*;

public class hello {

    public static void main(String[] args) throws Exception {
        // Use either correct SID or service name format here (using service name format shown)
        String url = "";  
        
        // Use valid Oracle username and password
        String uname = "";   
        String pass = "";
        
        String query = "SELECT ENAME FROM emp WHERE EMPNO = 8000";
        
        // Load Oracle JDBC driver - optional if driver is in classpath
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        try (Connection con = DriverManager.getConnection(url, uname, pass);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            
            if (rs.next()) {
                String name = rs.getString("ENAME");
                System.out.println("Employee Name: " + name);
            } else {
                System.out.println("No employee found with EMPNO = 8000");
            }
            
        } // resources will be auto-closed
    }
}
