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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((pesel == null) ? 0 : pesel.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		Voters other = (Voters) obj;
		if (id != other.id)
			return false;
		if (pesel == null) {
			if (other.pesel != null)
				return false;
		} else if (!pesel.equals(other.pesel))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) @Column (name="id")
	private int id;
	
	@Column (name="pesel")
	private String pesel;
	
	@ManyToOne
	@JoinColumn (name = "zip_codes_id")
	private ZipCodes zipCode;
	public Voters(){
		
	}
	public Voters(int id, String pesel, ZipCodes zipCode) {
		this.id = id;
		this.pesel = pesel;
		this.zipCode = zipCode;
	}
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
