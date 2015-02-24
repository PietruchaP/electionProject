package TOs;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;


public class Candidates {
	
	private int id;
	private String firstname;
	private String surname;	
	private ZipCodes zipCode;
	
	public Candidates(){
		
	}
	public Candidates(int id, String firstname, String surname,
			ZipCodes zipCode) {
	this.id = id;
	this.firstname=firstname;
	this.surname=surname;
	this.zipCode=zipCode;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public ZipCodes getZipCode() {
		return zipCode;
	}
	public void setZipCode(ZipCodes zip_Code ){
		zipCode = zip_Code;
	}
	
/*	@JsonSerialize(using=DateSerializer.class)
	public ZipCodes getCreatedDate() {
		return zipCode;
	}
	public void setCreatedDate(ZipCodes zipCode) {
		this.zipCode = zipCode;
	}*/
}
