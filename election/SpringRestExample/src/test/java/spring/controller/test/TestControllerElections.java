package spring.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import hibernate.model.Elections;
import hibernate.model.ZipCodes;
import hibernate.service.interfaces.ManagerElections;
import hibernate.service.interfaces.ManagerZipCode;

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

import spring.controller.ControlerElections;


@RunWith(MockitoJUnitRunner.class)
public class TestControllerElections {
	 public static final String SERVER_URI = "http://localhost:8080/SpringRestExample";
	   
	   private MockMvc mockMvc;
	   
	   @Mock
	   private ManagerElections manager;
	   
	   @InjectMocks
	   @Spy
	   private ControlerElections electionsController = new ControlerElections();
	   
	   @Before
	    public void setUp() {
	        mockMvc = MockMvcBuilders.standaloneSetup(electionsController).build();
	    }
	   	
	    @Test
	    public void shouldGetOneElections() throws Exception {
	    	String inputStr = "2014-11-16";
	    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    	Date inputDate = dateFormat.parse(inputStr);
	    	Elections eco = new Elections(1, inputDate, "Wybory samorządowe 2014");
	    	System.out.println(eco.getElection_date());
	    	Mockito.when(manager.retriveElection(new Elections(1))).thenReturn(new Elections(1, inputDate, "Wybory samorządowe 2014"));
	    	String answer = "{\"id\":1,\"election_date\":1416092400000,\"type\":\"Wybory samorządowe 2014\"}";

			mockMvc.perform(get("/rest/elections/1")).andExpect(status().isOk());//.andExpect(content().string(answer));

	    }
}
