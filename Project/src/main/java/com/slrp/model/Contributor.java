package com.slrp.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Contributor {
	

	@OneToMany(targetEntity=Contribution.class)
	private Contribution contribution;
	
    public Contribution getContribution() {
		return contribution;
	}

	public void setContribution(Contribution contribution) {
		this.contribution = contribution;
	}

	public void makeContribution() {
    	
    }

	public Contributor(Contribution contribution) {
		super();
		this.contribution = contribution;
	}

	public Contributor() {
		// TODO Auto-generated constructor stub
	};
    
    
}
