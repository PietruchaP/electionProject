package hibernate.dao;

import java.util.List;

import javax.persistence.Query;

import hibernate.model.Candidates;
import hibernate.model.ZipCodes;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class CandidateDAO extends GenericDaoImp<Candidates> {

	public List<Candidates> loadCorrectCandidate(int zipCodeID){	
		
		final Query query = this.entityManager.createQuery ("SELECT c FROM Candidates c where c.zipCode.id= :zipCodeID");
			query.setParameter("zipCodeID", zipCodeID);
			
			List<Candidates> candidates = (List<Candidates>)  query.getResultList();
	        return candidates;		
		
	}
}
