package com.ey.day5assignment;

import java.util.Objects;

public class Student {
	private String firstName;
	private String lastName;
	private int age;
	private Address address;
	public Student(String firstName, String lastName, int age, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) 
			return true;
		if(obj==null || getClass()!=obj.getClass())
			return false;
		Student student = (Student)obj;
		return firstName.equals(student.firstName) && 
				lastName.equals(student.lastName) &&
				address.equals(student.address);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(firstName,lastName,address);
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address=" + address
				+ "]";
	}
	
	
}
