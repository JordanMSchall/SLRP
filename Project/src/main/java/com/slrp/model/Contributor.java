package com.slrp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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

	@OneToOne(cascade = CascadeType.ALL)
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Contribution> getContributions() {
		return contributions;
	}

	public Contributor(Person person) {
		super();
		this.person = person;
	}

	public List<Contribution> getContribution() {
		return contributions;
	}

	public void setContributions(List<Contribution> contributions) {
		this.contributions = contributions;
	}

	public void makeContribution() {

	}

	public Contributor(List<Contribution> contributions) {
		super();
		this.contributions = contributions;
	}

}
