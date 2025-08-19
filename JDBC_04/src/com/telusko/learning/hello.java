//This is a straightforward Java JDBC program to fetch and print the employee name by employee number from an Oracle database.
package com.telusko.learning;

import java.sql.*;

public class hello {

    public static void main(String[] args) {
        EmployeesWorkers workers = new EmployeesWorkers();
        try {
            Employee e1 = workers.getEmployee(8000);
            if (e1 != null) {
                System.out.println(e1.ENAME);
            } else {
                System.out.println("Employee not found.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

// Class to manage employees
class EmployeesWorkers {

    public Employee getEmployee(int EMPNO) {
        Employee e = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  // load driver

            String url = "";
            String username = "";
            String password = "";

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            String query = "SELECT ENAME FROM emp WHERE EMPNO = " + EMPNO;
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                e = new Employee();
                e.EMPNO = EMPNO;
                e.ENAME = rs.getString("ENAME");
            }

            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return e;
    }
}

// Employee data class
class Employee {
    int EMPNO;
    String ENAME;
}
