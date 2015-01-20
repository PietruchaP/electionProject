package spring.tests;

import hibernate.model.ZipCodes;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import spring.controller.RestURs;

public class TestSpringRestExample {

	public static final String SERVER_URI = "http://localhost:9090/SpringRestExample";
	
	public static void main(String args[]){
		
		testGetDummyEmployee();
		System.out.println("*****");
		testCreateEmployee();
		System.out.println("*****");
		testGetEmployee();
		System.out.println("*****");
		testGetAllEmployee();
	}

	private static void testGetAllEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> zipCodes = restTemplate.getForObject(SERVER_URI+RestURs.GET_ALL_ZIPCODES, List.class);
		System.out.println(zipCodes.size());
		for(LinkedHashMap map : zipCodes){
			System.out.println("ID="+map.get("id")+",Zipcode="+map.get("zipCode"));;
		}
	}

	private static void testCreateEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		ZipCodes zipCode = new ZipCodes ();
		zipCode.setId(1);zipCode.setZipCodes("11-111");
		ZipCodes  response = restTemplate.postForObject(SERVER_URI+RestURs.CREATE_ZIPCODE, zipCode, ZipCodes.class);
		printZipCodeData(response);
	}

	private static void testGetEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		ZipCodes zipCode = restTemplate.getForObject(SERVER_URI+"/rest/emp/1", ZipCodes.class);
		printZipCodeData(zipCode);
	}

	private static void testGetDummyEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		ZipCodes zipCode = restTemplate.getForObject(SERVER_URI+RestURs.DUMMY, ZipCodes.class);
		printZipCodeData(zipCode);
	}
	
	public static void printZipCodeData(ZipCodes zipCode){
		System.out.println("ID="+zipCode.getId()+",Zipcode="+zipCode.getZipCodes());
	}
}
