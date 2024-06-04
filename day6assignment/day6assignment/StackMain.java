package com.ey.day6assignment;

import java.text.SimpleDateFormat;

public class StackMain {
	public static void main(String[] args) {
		try {
			Stack stack = new Stack(2);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			Contact contact1 = new Contact();
			contact1.setFirstName("Mehul");
			contact1.setLastName("Jain");
			contact1.setDateOfBirth(dateFormat.parse("2001-01-15"));
			contact1.setGender("Male");
			contact1.setMobileNumber("6362795752");
			
			stack.push(contact1);
			System.out.println("Pushed Contact : "+contact1);
			
			Contact contact2 = new Contact();
			contact2.setFirstName("XYZ");
			contact2.setLastName("ABC");
			contact2.setDateOfBirth(dateFormat.parse("2002-04-20"));
			contact2.setGender("Female");
			contact2.setMobileNumber("1234567890");
			
			stack.push(contact2);
			System.out.println("Pushed Contact : "+contact2);
			
			Contact popContact = stack.pop();
			System.out.println("Popped Contact : "+popContact.getFirstName()+" "+popContact.getLastName()+"\n ");
			
			stack.pop();
			stack.pop();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
