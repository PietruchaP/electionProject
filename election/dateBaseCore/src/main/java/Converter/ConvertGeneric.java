package Converter;

public interface ConvertGeneric<TO,BO> {
	public BO convertToToBo(TO genericTO);
	public TO convertBoToTo(BO genericBO);
}
