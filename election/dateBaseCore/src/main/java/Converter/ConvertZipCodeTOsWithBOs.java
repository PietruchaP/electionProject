package Converter;

import hibernate.model.ZipCodes;

public class ConvertZipCodeTOsWithBOs {

	

	public ZipCodes ConvertToToBo(TOs.ZipCodes zipCodeTO){
		ZipCodes zipCodeBO = new ZipCodes();
		zipCodeBO.setId(zipCodeTO.getId());
		zipCodeBO.setZipCodes(zipCodeTO.getZipCodes());
		return zipCodeBO;
	}
	
	public TOs.ZipCodes ConvertBoToTo(ZipCodes zipCodeBO){
		TOs.ZipCodes zipCodeTO = new TOs.ZipCodes();
		zipCodeTO.setId(zipCodeBO.getId());
		zipCodeTO.setZipCodes(zipCodeBO.getZipCodes());
		return zipCodeTO;
	}
}

