package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table (name = "candidates")
public class Candidates {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) @Column (name="id")
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="firsname")
	private String firstname;	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Column (name="surname")
	private String surname;
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn (name = "zip_codes_id")
	private ZipCodes zipCode;
	public ZipCodes getZip_Code() {
		return zipCode;
	}
	public void setZip_Code(ZipCodes zipCode ){
		this.zipCode = zipCode;
	}
}
