package hibernate.model;

import java.io.Serializable;

public class ResultsPK implements Serializable {
	

	private int id;	
	private Voters voters;
	private Candidates candidates;
	private Elections elections;
	
	
//	@ManyToOne
//	@JoinColumn (name ="voters_id")
	public Voters getVoters(){
		return voters;
		
	}
	
	public void setVoters(Voters voters){
		this.voters=voters;
	}
	
//	@ManyToOne
//	@JoinColumn (name ="elections_id")
	public Elections getElections(){
		return elections;
	}
	public void setElections(Elections elections){
		this.elections=elections;
	}

//	@ManyToOne
//	@JoinColumn (name ="candidates_id")
	public Candidates getCandidates(){
		return candidates;		
	}
	
	public void setCandidates(Candidates candidates){
		this.candidates=candidates;
	}

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column (name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	 public int hashCode() {
	        return (int) voters.hashCode()+elections.hashCode()+candidates.hashCode() + id;
	    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof ResultsPK)) return false;
        if (obj == null) return false;
        ResultsPK pk = (ResultsPK) obj;
        return pk.id == id && pk.voters.equals(voters) && pk.elections.equals(elections) && pk.candidates.equals(candidates);
    }
}
