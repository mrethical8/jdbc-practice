//Note:how to insert values using jdbc also u can use update,delete
package com.telusko.learning;

import java.sql.*;

public class hello {

    public static void main(String[] args) throws Exception {

        String url = "";  
        String uname = "";   
        String pass = "";
        
        String query = "INSERT INTO emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";        
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        PreparedStatement st = con.prepareStatement(query);//PreparedStatement to insert multiple value
        st.setInt(1, 8002);
        st.setString(2, "SEJAL");
        st.setString(3, "DEVELOPER");
        st.setInt(4, 7698);
        st.setDate(5, java.sql.Date.valueOf("2025-07-27")); // Use java.sql.Date for date
        st.setInt(6, 5000);
        st.setNull(7, java.sql.Types.INTEGER);  // null for COMM
        st.setInt(8, 20);
        int count  = st.executeUpdate();//for insert we have to use executeUpdate
           
        System.out.println(count + " row/s affected");
        
        st.close();
        con.close();
        } 
    }

