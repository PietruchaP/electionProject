package TOs;

public class Voters {
	
	private int id;
	private ZipCodes zipCode;
	private String pesel;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	public ZipCodes getZipCode() {
		return zipCode;
	}
	public void setZipCode(ZipCodes zipCode){
		this.zipCode = zipCode;
	}
}
