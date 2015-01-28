package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "voters")
public class Voters {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) @Column (name="id")
	private int id;
	
	@Column (name="pesel")
	private String pesel;
	
	@ManyToOne
	@JoinColumn (name = "zip_codes_id")
	private ZipCodes zipCode;
	
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
