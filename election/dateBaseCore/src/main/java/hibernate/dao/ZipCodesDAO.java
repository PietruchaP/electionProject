package hibernate.dao;

import java.util.List;

import javax.persistence.Query;

import hibernate.model.Voters;
import hibernate.model.ZipCodes;

import org.springframework.stereotype.Component;

@Component
public class ZipCodesDAO extends GenericDaoImp<ZipCodes> {

	public List<ZipCodes> loadZipByZipCode(String zipCode){	
		
		final Query query = this.entityManager.createQuery ("SELECT z FROM ZipCodes z where z.zipCodes= :zipCode");
		query.setParameter("zipCode", zipCode);
		
		List<ZipCodes> zip = (List<ZipCodes>)  query.getResultList();
        return zip;
	}
}

