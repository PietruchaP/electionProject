package TOs;

public class ZipCodes {
	
	private int id;
	private String zipCodes;
	public ZipCodes(){
		
	}
	public ZipCodes(int id, String zipCodes) {
		this.id = id;
		this.zipCodes = zipCodes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getZipCodes() {
		return zipCodes;
	}
	public void setZipCodes(String zipCodes) {
		this.zipCodes = zipCodes;
	}
	
}
