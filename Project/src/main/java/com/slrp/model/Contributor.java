package com.slrp.model;

<<<<<<< HEAD
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Contributor {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(targetEntity = Contribution.class)
	private List<Contribution> contributions;

	public List<Contribution> getContribution() {
		return contributions;
	}

	public void setContributions( List<Contribution> contributions) {
		this.contributions = contributions;
	}

	public void makeContribution() {

	}

	public Contributor(List<Contribution> contributions) {
		super();
		this.contributions = contributions;
	}
}
