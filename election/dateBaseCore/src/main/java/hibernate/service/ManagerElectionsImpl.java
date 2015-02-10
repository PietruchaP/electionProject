package hibernate.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.dao.ElectionsDAO;
import hibernate.model.Elections;
import hibernate.service.interfaces.ManagerElections;

@Transactional
@Service
public class ManagerElectionsImpl implements ManagerElections{

	@Autowired
	ElectionsDAO electionsDAO;
	
	@Override
	public Elections retriveElection(Elections election) {
		return electionsDAO.retrive(election.getId());	
	}

}
