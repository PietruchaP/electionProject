package spring.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import hibernate.service.interfaces.ManagerZipCode;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:testContext.xml"})
@WebAppConfiguration
public class ControlerZipCodeTest {

	   private MockMvc mockMvc;
	   
	   @Autowired
	   private ManagerZipCode managerZipCodeMock;
	   
	   @Autowired
	    private WebApplicationContext webApplicationContext;
 
	   @Before
	    public void setUp() {
		   Mockito.reset(managerZipCodeMock);
	        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	    }
	   	
//	    @Test
//	    public void shouldGetZipCode() throws Exception{
//	    	String answer = "{\"id\":1,\"zipCodes\":\"53-020\"}";
//			mockMvc.perform(get("/rest/zipCode/1")).andExpect(status().isOk()).andExpect(content().string(answer));
//	    }


	
	
}
