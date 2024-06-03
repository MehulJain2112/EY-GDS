package com.ey.day5assignment;

import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Address address1 = new Address("Srinagar","Bangalore","Karnataka","560050");
		Address address2 = new Address("KRPuram","Bangalore","Karnataka","560001");
		
		Student student1 = new Student("Mehul","Jain",23,address1);
		Student student2 = new Student("Chikoo","Jain",8,address2);
		// Student 3 = Duplicate of student 1
		Student student3 = new Student("Mehul","Jain",23,address1);
		
		Set<Student> studentSet = new HashSet<>();
		studentSet.add(student1);
		studentSet.add(student2);
		// It should not add student 3 as its a dupicate
		studentSet.add(student3);
		
		for(Student student:studentSet)
			System.out.println(student);
	}
}
