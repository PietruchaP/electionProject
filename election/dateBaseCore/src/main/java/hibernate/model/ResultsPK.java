package hibernate.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;


@Embeddable
public class ResultsPK {

	private Voters voters;
	private Candidates candidates;
	private Elections elections;
	
	@ManyToOne
	public Voters getVoters(){
		return voters;
		
	}
	
	public void setVoters(Voters voters){
		this.voters=voters;
	}
	@ManyToOne
	public Elections getElections(){
		return elections;
	}
	public void setElections(Elections elections){
		this.elections=elections;
	}
	@ManyToOne
	public Candidates getCandidates(){
		return candidates;
		
	}
	
	public void setCandidates(Candidates candidates){
		this.candidates=candidates;
	}
}
