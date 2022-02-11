package com.th.model;

public class Department {
	private int department_id;
	private String department_name;
	private int manager_id;
	private int location_id;
	public Department(int department_id, String department_name, int manager_id, int location_id) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.manager_id = manager_id;
		this.location_id = location_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public int getManager_id() {
		return manager_id;
	}
	public int getLocation_id() {
		return location_id;
	}
	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", department_name=" + department_name + ", manager_id="
				+ manager_id + ", location_id=" + location_id + "]";
	}
	
	

}
