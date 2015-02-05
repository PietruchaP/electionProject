package spring.controller;

import java.util.List;

import hibernate.model.Candidates;
import hibernate.model.Voters;
import hibernate.model.ZipCodes;
import hibernate.service.Manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controler {
	
	@Autowired
	private Manager manager;
	
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
		manager.retriveZipCode(zipCode);
		return manager.retriveZipCode(zipCode);
	}
	
	 @RequestMapping(value =  RestURs.GET_ALL_ZIPCODES, method = RequestMethod.GET)
	    public @ResponseBody List<ZipCodes> getAllZipCodes() {
	        return manager.findAllZipCode();
	    }
	 
	 @RequestMapping(value =  RestURs.GET_ALL_PESELS, method = RequestMethod.GET)
	    public @ResponseBody List<Voters> getAllVoters() {
	        return manager.findAllVoters();
	    }
	 @RequestMapping(value =  RestURs.GET_ALL_CANDIDATE, method = RequestMethod.GET)
	    public @ResponseBody List<Candidates> getAllCandidates() {
	        return manager.findAllCandidates();
	    }
	// @RequestMapping(.................)
	// public void createZipCode(@RequestBody ZipCodes zipCode){ .create.
	 
}
