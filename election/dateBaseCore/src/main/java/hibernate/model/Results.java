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

	private int id;	
	private Voters voters;
	private Candidates candidates;
	private Elections elections;

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
