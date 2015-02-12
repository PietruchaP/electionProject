package hibernate.dao;

import hibernate.model.ZipCodes;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class ZipCodesDAOTest {
	
	@Autowired
	ZipCodesDAO zipCodesDao;
	
	ZipCodes zipCode;
	
	@Before
	public void setup(){
		 zipCode = new ZipCodes();
	}
	
	@Test
    public void retriveZipObjectById() {

        zipCode.setId(1); 
        ZipCodes localZip = zipCodesDao.retrive(zipCode.getId());
        Assertions.assertThat(zipCodesDao.findAll()).contains(localZip);       
    }
	@Test
	public void loadZipObjectByZipCodeString(){
		
		 zipCode.setId(1); 
	        ZipCodes localZip = zipCodesDao.loadZipByZipCode("53-020");
		 Assertions.assertThat(zipCodesDao.findAll()).contains(localZip);
	}
	//@Test
	//public void testAllAtOnesAllZipCodeCRUD(){
		//ZipCodes testZipCode = new ZipCodes();
		//testZipCode.setZipCodes("99-989");
		//zipCodesDao.create(testZipCode);
		
		// Connection connection = getConnection();
		//  connection.setAutoCommit(false);    //begin transaction
		  
		  
	//	 zipCode.setZipCodes("77-777"); 
	 //    zipCodesDao.create(zipCode);
	//	 Assertions.assertThat(zipCodesDao.findAll()).contains(zipCode);
	//}
	
	
	
}
