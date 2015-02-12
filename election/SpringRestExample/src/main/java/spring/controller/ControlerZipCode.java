package spring.controller;

import java.util.List;

import hibernate.model.Candidates;
import hibernate.model.Voters;
import hibernate.model.ZipCodes;
import hibernate.service.interfaces.ManagerZipCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControlerZipCode {
	
	@Autowired
	private ManagerZipCode managerZipCode;
	
	
	@RequestMapping(value = RestURs.DUMMY, method = RequestMethod.GET)
	public @ResponseBody ZipCodes getDummy() {
		ZipCodes zipCode = new ZipCodes();
		zipCode.setZipCodes("88-888");
		return zipCode;
	}
	
	@RequestMapping(value = RestURs.GET_ZIPCODE, method = RequestMethod.GET)
	public @ResponseBody ZipCodes getZipCode(@PathVariable("id") int zipCodeId) {

		ZipCodes zipCode = new ZipCodes();
		zipCode.setId(zipCodeId);
		return managerZipCode.retriveZipCode(zipCode);
	}
	
	 @RequestMapping(value =  RestURs.GET_ALL_ZIPCODES, method = RequestMethod.GET)
	    public @ResponseBody List<ZipCodes> getAllZipCodes() {
	        return managerZipCode.findAllZipCode();
	    }
	 
	 @RequestMapping(value =  RestURs.GET_ZIPCODE_BY_STRING_ZIP, method = RequestMethod.GET)
	    public @ResponseBody ZipCodes getZipByZipCode(@PathVariable("zipCode") String zipCode) {
	        return managerZipCode.findZipByZipCode(zipCode);
	    }

	 
}
