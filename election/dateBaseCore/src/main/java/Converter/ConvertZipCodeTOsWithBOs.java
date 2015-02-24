package Converter;

import hibernate.model.ZipCodes;

public class ConvertZipCodeTOsWithBOs implements ConvertGeneric<TOs.ZipCodes, ZipCodes> {
	@Override
	public ZipCodes convertToToBo(TOs.ZipCodes zipCodeTO){
		ZipCodes zipCodeBO = new ZipCodes();
		zipCodeBO.setId(zipCodeTO.getId());
		zipCodeBO.setZipCodes(zipCodeTO.getZipCodes());
		return zipCodeBO;
	}
	@Override
	public TOs.ZipCodes convertBoToTo(ZipCodes zipCodeBO){
		TOs.ZipCodes zipCodeTO = new TOs.ZipCodes();
		zipCodeTO.setId(zipCodeBO.getId());
		zipCodeTO.setZipCodes(zipCodeBO.getZipCodes());
		return zipCodeTO;
	}
}

