package com.bank.model;

public class Address {
	
	 private String number;
	 private String street;
	 private String town;
	 private String postcode;
	
	 public Address(){
		 
	 }
	 
	 public Address(String number, String street, String town, String postcode){
		 this.number = number;
		 this.street = street;
		 this.town = town;
		 this.postcode = postcode;
	 }
	 
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	 
	 

}
