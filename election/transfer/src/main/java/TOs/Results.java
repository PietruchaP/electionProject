package TOs;

public class Results {

	private Voters voters;
	private Candidates candidates;
	private Elections elections;
	
	public Voters getVoters(){
		return voters;
		
	}	
	public void setVoters(Voters voters){
		this.voters=voters;
	}
	
	public Elections getElections(){
		return elections;
	}
	public void setElections(Elections elections){
		this.elections=elections;
	}
	
	public Candidates getCandidates(){
		return candidates;
		
	}
	public void setCandidates(Candidates candidates){
		this.candidates=candidates;
	}
}
