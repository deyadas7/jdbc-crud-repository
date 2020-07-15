package com.deya.jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        System.out.println( "Hello World!" );
        
  //      Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","password");
        Statement stmt=con.createStatement();
        String sql="Delete from emp_table where NAME='dummy' and ID=5";
        int n=stmt.executeUpdate(sql);
        System.out.println(n +" rows updated.");
        ResultSet rst=stmt.executeQuery("SELECT *FROM emp_table");
        
       while(rst.next()) {
    	   System.out.println(rst.getInt(1)+ " " + rst.getString(2)+ " "+ rst.getString(3));
       }
    	   
        con.close();
    }
}
