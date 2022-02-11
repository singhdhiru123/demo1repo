package departmentDOApack;

import java.util.ArrayList;

import com.th.model.Department;

public interface DepartmentOperations {
	
	String addADepartment(Department d);
	ArrayList<Department> getAllDepartments();
	Department getADepartment(int department_id);
	Department getADepartmentbyName(String department_name);
	String setManagerId(int department_id,int manager_id);


}
