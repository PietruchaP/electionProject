package hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import hibernate.dao.CandidateDAO;
import hibernate.dao.VoterDAO;
import hibernate.dao.ZipCodesDAO;
import hibernate.model.Candidates;
import hibernate.model.Voters;
import hibernate.model.ZipCodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Transactional
@Service
public class ManagerImpl implements Manager{

	@Autowired
	ZipCodesDAO zipCodeDAO;
	
	@Autowired
	VoterDAO voterDAO;
	
	@Autowired 
	CandidateDAO candidateDAO;
	
	public void setZipCodesDAO(ZipCodesDAO zipCodeDAO) {
        this.zipCodeDAO = zipCodeDAO;
    }
	
	@Override
	public void insertZipCode(ZipCodes zipCode) {
		zipCodeDAO.create(zipCode);	
	}

	@Override
	public ZipCodes retriveZipCode(ZipCodes zipCode) {
		return zipCodeDAO.retrive(zipCode.getId());	
	}

	@Override
	public void updateZipCode(ZipCodes zipCode) {
		zipCodeDAO.update(zipCode);
	}

	@Override
	public void deleteZipCode(ZipCodes zipCode) {
		zipCodeDAO.delete(zipCode.getId());	
	}
	
	@Override
	public List<ZipCodes> findAllZipCode(){
		return zipCodeDAO.findAll();
	}

	@Override
	public List<Voters> findAllVoters(){
		return voterDAO.findAll();
	}
	@Override
	public List<Candidates> findAllCandidates(){
		return candidateDAO.findAll();
	}
//	@Override
//	public List<Voters> findCorrectVoters(ZipCodes zipCode){
		
	//}
	
}
