//this is how you can add emp and remove .
package com.telusko.learning;

import java.sql.*;

public class hello {

    public static void main(String[] args) {
        EmployeesWorkers workers = new EmployeesWorkers();

        Employee e2 = new Employee();
        e2.EMPNO = 8004;
        e2.ENAME = "Archana";

        workers.connect();

        try {
            workers.addEmployee(e2);
            System.out.println("Employee inserted successfully.");
        } catch (SQLException ex) {
            System.out.println("Error inserting employee: " + ex.getMessage());
        }
        
        //to remove the employee
        
        //workers.removeEmployee(8004);//it will remove employee also you have create method then you have to write those steps ,write query thats it

        // You could also test getEmployee here if you like
    }
}

class EmployeesWorkers {

    Connection con = null;

    public void connect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Employee getEmployee(int EMPNO) {
        Employee e = null;
        try {
            // Do NOT load driver again, connection should already be established
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
            // Do NOT close connection here; keep it open for other operations
            // con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return e;
    }

    public void addEmployee(Employee e) throws SQLException {
        // Specify the columns you want to insert to avoid errors
        String query = "INSERT INTO emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, e.EMPNO);
            pst.setString(2, e.ENAME);

            // Since your Employee class only has two fields, 
            // you must set default or dummy values for other columns here to satisfy constraints.

            pst.setString(3, "DEVELOPER");            // example JOB
            pst.setInt(4, 7902);                  // example MGR (use existing EMPNO)
            pst.setDate(5, new java.sql.Date(System.currentTimeMillis())); // today's date
            pst.setInt(6, 1000);                  // example SALARY
            pst.setNull(7, java.sql.Types.INTEGER); // COMM null
            pst.setInt(8, 20);                    // DeptNo example

            pst.executeUpdate();
        }
    }
}

class Employee {
    int EMPNO;
    String ENAME;
}
