package com.ssafy.corona.model.dto;

public class Region {

	private String rcode;
	private String rname;
	
	public Region() {
		// TODO Auto-generated constructor stub
	}
	public Region(String rcode, String rname) {
		super();
		this.rcode = rcode;
		this.rname = rname;
	}
	
	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	@Override
	public String toString() {
		return "Region [rcode=" + rcode + ", rname=" + rname + "]";
	}
	
	
}
