package com.ey.day5assignment;

public class Employee {
	private int empid;
	private String firstName;
	private String lastName;
	public Employee(int empid, String firstName, String lastName) {
		super();
		this.empid = empid;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getEmpid() {
		return empid;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o)
			return true;
		if(o==null || getClass()!=o.getClass())
			return false;
		Employee employee = (Employee)o;
		return empid==employee.empid;
	}
	
	@Override
	public int hashCode() {
		return Integer.hashCode(empid);
	}
	
}
