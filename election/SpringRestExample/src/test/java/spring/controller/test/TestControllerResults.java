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
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import spring.controller.ControlerResults;
import spring.controller.ControlerZipCode;

@RunWith(MockitoJUnitRunner.class)
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
	    public void shouldGetOneResult() throws Exception {
		    String inputStr = "2014-11-16";
	    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    	Date inputDate = dateFormat.parse(inputStr);
	    	
	    	ZipCodes zipCode= new ZipCodes(1,"53-020");
	      	Candidates candidate = new Candidates(1,"Piotr","Pietrucha", zipCode);
	    	Voters voter = new Voters(1,"90122001722", zipCode);
	    	Elections elections = new Elections(1, inputDate, "Wybory samorządowe 2014");
	    	
//	    	result.setElections(elections);
//	    	result.setCandidates(candidate);
//	    	result.setVoters(voter); 
	    	
	    	Mockito.when(manager.retriveResults(new Results(1))).thenReturn(new Results(1,voter,candidate,elections));
	    	String answer = "{\"id\":1,\"voters\":{\"id\":1,\"pesel\":\"90122001722\",\"zipCode\":{\"id\":1,\"zipCodes\":\"53-020\"}},\"candidates\":{\"id\":1,\"firstname\":\"Piotr\",\"surname\":\"Pietrucha\",\"zipCode\":{\"id\":1,\"zipCodes\":\"53-020\"}},\"elections\":{\"id\":1,\"election_date\":1416092400000,\"type\":\"Wybory samorządowe 2014\"}}";
	    	mockMvc.perform(get("/rest/result/1")).andExpect(status().isOk()).andExpect(content().string(answer));
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

	    	String sended = "{\"voters\":{\"id\":1,\"pesel\":\"90122001722\",\"zipCode\":{\"id\":1,\"zipCodes\":\"53-020\"}},\"candidates\":{\"id\":1,\"firstname\":\"Piotr\",\"surname\":\"Pietrucha\",\"zipCode\":{\"id\":1,\"zipCodes\":\"53-020\"}},\"elections\":{\"id\":1,\"election_date\":1416092400000,\"type\":\"Wybory samorządowe 2014\"}}";
	    	
	    	//String answer = "{\"id\":1,\"voters\":{\"id\":1,\"pesel\":\"90122001722\",\"zipCode\":{\"id\":1,\"zipCodes\":\"53-020\"}},\"candidates\":{\"id\":1,\"firstname\":\"Piotr\",\"surname\":\"Pietrucha\",\"zipCode\":{\"id\":1,\"zipCodes\":\"53-020\"}},\"elections\":{\"id\":1,\"election_date\":1416092400000,\"type\":\"Wybory samorządowe 2014\"}}";
	    	
	    	System.out.println(result.toString());
	    	mockMvc.perform(post("/rest/result").content(sended).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());//.andExpect(content().string(answer));	
	    }

}
