//Note:how to fetch the whole table using jdbc.
package com.telusko.learning;

import java.sql.*;

public class hello {

    public static void main(String[] args) throws Exception {

        String url = "";  
        String uname = "";   
        String pass = "";
        String query = "SELECT * from emp ";
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
           
        String userData = "";
        
        while(rs.next()) 
        {
             userData = rs.getInt(1) + " : " + rs.getString(2)+ " : " + rs.getString(3)+ " : " + rs.getInt(4)+ " : " + rs.getString(5);        
             System.out.println(userData);
        }
        
        st.close();
        con.close();
        } 
    }

