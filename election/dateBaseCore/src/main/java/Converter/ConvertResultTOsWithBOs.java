package Converter;

import hibernate.model.Results;


public class ConvertResultTOsWithBOs implements ConvertGeneric<TOs.Results, Results>{

	@Override
	public Results convertToToBo(TOs.Results resultTO) {
		
		Results result = new Results();
		return null;
	}

	@Override
	public TOs.Results convertBoToTo(Results resultBO) {
		// TODO Auto-generated method stub
		return null;
	}

}
