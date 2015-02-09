package spring.controller;

import java.util.List;

import hibernate.model.Candidates;
import hibernate.service.interfaces.ManagerCandidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControlerCandidate {

	@Autowired
	private ManagerCandidate managerCandidate;
	 
	 @RequestMapping(value =  RestURs.GET_ALL_CANDIDATE, method = RequestMethod.GET)
	    public @ResponseBody List<Candidates> getAllCandidates() {
	        return managerCandidate.findAllCandidates();
	    }
}
