package Converter;

import hibernate.model.Voters;
import hibernate.model.ZipCodes;

public class ConvertVotersTOsWithBOs implements ConvertGeneric<TOs.Voters,Voters> {

	@Override
	public Voters convertToToBo(TOs.Voters votersTO){
		Voters votersBO = new Voters();
		votersBO.setId(votersTO.getId());
		votersBO.setPesel(votersTO.getPesel());
		ZipCodes zipCodesBO = new ZipCodes(votersTO.getZipCode().getId(),votersTO.getZipCode().getZipCodes());
		votersBO.setZipCode(zipCodesBO);
		return votersBO;
	}
	@Override
	public TOs.Voters convertBoToTo(Voters votersBO){
		TOs.Voters votersTO = new TOs.Voters();
		votersTO.setId(votersBO.getId());
		votersTO.setPesel(votersBO.getPesel());
		TOs.ZipCodes zipCodesTO = new TOs.ZipCodes(votersBO.getZipCode().getId(),votersBO.getZipCode().getZipCodes());
		votersTO.setZipCode(zipCodesTO);
		return votersTO;
	}
}
