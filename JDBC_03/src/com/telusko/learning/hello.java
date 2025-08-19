//Class.forName()

package com.telusko.learning;

//import java.sql.DriverManager;

public class hello {
    public static void main (String[] args) throws Exception {
        //Class.forName("com.telusko.learning.Pqr").newInstance();
        Class.forName("oracle.jdbc.driver.OracleDriver");//both class and DriverManager are same 
        
        //DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver());//this is the step which is responsible to load the driver but if you are using class.forname then it is not use to write this statement. 
    }
}

class Pqr {
    static {
        System.out.println("in Static");
    }
    {
        System.out.println("in instance");
    }
}

//we use class.forname to load the class so that when you load the class it will execute the static block