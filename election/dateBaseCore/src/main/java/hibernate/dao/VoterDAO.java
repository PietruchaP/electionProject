package hibernate.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import hibernate.model.Voters;


@Component
public class VoterDAO extends GenericDaoImp<Voters> {
		
	public Voters loadVotersByPesel(String pesel){	

		final Query query = this.entityManager.createQuery ("SELECT v FROM Voters v where v.pesel= :pesel");
		
		query.setParameter("pesel", pesel);
		
		Voters voters = (Voters)  query.getSingleResult();
        return voters;
	}

}
//Query query = this.entityManager.createQuery ("SELECT count(*) FROM ZipCodes z INNER JOIN Voters v ON z.id = v.zipCodeId WHERE v.pesel= :pesel");