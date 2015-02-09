package hibernate.service.interfaces;

import hibernate.model.Voters;
import hibernate.model.ZipCodes;

import java.util.List;

import javax.transaction.Transactional;

public interface ManagerVoter {
	
	@Transactional
	public List<Voters> findAllVoters();
	@Transactional
	public List<Voters> loadVotersByPesel(String pesel);
}
