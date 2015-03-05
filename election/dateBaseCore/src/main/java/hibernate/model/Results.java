package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table (name = "results")
public class Results{	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((candidates == null) ? 0 : candidates.hashCode());
		result = prime * result
				+ ((elections == null) ? 0 : elections.hashCode());
		result = prime * result + id;
		result = prime * result + ((voters == null) ? 0 : voters.hashCode());
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
		Results other = (Results) obj;
		if (candidates == null) {
			if (other.candidates != null)
				return false;
		} else if (!candidates.equals(other.candidates))
			return false;
		if (elections == null) {
			if (other.elections != null)
				return false;
		} else if (!elections.equals(other.elections))
			return false;
		if (id != other.id)
			return false;
		if (voters == null) {
			if (other.voters != null)
				return false;
		} else if (!voters.equals(other.voters))
			return false;
		return true;
	}
	private int id;	
	private Voters voters;
	private Candidates candidates;
	private Elections elections;

	public Results(){
		
	}
public Results(int id){
		this.id = id;
	}
	public Results(int id, Voters voters,Candidates candidates,Elections elections){
		this.id = id;
		this.voters = voters;
		this.candidates = candidates;
		this.elections = elections;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="id")
	public int getId(){
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}

	@ManyToOne
	@JoinColumn (name ="voters_id")
	public Voters getVoters(){
		return voters;
	}
	
	public void setVoters(Voters voters){
		this.voters = voters;
	}
	
	@ManyToOne
	@JoinColumn (name ="elections_id")
	public Elections getElections(){
		return elections;
	}
	
	public void setElections(Elections elections){
		this.elections = elections;
	}
	
	@ManyToOne
	@JoinColumn (name ="candidates_id")
	public Candidates getCandidates(){
		return candidates;
	}
	public void setCandidates(Candidates candidates){
		this.candidates = candidates;
	}
}
