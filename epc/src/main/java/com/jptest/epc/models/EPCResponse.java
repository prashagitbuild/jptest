package com.jptest.epc.models;

import org.springframework.stereotype.Component;

@Component  
public class EPCResponse {
	//private Integer iterationId;
	private String timeRequire;
	private Integer noOfPedAllowedToPass;
	
	public String getTimeRequire() {
		return timeRequire;
	}
	
	public void setTimeRequire(String timeRequire) {
		this.timeRequire = timeRequire;
	}
	
	public Integer getNoOfPedAllowedToPass() {
		return noOfPedAllowedToPass;
	}
	
	public void setNoOfPedAllowedToPass(Integer noOfPedAllowedToPass) {
		this.noOfPedAllowedToPass = noOfPedAllowedToPass;
	}

}
