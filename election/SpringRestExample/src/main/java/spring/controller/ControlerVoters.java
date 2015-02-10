package spring.controller;

import java.util.List;

import hibernate.model.Voters;
import hibernate.model.ZipCodes;
import hibernate.service.interfaces.ManagerVoter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControlerVoters {

	@Autowired
	private ManagerVoter managerVoter;
	
	 @RequestMapping(value =  RestURs.GET_ALL_PESELS, method = RequestMethod.GET)
	    public @ResponseBody List<Voters> getAllVoters() {
	        return managerVoter.findAllVoters();
	    }
	 @RequestMapping(value =  RestURs.GET_CORRECT_PESELS, method = RequestMethod.GET)
	    public @ResponseBody Voters getCorrectVoter(@PathVariable("pesel") String pesel) {
	        return managerVoter.loadVotersByPesel(pesel);
	    }
	
}
