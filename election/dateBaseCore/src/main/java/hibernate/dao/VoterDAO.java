package hibernate.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import hibernate.model.Voters;


@Component
public class VoterDAO extends GenericDaoImp<Voters> {
		
	public List<Voters> loadVotersByPesel(String pesel){	

		//Query query = this.entityManager.createQuery ("SELECT count(*) FROM ZipCodes z INNER JOIN Voters v ON z.id = v.zipCodeId WHERE v.pesel= :pesel");
		final Query query = this.entityManager.createQuery ("SELECT v FROM Voters v where v.pesel= :pesel");
		
		query.setParameter("pesel", pesel);
		
		List<Voters> voters = (List<Voters>)  query.getResultList();
        return voters;
	}

}
