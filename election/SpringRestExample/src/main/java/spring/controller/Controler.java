package spring.controller;

import java.util.List;

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

import spring.controller.RestURs;

@Controller
public class Controler {
	
	
	private static final Logger logger = LoggerFactory.getLogger(Controler.class);
	
	@Autowired
	private Manager manager;
	
	@RequestMapping(value = RestURs.DUMMY, method = RequestMethod.GET)
	public @ResponseBody ZipCodes getDummy() {
		logger.info("Start getDummyEmployee");
		ZipCodes zipCode = new ZipCodes();
		zipCode.setZipCodes("88-888");
		return zipCode;
	}
	
	@RequestMapping(value = RestURs.GET_ZIPCODE, method = RequestMethod.GET)
	public @ResponseBody ZipCodes getZipCode(@PathVariable("id") int zipCodeId) {
		logger.info("Start getZipCode ID="+zipCodeId);
		ZipCodes zipCode = new ZipCodes();
		zipCode.setId(zipCodeId);
		manager.retriveZipCode(zipCode);
		return manager.retriveZipCode(zipCode);
	}
	
	 @RequestMapping(value =  RestURs.GET_ALL_ZIPCODES, method = RequestMethod.GET)
	    public @ResponseBody List<ZipCodes> getAllZipCodes() {
	        return manager.findAllZipCode();
	    }
}
