package hibernate.service.interfaces;

import hibernate.model.Elections;

import javax.transaction.Transactional;

public interface ManagerElections {

	@Transactional
	public Elections retriveElection(Elections election);
}
