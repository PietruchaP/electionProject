package hibernate.service;

import java.util.List;

import hibernate.dao.CandidateDAO;
import hibernate.model.Candidates;
import hibernate.service.interfaces.ManagerCandidate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ManagerCandidateImpl implements ManagerCandidate{

	@Autowired 
	CandidateDAO candidateDAO;

	@Override
	public List<Candidates> findAllCandidates() {
		return candidateDAO.findAll();
	}
	
	
}
