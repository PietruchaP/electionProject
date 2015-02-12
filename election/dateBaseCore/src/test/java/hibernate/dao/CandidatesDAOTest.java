package hibernate.dao;

import hibernate.model.Candidates;
import hibernate.model.ZipCodes;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class CandidatesDAOTest {

	
	@Autowired
	CandidateDAO candidateDao;
	
	ZipCodes zipCode;
	
	
	@Before
	public void setup(){
		 zipCode = new ZipCodes();
	}
	
	@Test
    public void shouldLoadCorrectCandidate(){
		zipCode.setId(1);
		
		List<Candidates> candidates = candidateDao.loadCorrectCandidate(zipCode.getId());
		for(int i=0;i<candidates.size();i++){
			Assertions.assertThat(candidateDao.findAll()).contains(candidates.get(i));   
		}
	}
}
