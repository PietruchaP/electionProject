package spring.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import hibernate.model.Candidates;
import hibernate.model.Elections;
import hibernate.model.Results;
import hibernate.model.Voters;
import hibernate.model.ZipCodes;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import spring.controller.ControlerZipCode;
import spring.controller.RestURs;

@RunWith(MockitoJUnitRunner.class)
public class TestControllerZipCode {
	   public static final String SERVER_URI = "http://localhost:8080/SpringRestExample";
	   
	   private MockMvc mockMvc;
	   
	   @Mock
	   private ManagerZipCode manager;
	   
	   @InjectMocks
	   @Spy
	   private ControlerZipCode zipCodeController = new ControlerZipCode();
	   
	   @Before
	    public void setUp() {
	        mockMvc = MockMvcBuilders.standaloneSetup(zipCodeController).build();
	    }
	   	
	    @Test
	    public void shouldGetOneZipCode() throws Exception {
	    	Mockito.when(manager.retriveZipCode(new ZipCodes(1))).thenReturn(new ZipCodes(1,"53-020"));
	    	String answer = "{\"id\":1,\"zipCodes\":\"53-020\"}";
			mockMvc.perform(get("/rest/zipCode/1")).andExpect(status().isOk()).andExpect(content().string(answer));
	    }

	    @Test
	    public void shouldGetOneZipCodeByStringZipCode() throws Exception{
	    	/////////////Mockito.when(manager.retriveZipCode(new ZipCodes(1))).thenReturn(new ZipCodes(1,"53-020"));
	    	String answer = "{\"id\":1,\"zipCodes\":\"53-020\"}";
			
	    	Mockito.when(manager.findZipByZipCode("53-020")).thenReturn(new ZipCodes(1,"53-020"));
	    	
			mockMvc.perform(get("/rest/zipCodeString/53-020")).andExpect(status().isOk()).andExpect(content().string(answer));
	    }
	    
	    @Test
	    public void shouldGetAllZipCode() throws Exception{
	    	List<ZipCodes> possibleList = new ArrayList<ZipCodes>();
	    	possibleList.add(new ZipCodes(1,"53-020"));
	    	possibleList.add(new ZipCodes(2,"51-120"));
	    	String answer = "[{\"id\":1,\"zipCodes\":\"53-020\"},{\"id\":2,\"zipCodes\":\"51-120\"}]";
	    	
	    	Mockito.when(manager.findAllZipCode()).thenReturn(possibleList);
	    	
			mockMvc.perform(get(RestURs.GET_ALL_ZIPCODES)).andExpect(status().isOk()).andExpect(content().string(answer));
	    }
	
}
