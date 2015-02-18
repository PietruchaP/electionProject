package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "zip_codes")
public class ZipCodes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) @Column (name="id")
	private int id;
	@Column (name ="zip_code")
	private String zipCodes;
	
	public ZipCodes() {
	}
	public ZipCodes(int id) {
		this.id = id;
	}
	
	public ZipCodes(int id, String zipcode) {
		this.id= id;
		this.zipCodes = zipcode;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((zipCodes == null) ? 0 : zipCodes.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZipCodes other = (ZipCodes) obj;
		if (id != other.id)
			return false;
		if (zipCodes == null) {
			if (other.zipCodes != null)
				return false;
		} else if (!zipCodes.equals(other.zipCodes))
			return false;
		return true;
	}
	
	
}
