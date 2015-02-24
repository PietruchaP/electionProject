package spring.controller;

public class RestURs {


	public static final String DUMMY = "/rest/dummy";
	//--------------------------------------------------------------//
	public static final String GET_ZIPCODE = "/rest/zipCode/{id}";
	public static final String GET_ALL_ZIPCODES = "/rest/zipCodes";
	public static final String CREATE_ZIPCODE = "/rest/zipCodes/create";
	public static final String DELETE_ZIPCODE = "/rest/zipCodes/delete/{id}";
	public static final String GET_ZIPCODE_BY_STRING_ZIP = "/rest/zipCodeString/{zipCode}";
	//--------------------------------------------------------------//
	public static final String GET_CANDIDATE = "/rest/candidate/{id}";
	public static final String GET_ALL_CANDIDATE = "/rest/candidate";
	public static final String GET_CANDIDATE_BY_ZIPCODE = "/rest/candidateZipCode/{zipCodeID}";
	//--------------------------------------------------------------//
	public static final String GET_ALL_PESELS = "/rest/pesels";
	public static final String GET_CORRECT_PESELS = "/rest/correctPesels/{pesel}";
	//--------------------------------------------------------------//
	public static final String GET_ELECTIONS = "/rest/elections/{id}";
	//--------------------------------------------------------------//
	public static final String CREATE_RESULT = "/rest/result";
	public static final String GET_RESULT = "/rest/result/{id}";
	
}
