package com.ey.day6assignment;

import java.util.Scanner;

public class Source {
	 public static void main(String args[]) {
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("Enter first String : ");
		 String String1 = sc.nextLine();
		 
		 System.out.println("Enter Second String : ");
		 String String2 = sc.nextLine();
		 
		 System.out.println("Enter Operator (+ or -) : ");
		 String operator = sc.nextLine();
		 
		 Activity activity = new Activity(String1,String2,operator);
	     Source source = new Source();
	     try {
	         if (!source.validate(activity))
	             throw new OperatorException("Invalid parameters");
	         
	         System.out.println(source.doOperation(activity));

	     }
	     catch (OperatorException e) {
	         e.printStackTrace();
	     }
	 }

	 public boolean validate(Activity activity) throws OperatorException {
	     if (activity.getString1() == null || activity.getString2() == null || activity.getOperator() == null)
	         throw new NullPointerException("One or more fields are null");
	     
	     if (!activity.getOperator().equals("+") && !activity.getOperator().equals("-"))
	         throw new OperatorException("Invalid operator");
	     
	     return true;
	 }

	 public String doOperation(Activity activity) {
	     if (activity.getOperator().equals("+")) 
	         return activity.getString1() + activity.getString2();
	      else if (activity.getOperator().equals("-")) 
	         return activity.getString1().replace(activity.getString2(), "");
	     
	     return null;
	 }
}
