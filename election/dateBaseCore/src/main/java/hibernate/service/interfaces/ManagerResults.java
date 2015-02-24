package hibernate.service.interfaces;

import hibernate.model.Results;

import javax.transaction.Transactional;

public interface ManagerResults {

	@Transactional
	public void insertResults(Results result);

	public Results retriveResults(Results result);
}
