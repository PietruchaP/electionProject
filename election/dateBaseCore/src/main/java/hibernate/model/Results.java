package hibernate.model;

import java.beans.Transient;
import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
//przeksztalcamy baze
//@Entity
//@Table (name = "results")
@AssociationOverrides({
	@AssociationOverride(name = "pk.voters", joinColumns = @JoinColumn(name="voters_id")),
	@AssociationOverride(name = "pk.elections", joinColumns = @JoinColumn(name="elections_id")),
	@AssociationOverride(name = "pk.candidates", joinColumns = @JoinColumn(name="candidates_id"))
})
public class Results implements Serializable{
	
	private ResultsPK pk = new ResultsPK();
	
	@EmbeddedId
	private ResultsPK getPK(){
		return pk;
	}
	
	private void setPK(ResultsPK pk){
		this.pk = pk;
	}
	
	@Transient
	public Voters getVoters(){
		return getPK().getVoters();
	}
	
	public void setVoters(Voters voters){
		getPK().setVoters(voters);
	}
	
	@Transient
	public Elections getElections(){
		return getPK().getElections();
	}
	
	public void setElections(Elections elections){
		getPK().setElections(elections);
	}
	
	@Transient
	public Candidates getCandidates(){
		return getPK().getCandidates();
	}
	public void setCandidates(Candidates candidates){
		getPK().setCandidates(candidates);
	}
}
