package Converter;

import hibernate.model.Candidates;
import hibernate.model.ZipCodes;

public class ConverterCandidatesTOsWithBOs  implements ConvertGeneric<TOs.Candidates,Candidates> {

	@Override
	public Candidates convertToToBo(TOs.Candidates candidateTO){
		ZipCodes zipCodesBO = new ZipCodes(candidateTO.getZipCode().getId(),candidateTO.getZipCode().getZipCodes());
		Candidates candidateBO = new Candidates(candidateTO.getId(),candidateTO.getFirstname(),candidateTO.getSurname(), zipCodesBO);
		return candidateBO;
	}
	@Override
	public TOs.Candidates convertBoToTo(Candidates candidateBO){
		TOs.ZipCodes zipCodesTO = new TOs.ZipCodes(candidateBO.getZipCode().getId(),candidateBO.getZipCode().getZipCodes());
		TOs.Candidates candidateTO = new TOs.Candidates(candidateBO.getId(),candidateBO.getFirstname(),candidateBO.getSurname(),zipCodesTO);
		return candidateTO;
	}

	
}
