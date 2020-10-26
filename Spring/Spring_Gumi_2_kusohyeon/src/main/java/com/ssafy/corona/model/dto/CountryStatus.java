package com.ssafy.corona.model.dto;

public class CountryStatus {
	private String ccode;
	private String cname;
	private int patient;
	private String rcode;
	
	public CountryStatus() {
		// TODO Auto-generated constructor stub
	}

	public CountryStatus(String ccode, String cname, int patient, String rcode) {
		super();
		this.ccode = ccode;
		this.cname = cname;
		this.patient = patient;
		this.rcode = rcode;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getPatient() {
		return patient;
	}

	public void setPatient(int patient) {
		this.patient = patient;
	}

	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	@Override
	public String toString() {
		return "CountryStatus [ccode=" + ccode + ", cname=" + cname + ", patient=" + patient + ", rcode=" + rcode + "]";
	}
	
}
