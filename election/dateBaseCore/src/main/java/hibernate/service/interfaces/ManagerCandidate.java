package hibernate.service.interfaces;

import hibernate.model.Candidates;

import java.util.List;

import javax.transaction.Transactional;

public interface ManagerCandidate {
	
	@Transactional
	public List<Candidates> findAllCandidates();
	
	@Transactional
	public List<Candidates> loadCorrectCandidate(int zipCodeID);
}
