package com.slrp.api.model;

public class Schall {
	
	private final long id;
	
	private String adjective;
	
	private String verb;

	public String getVerb() {
		return verb;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}

	public String getAdjective() {
		return adjective;
	}

	public void setAdjective(String adjective) {
		this.adjective = adjective;
	}

	public long getId() {
		return id;
	}

	public Schall(long id, String adjective, String verb) {
		super();
		this.id = id;
		this.adjective = adjective;
		this.verb = verb;
	}
	


}
