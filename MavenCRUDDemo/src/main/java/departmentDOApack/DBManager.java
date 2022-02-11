package departmentDOApack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private  static Connection con;
	
	
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");                                      //here your mysql workbench password
			   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "Ds1234@#5");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
