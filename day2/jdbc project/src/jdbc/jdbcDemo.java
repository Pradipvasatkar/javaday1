package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.ConnectionEvent;

public class jdbcDemo {
public static void main (String[] args) {
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn =	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","root");
     Statement stmt = conn.createStatement();
     String sql ="select employee_id, employee_name, employee_salary from employee";
     ResultSet rs = stmt.executeQuery(sql);
     while(rs.next()){
    	 int employee_id =rs.getInt("employee_id");
    	 String employee_name = rs.getString("employee_name");
    	 double employee_salary = rs.getDouble("employee_salary");
    	 System.out.println(employee_id+", "+employee_name+", "+employee_salary);
     }
     }
     catch (ClassNotFoundException e){
    	 System.out.println("Driver class not found.");
     } catch (SQLException e) {
    	 System.out.println("problem communicating to the database");
     }
	
}
}
