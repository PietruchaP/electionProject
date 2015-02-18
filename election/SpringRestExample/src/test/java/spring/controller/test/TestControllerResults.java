package spring.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import hibernate.model.Candidates;
import hibernate.model.Elections;
import hibernate.model.Results;
import hibernate.model.Voters;
import hibernate.model.ZipCodes;
import hibernate.service.interfaces.ManagerResults;
import hibernate.service.interfaces.ManagerZipCode;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import spring.controller.ControlerResults;
import spring.controller.ControlerZipCode;

public class TestControllerResults {
   public static final String SERVER_URI = "http://localhost:8080/SpringRestExample";
	   
	   private MockMvc mockMvc;
	   
	   @Mock
	   private ManagerResults manager;
	   
	   @InjectMocks
	   @Spy
	   private ControlerResults resultsController = new ControlerResults();
	   
	   @Before
	    public void setUp() {
	        mockMvc = MockMvcBuilders.standaloneSetup(resultsController).build();
	    }
	   	
	    @Test
	    public void shouldSaveOneResult() throws Exception {
	    	String inputStr = "2014-11-16";
	    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    	Date inputDate = dateFormat.parse(inputStr);
	    	
	    	ZipCodes zipCode= new ZipCodes(1,"53-020");
	      	Candidates candidate = new Candidates(1,"Piotr","Pietrucha", zipCode);
	    	Voters voter = new Voters(1,"90122001722", zipCode);
	    	Elections elections = new Elections(1, inputDate, "Wybory samorządowe 2014");
	    	
	    	Results result = new Results();
	    	result.setElections(elections);
	    	result.setCandidates(candidate);
	    	result.setVoters(voter);   	

	    	String answer = "{\"voters\":{\"id\":1,\"pesel\":\"90122001722\",\"zipCode\":{\"id\":1,\"zipCodes\":\"53-020\"}} , \"candidates\":{\"id\":1,\"firstname\":\"Piotr\",\"surname\":\"Pietrucha\",\"zipCode\":{\"id\":1,\"zipCodes\":\"53-020\"}},  \"elections\":{\"id\":1,\"election_date\":1416092400000,\"type\":\"Wybory samorządowe 2014\"}";

	    	
	    	System.out.println(result.toString());
		//	mockMvc.perform(post("/rest/result").contentType(MediaType.APPLICATION_FORM_URLENCODED).param(name, values)).andExpect(content().string(result.toString())); // andExpect(status().isOk()).andExpect(content().string(answer));
	    	mockMvc.perform(post("/rest/result").content(answer).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());	
	    	//  mockMvc.perform(post("/user/create").content("{\"login\":\"Login\",\"password\":\"Password\"}").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk());	    

	    }

}
