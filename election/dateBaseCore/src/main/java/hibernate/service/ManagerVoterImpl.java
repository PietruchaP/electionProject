package hibernate.service;

import hibernate.dao.VoterDAO;
import hibernate.model.Voters;
import hibernate.model.ZipCodes;
import hibernate.service.interfaces.ManagerVoter;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ManagerVoterImpl implements ManagerVoter{
	
	@Autowired
	VoterDAO voterDAO;
	
	@Override
	public List<Voters> findAllVoters(){
		return voterDAO.findAll();
	}
	@Override
	public Voters loadVotersByPesel(String pesel){
		return voterDAO.loadVotersByPesel(pesel);
	}

}
