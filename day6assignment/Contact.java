package com.ey.day6assignment;

import java.util.Date;

public class Contact {
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private String mobileNumber;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public boolean isValid() {
		return firstName!=null && !firstName.isEmpty()
				&& lastName!=null && !lastName.isEmpty()
				&& dateOfBirth!=null
				&&(gender.equalsIgnoreCase("Male")||gender.equalsIgnoreCase("Female"))
				&& mobileNumber!=null && mobileNumber.matches("\\d{10}");
	}
	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
}
