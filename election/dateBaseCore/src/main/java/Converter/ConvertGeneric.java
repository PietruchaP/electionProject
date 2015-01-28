package Converter;

public interface ConvertGeneric<TO,BO> {
	public void ConvertToToBo(TO genericTO);
	public void ConvertBoToTo();
}
