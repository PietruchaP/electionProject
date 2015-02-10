package spring.controller;

import hibernate.model.Elections;
import hibernate.service.interfaces.ManagerElections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControlerElections {
	
	@Autowired
	private ManagerElections managerElections;
		
	@RequestMapping(value = RestURs.GET_ELECTIONS, method = RequestMethod.GET)
	public @ResponseBody Elections getElections(@PathVariable("id") int electionId) {

		Elections election = new Elections();
		election.setId(electionId);
		return managerElections.retriveElection(election);
	}
}
