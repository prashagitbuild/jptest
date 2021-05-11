package com.jptest.epc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Signals") 
public class Signals {
	
	private long id;
	private String name;
	private String noOfPeopleAllowed;
	private String watingPeriodInSec;
	private String noOfPedestrianWaitingToCross;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "signal_name", nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "no_of_people_allowed", nullable = false)
	public String getNoOfPeopleAllowed() {
		return noOfPeopleAllowed;
	}
	
	public void setNoOfPeopleAllowed(String noOfPeopleAllowed) {
		this.noOfPeopleAllowed = noOfPeopleAllowed;
	}
	
	@Column(name = "waiting_period_in_sec", nullable = false)
	public String getWatingPeriodInSec() {
		return watingPeriodInSec;
	}
	
	public void setWatingPeriodInSec(String watingPeriodInSec) {
		this.watingPeriodInSec = watingPeriodInSec;
	}

	@Column(name = "no_of_ped_waiting_to_cross")
	public String getNoOfPedestrianWaitingToCross() {
		return noOfPedestrianWaitingToCross;
	}

	public void setNoOfPedestrianWaitingToCross(String noOfPedestrianWaitingToCross) {
		this.noOfPedestrianWaitingToCross = noOfPedestrianWaitingToCross;
	}
}
