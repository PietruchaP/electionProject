package spring.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import hibernate.model.Voters;
import hibernate.model.ZipCodes;
import hibernate.service.interfaces.ManagerVoter;
import hibernate.service.interfaces.ManagerZipCode;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import spring.controller.ControlerVoters;
import spring.controller.RestURs;

//@Ignore
@RunWith(MockitoJUnitRunner.class)
public class TestControllerVoters {
	   public static final String SERVER_URI = "http://localhost:8080/SpringRestExample";
	   private MockMvc mockMvc;
	   
	   @Mock
	   private ManagerVoter manager;
	   
	   @InjectMocks
	   @Spy
	   private ControlerVoters voterController = new ControlerVoters();
	   
	   @Before
	    public void setUp() {
	        mockMvc = MockMvcBuilders.standaloneSetup(voterController).build();
	    }
	   	
	    @Test
	    public void shouldGetOneVoterByStringPesel() throws Exception{
	    	ZipCodes zipCode= new ZipCodes(1,"53-020");
	    	Voters voter = new Voters(1,"90122001722", zipCode);
	    	
	    	String answer = "{\"id\":1,\"pesel\":\"90122001722\",\"zipCode\":{\"id\":1,\"zipCodes\":\"53-020\"}}";
			
	    	Mockito.when(manager.loadVotersByPesel("90122001722")).thenReturn(voter); 
	    	
			mockMvc.perform(get("/rest/correctPesels/90122001722")).andExpect(status().isOk()).andExpect(content().string(answer));
	    }
	    
	    @Test
	    public void shouldGetAllVoter() throws Exception{
	    	List<Voters> possibleVoterList = new ArrayList<Voters>();
	    	ZipCodes zipCode= new ZipCodes(1,"53-020");
	    	
	    	possibleVoterList.add(new Voters(1,"90122001722", zipCode));
	    	possibleVoterList.add(new Voters(2,"80102001776", zipCode));
	    	
	    	String answer = "[{\"id\":1,\"pesel\":\"90122001722\",\"zipCode\":{\"id\":1,\"zipCodes\":\"53-020\"}},{\"id\":2,\"pesel\":\"80102001776\",\"zipCode\":{\"id\":1,\"zipCodes\":\"53-020\"}}]";
	    	
	    	Mockito.when(manager.findAllVoters()).thenReturn(possibleVoterList);
	    	
			mockMvc.perform(get(RestURs.GET_ALL_PESELS)).andExpect(status().isOk()).andExpect(content().string(answer));
	    }

}
