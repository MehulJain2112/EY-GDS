package com.ey.day6assignment;

import java.util.Scanner;

public class AverageCalculator {
	public double calAverage(int n) {
		if(n<=0)
			throw new IllegalArgumentException("***Exception*** Input must be a Natural Number...");
		int sum = n*(n+1)/2;
		double average =(double)sum/n;
		return average;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AverageCalculator calculator = new AverageCalculator();
		
		try {
			System.out.println("Enter a number : ");
			int n = sc.nextInt();
			double average = calculator.calAverage(n);
			System.out.println("The average of first "+n+" Natural Numbers is "+average);
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		finally {
			sc.close();
		}
	}
}
