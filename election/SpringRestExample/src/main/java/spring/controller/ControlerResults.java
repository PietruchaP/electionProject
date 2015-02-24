package spring.controller;

import hibernate.model.Results;
import hibernate.model.ZipCodes;
import hibernate.service.interfaces.ManagerResults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControlerResults {

	@Autowired
	private ManagerResults managerResult;
	
	
	 @RequestMapping(value = RestURs.CREATE_RESULT, method = RequestMethod.POST)
	    @ResponseBody
	    public String createResult(@RequestBody Results result) {
	        System.out.println("/create POST");
	        System.out.println(result);
	        managerResult.insertResults(result);
	        return result.toString();
	    }
	 @RequestMapping(value = RestURs.GET_RESULT, method = RequestMethod.GET)
	    @ResponseBody
	    public Results getResult(@PathVariable("id") int resultId) {
	        Results result = new Results();
	        result.setId(resultId);
	        return managerResult.retriveResults(result);
	    }
}
