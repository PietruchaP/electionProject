package Converter;

import hibernate.model.Candidates;

public abstract class ConvertGenericTOsWithBOs<TO,BO> implements ConvertGeneric<TO,BO> {

	private Class<BO> gemericBO;
	private Class<TO> gemericTO;
	
	public ConvertGenericTOsWithBOs(){
		
	}
	
	
	public void ConvertToToBo(TO genericTO){
		//BO genericBO = new BO();
		//genericTO.getClass().getMethods()[0].invoke(genericBO, null);
		
	}
	
	public void ConvertBoToTo(){
		
	}
}
