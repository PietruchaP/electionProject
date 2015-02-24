package Converter;

import hibernate.model.Elections;


public class ConverterElectionsTOsWithBOs  implements ConvertGeneric<TOs.Elections,Elections>  {

	@Override
	public Elections convertToToBo(TOs.Elections electionTO) {
		Elections electionBO = new Elections(electionTO.getId(),electionTO.getElection_date(),electionTO.getType());
		return electionBO;
	}

	@Override
	public TOs.Elections convertBoToTo(Elections electionBO) {
		TOs.Elections electionTO = new TOs.Elections(electionBO.getId(),electionBO.getElection_date(),electionBO.getType());
		return electionTO;
	}

}
