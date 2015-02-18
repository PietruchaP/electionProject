package spring.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import hibernate.model.Candidates;
import hibernate.model.Voters;
import hibernate.model.ZipCodes;
import hibernate.service.interfaces.ManagerCandidate;
import hibernate.service.interfaces.ManagerVoter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import spring.controller.ControlerCandidate;
import spring.controller.ControlerVoters;
import spring.controller.RestURs;

@RunWith(MockitoJUnitRunner.class)
public class TestControllerCandidate {
	   public static final String SERVER_URI = "http://localhost:8080/SpringRestExample";
	   private MockMvc mockMvc;
	   
	   @Mock
	   private ManagerCandidate manager;
	   
	   @InjectMocks
	   @Spy
	   private ControlerCandidate candidateController = new ControlerCandidate();
	   
	   @Before
	    public void setUp() {
	        mockMvc = MockMvcBuilders.standaloneSetup(candidateController).build();
	    }
	   	
	    @Test
	    public void shouldGetOneCandidatesByZipCode() throws Exception{
	    	ZipCodes zipCode= new ZipCodes(1,"53-020");
	    	List<Candidates> candidateList = new ArrayList<Candidates>();
	    	candidateList.add(new Candidates(1,"Piotr","Pietrucha", zipCode));
	    	candidateList.add(new Candidates(2,"Stefan","Batory", zipCode));
	    	
	    	String answer = "[{\"id\":1,\"firstname\":\"Piotr\",\"surname\":\"Pietrucha\",\"zipCode\":{\"id\":1,\"zipCodes\":\"53-020\"}},{\"id\":2,\"firstname\":\"Stefan\",\"surname\":\"Batory\",\"zipCode\":{\"id\":1,\"zipCodes\":\"53-020\"}}]";
	    	
	    	Mockito.when(manager.loadCorrectCandidate(1)).thenReturn(candidateList);
	    	
			mockMvc.perform(get("/rest/candidateZipCode/1")).andExpect(status().isOk()).andExpect(content().string(answer));
	    }
	    
	    @Test
	    public void shouldGetAllCandidate() throws Exception{
	    	List<Candidates> possibleCandidateList = new ArrayList<Candidates>();
	    	ZipCodes zipCode= new ZipCodes(1,"53-020");

	    	possibleCandidateList.add( new Candidates(1,"Piotr","Pietrucha", zipCode));
	    	possibleCandidateList.add( new Candidates(2,"Stefan","Batory", zipCode));
	    	
	    	String answer = "[{\"id\":1,\"firstname\":\"Piotr\",\"surname\":\"Pietrucha\",\"zipCode\":{\"id\":1,\"zipCodes\":\"53-020\"}},{\"id\":2,\"firstname\":\"Stefan\",\"surname\":\"Batory\",\"zipCode\":{\"id\":1,\"zipCodes\":\"53-020\"}}]";
	    	
	    	Mockito.when(manager.findAllCandidates()).thenReturn(possibleCandidateList);
	    	
			mockMvc.perform(get(RestURs.GET_ALL_CANDIDATE)).andExpect(status().isOk()).andExpect(content().string(answer));
	    }
}
