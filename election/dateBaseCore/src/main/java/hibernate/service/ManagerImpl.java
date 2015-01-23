package hibernate.service;

import hibernate.dao.ZipCodesDAO;
import hibernate.model.ZipCodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerImpl implements Manager{

	@Autowired
	ZipCodesDAO zipCodeDAO;
	
	public void setZipCodesDAO(ZipCodesDAO zipCodeDAO) {
        this.zipCodeDAO = zipCodeDAO;
    }
	
	@Override
	public void insertZipCode(ZipCodes zipCode) {
		zipCodeDAO.create(zipCode);	
	}

	@Override
	public void retriveZipCode(ZipCodes zipCode) {
		zipCodeDAO.retrive(zipCode.getId());	
	}

	@Override
	public void updateZipCode(ZipCodes zipCode) {
		zipCodeDAO.update(zipCode);
	}

	@Override
	public void deleteZipCode(ZipCodes zipCode) {
		zipCodeDAO.delete(zipCode.getId());	
	}

	
	
	
}
