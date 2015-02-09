package hibernate.service.interfaces;

import java.util.List;

import javax.transaction.Transactional;

import hibernate.model.Candidates;
import hibernate.model.Results;
import hibernate.model.Voters;
import hibernate.model.ZipCodes;

public interface ManagerZipCode {
	@Transactional
	public void insertZipCode(ZipCodes zipCode);
	@Transactional
	public ZipCodes retriveZipCode(ZipCodes zipCode);
	@Transactional
	public void updateZipCode(ZipCodes zipCode);
	@Transactional
	public void deleteZipCode(ZipCodes zipCode);
	@Transactional
	public List<ZipCodes> findAllZipCode();
	@Transactional
	public List<ZipCodes> findZipByZipCode(String zipCode);

	//@Transactional
	//void insertResults(Results results);
}
