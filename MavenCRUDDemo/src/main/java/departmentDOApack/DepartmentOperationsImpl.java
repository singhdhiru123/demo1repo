package departmentDOApack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.th.model.Department;

public class DepartmentOperationsImpl  implements DepartmentOperations{
	
	private static Connection con = null;

	@Override
	public String addADepartment(Department d) {
		PreparedStatement ps = null;
		con = DBManager.getConnection();
		String str = "insert into departments value(?,?,?,?)";
		
		  try {
			ps = con.prepareStatement(str);
			// 1 is value substituted for 1st placeholder in the insert statement
			ps.setInt(1,d.getDepartment_id());
			ps.setString(2, d.getDepartment_name());
			ps.setInt(3, d.getManager_id());
			ps.setInt(4,d.getLocation_id());
			
			ps.executeUpdate();
			return ("One row inserted........");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return("insertion failed due to sql exception!!!!"+e.getMessage());
		}
		
		
		
	}

	@Override
	public ArrayList<Department> getAllDepartments() {
		ArrayList<Department> dlist = new ArrayList<Department>();
		con = DBManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from departments");
			
			while (rs.next())
			{
				Department d = new Department(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
				dlist.add(d);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
          return dlist;
	}

	@Override
	public Department getADepartment(int department_id) {
		con = DBManager.getConnection();
		Department d = null;
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from departments where department_id="+department_id);
			while (rs.next())
			{
				d = new Department(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return d;
	}

	@Override
	public String setManagerId(int department_id, int manager_id) {
		PreparedStatement ps = null;
		String str = "update departments set manager_id= ? where department_id=?";
		con = DBManager.getConnection();
		try {
			ps = con.prepareStatement(str);
			ps.setInt(1,manager_id);
			ps.setInt(2,department_id);
			ps.executeUpdate();
			return "One row updated successfully!!!";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return("Exception occurred  updation failed!!!"+e.getMessage());
		}
		
		
	}

	@Override
	public Department getADepartmentbyName(String department_name) {
		con = DBManager.getConnection();
		Department d = null;
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from departments where department_name='"+department_name+"'");
			while (rs.next())
			{
				d = new Department(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return d;
	}
	
	public void dbconnectionClose()
	{
		con= DBManager.getConnection();
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

}