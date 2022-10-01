package com.masai.bean;

public class CriminalDTO {
	
	String criminal;
	int age;
	String identity;
	String address ; 
	String Station;
	public CriminalDTO() {
		// TODO Auto-generated constructor stub
	}
	public CriminalDTO(String criminal, int age, String identity, String address, String station) {
		super();
		this.criminal = criminal;
		this.age = age;
		this.identity = identity;
		this.address = address;
		Station = station;
	}
	public String getCriminal() {
		return criminal;
	}
	public void setCriminal(String criminal) {
		this.criminal = criminal;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStation() {
		return Station;
	}
	public void setStation(String station) {
		Station = station;
	}
	@Override
	public String toString() {
		return "CriminalDTO [criminal=" + criminal + ", age=" + age + ", identity=" + identity + ", address=" + address
				+ ", Station=" + Station + "]";
	}
	
}
