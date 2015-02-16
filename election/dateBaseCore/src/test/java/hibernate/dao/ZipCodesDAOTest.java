package hibernate.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hibernate.model.ZipCodes;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
@TransactionConfiguration
@Transactional
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
	@Test
	@Transactional
	public void testAllAtOnesAllZipCodeCRUD(){
		ZipCodes testZipCode = new ZipCodes();
		testZipCode.setZipCodes("99-989");
		zipCodesDao.create(testZipCode);
		
		Assertions.assertThat(zipCodesDao.findAll()).contains(testZipCode);
		
		testZipCode.setZipCodes("22-233");
		zipCodesDao.update(testZipCode);
		Assertions.assertThat(zipCodesDao.findAll()).contains(testZipCode);

		zipCodesDao.delete(testZipCode.getId());
		Assertions.assertThat(testZipCode).isNotIn(zipCodesDao.findAll());

	}
	
	
	
}
