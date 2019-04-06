package jdbc2;

import java.sql.SQLException;

public class jdbcDemo2 {

	public static void main(String[] args) {
	EmployeeDao dao = new EmployeeDao();
	try { 
		dao.updateEmployee(101, 5000);
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	catch (ClassNotFoundException e)
	{
	e.printStackTrace();
	}
	
	}

	}


