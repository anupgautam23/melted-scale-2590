package com.masai.bean;

public class Pstation {
	
	int pcode;
	String Email;
	String password;
	String station;
	String address ;
	
	public Pstation() {
		// TODO Auto-generated constructor stub
	}

	public Pstation(int pcode, String email, String password, String station, String address) {
		super();
		this.pcode = pcode;
		Email = email;
		this.password = password;
		this.station = station;
		this.address = address;
	}

	public int getPcode() {
		return pcode;
	}

	public void setPcode(int pcode) {
		this.pcode = pcode;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Pstation [pcode=" + pcode + ", Email=" + Email + ", password=" + password + ", station=" + station
				+ ", address=" + address + "]";
	}
	
	
}
