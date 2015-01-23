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
import javax.persistence.Transient;

@Entity
@Table(name = "candidates")
public class Candidates {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "firsname")
	private String firstname;
	@Column(name = "surname")
	private String surname;
	
	@Transient
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "zip_codes_id")
	private ZipCodes zipCode;

	public Candidates() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}


	public ZipCodes getZip_Code() {
		return zipCode;
	}

	public void setZip_Code(ZipCodes zipCode) {
		this.zipCode = zipCode;
	}
}
