package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDao {
	public void createEmployee(int employee_id, String employee_name, double employee_salary){
	}
	public void deleteEmployee(int employee_id) throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn =	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","root");
		     Statement stmt = conn.createStatement();
		     String sql ="delete from employee where employee_id="+employee_id;
		     ResultSet rs = stmt.executeQuery(sql);
		     int result = stmt.executeUpdate(sql);
		     if (result == 1) {
		    	
		    	 System.out.println("Employee "+employee_id+" is deleted." );
				
			}
		     else{
		    	 System.out.println("employee not found  "+employee_id);
		     
		     }
		     
	}
	public void readEmployee(int employee_id) throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn =	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","root");
		     Statement stmt = conn.createStatement();
		     String sql ="select employee_id, employee_name, employee_salary from employee";
		     ResultSet rs = stmt.executeQuery(sql);
		     if (rs.next()) {
		    	 employee_id =rs.getInt("employee_id");
		    	 String employee_name = rs.getString("employee_name");
		    	 double employee_salary = rs.getDouble("employee_salary");
		    	 System.out.println(employee_id+", "+employee_name+", "+employee_salary);
				
			}
		     else{
		    	 System.out.println("Data not found for employee "+employee_id);
		     
		     }
		
	}
	public void updateEmployee(int employee_id, double employee_salary){
		
	}
	public void readAllEmployees() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn =	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","root");
		     Statement stmt = conn.createStatement();
		     String sql ="select employee_id, employee_name, employee_salary from employee where employee_id=";
		     ResultSet rs = stmt.executeQuery(sql);
		   
		     while(rs.next()){
		    	 int employee_id =rs.getInt("employee_id");
		    	 String employee_name = rs.getString("employee_name");
		    	 double employee_salary = rs.getDouble("employee_salary");
		    	 System.out.println(employee_id+", "+employee_name+", "+employee_salary);
	
	}

	}
}
