package com.ey.day5assignment;

import java.util.Objects;

public class Address {
	private String  street;
	private String city;
	private String state;
	private String pincode;
	public Address(String street, String city, String state, String pincode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) 
			return true;
		if(obj==null || getClass()!=obj.getClass())
			return false;
		Address address = (Address)obj;
		return street.equals(address.street) && 
				city.equals(address.city) && 
				state.equals(address.state) &&
				pincode.equals(address.pincode);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(street,city,state,pincode);
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
	
	
}
