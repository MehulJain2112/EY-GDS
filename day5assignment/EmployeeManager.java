package com.ey.day5assignment;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeManager {
	public Set<Employee> createEmployeeSet() {
		Set<Employee> employeeSet = new TreeSet<>(Comparator.comparingInt(Employee::getEmpid));
		employeeSet.add(new Employee (102,"Mehul","Jain"));
		employeeSet.add(new Employee (101,"Gaurav","Shukla"));
		employeeSet.add(new Employee (103,"Akshat","KumarJain"));
		return employeeSet;
	}
	
	public void sortByFirstName(Set<Employee> employeeSet) {
		Set<Employee> sortedByFirstName = new TreeSet<>(Comparator.comparing(Employee::getFirstName));
		sortedByFirstName.addAll(employeeSet);
		
		System.out.println("\nSorted by First name : ");
		for(Employee employee : sortedByFirstName)
			System.out.println(employee);
	}
	public static void main(String[] args) {
		EmployeeManager manager = new EmployeeManager();
		Set<Employee> employees = manager.createEmployeeSet();
		
		System.out.println("\nOriginal with sorted with Employee ID : ");
		for(Employee employee : employees)
			System.out.println(employee);
		manager.sortByFirstName(employees);
	}
	
	
}
