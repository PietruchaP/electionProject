package hibernate.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.dao.ResultsDAO;
import hibernate.model.Results;

import hibernate.service.interfaces.ManagerResults;

@Transactional
@Service
public class ManagerResultsImpl implements ManagerResults{

	@Autowired
	ResultsDAO resultsDAO;
	
	@Override
	public void  insertResults(Results result) {
		resultsDAO.create(result);
		
	}

}
