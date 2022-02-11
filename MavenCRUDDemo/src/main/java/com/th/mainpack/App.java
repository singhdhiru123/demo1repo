package com.th.mainpack;

import java.util.ArrayList;
import java.util.Scanner;
import com.th.model.Department;

import departmentDOApack.DepartmentOperationsImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	DepartmentOperationsImpl dop = new DepartmentOperationsImpl();
		while(true)
		  {
			  System.out.println("1. Add a Department detail in db");
			  System.out.println("2. Display all departments in the table");
			  System.out.println("3. Retrieve department using department_id");
			  System.out.println("4. Retrieve department using department_name");
			  System.out.println("5. Update manager_id for a department using department_id");
			  System.out.println("6. Exit");
			  
			  System.out.println("Enter your choice");
			  int choice = sc.nextInt();			  
			  
			  switch(choice)
			  {
			  case 1:System.out.println("Enter department id");
			          int dId = sc.nextInt();
			         System.out.println("Enter department name");
			          String dName=sc.next();
			          System.out.println("Enter manager id");
			          int mId=sc.nextInt();	
			          System.out.println("Enter location id");
			          int lId=sc.nextInt();	
			          Department d1 = new Department(dId,dName,mId,lId);
			          System.out.println(dop.addADepartment(d1));
				       				     
				      break;
			  case 2:					  
				     ArrayList<Department> dlist = dop.getAllDepartments(); 
				     for( Department d: dlist)
				     {
				    	 System.out.println(d);
				     }
				     break;
				     
			  case 3:
				  System.out.println("Enter the department id to be retrieved");
				  int rdId = sc.nextInt();
				  
				  Department d= dop.getADepartment(rdId);
				  System.out.println(d);
				  
				  break;
				  
			  case 4:
				  System.out.println("Enter department name to be retived");
		          String rdname = sc.next();
		          
		          Department d2 = dop.getADepartmentbyName(rdname);
		          System.out.println(d2);
				  
				  break;
				  
			  case 5:
				  System.out.println("Enter manager_id to be updated");
				  int umId = sc.nextInt();
				  
				  System.out.println("Enter department_id to be updated");
				  int udId = sc.nextInt();
				  System.out.println(dop.setManagerId(udId, umId));
				  break;
	  
			  default:
				      sc.close();
				      System.out.println("Bye Bye ..... ");
				      System.exit(0);
				  
			 
			  }// switch case
			  
			  
		  }// while loop
    }
}
