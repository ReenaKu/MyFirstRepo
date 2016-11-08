package com.capgemini.model;

public class Customer {
	
	private String FirstName;
	private String LastName;
	private String Address;
	
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "Customer [FirstName=" + FirstName + ", LastName=" + LastName + ", Address=" + Address + "]";
	}
	
	
	

}
