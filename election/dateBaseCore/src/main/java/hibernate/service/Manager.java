package hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import hibernate.model.ZipCodes;

public interface Manager {
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
}
