package Converter;

import hibernate.model.Voters;
import hibernate.model.ZipCodes;

public class ConvertVotersTOsWithBOs {


	public Voters ConvertToToBo(TOs.Voters votersTO){
		Voters votersBO = new Voters();
		votersBO.setId(votersTO.getId());
		votersBO.setPesel(votersTO.getPesel());
		ZipCodes zipCodesBO = new ZipCodes(votersTO.getZipCode().getId(),votersTO.getZipCode().getZipCodes());
		votersBO.setZipCode(zipCodesBO);
		return votersBO;
	}
	
	public TOs.Voters ConvertBoToTo(Voters votersBO){
		TOs.Voters votersTO = new TOs.Voters();
		votersTO.setId(votersBO.getId());
		votersTO.setPesel(votersBO.getPesel());
		TOs.ZipCodes zipCodesTO = new TOs.ZipCodes(votersBO.getZipCode().getId(),votersBO.getZipCode().getZipCodes());
		votersTO.setZipCode(zipCodesTO);
		return votersTO;
	}
}
