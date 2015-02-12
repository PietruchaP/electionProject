package hibernate.dao;

import hibernate.model.Candidates;
import hibernate.model.Voters;
import hibernate.model.ZipCodes;

import java.util.List;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class VotersDAOTest {

	
	@Autowired
	VoterDAO voterDao;
	
	String pesel;
	
	@Before
	public void setup(){
		 pesel = new String();
	}
	
	@Test
    public void loadVotersByPesel(){
		pesel = voterDao.retrive(1).getPesel();
		
		Voters voter = voterDao.loadVotersByPesel(pesel);
			Assertions.assertThat(voterDao.retrive(1).getId()).isSameAs(voter.getId());   
		}
	}


