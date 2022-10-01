package com.masai.bean;

public class Criminal {
	
	int criminalId ;
	String crname;
	int age;
	String address ; 
	String identifyingmark;
	String  arrestrea ; 
	int SttaionId; 
	public Criminal() {
		// TODO Auto-generated constructor stub
	}
	public Criminal(int criminalId, String crname, int age, String address, String identifyingmark, String arrestrea,
			int sttaionId) {
		super();
		this.criminalId = criminalId;
		this.crname = crname;
		this.age = age;
		this.address = address;
		this.identifyingmark = identifyingmark;
		this.arrestrea = arrestrea;
		SttaionId = sttaionId;
	}
	public int getCriminalId() {
		return criminalId;
	}
	public void setCriminalId(int criminalId) {
		this.criminalId = criminalId;
	}
	public String getCrname() {
		return crname;
	}
	public void setCrname(String crname) {
		this.crname = crname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdentifyingmark() {
		return identifyingmark;
	}
	public void setIdentifyingmark(String identifyingmark) {
		this.identifyingmark = identifyingmark;
	}
	public String getArrestrea() {
		return arrestrea;
	}
	public void setArrestrea(String arrestrea) {
		this.arrestrea = arrestrea;
	}
	public int getSttaionId() {
		return SttaionId;
	}
	public void setSttaionId(int sttaionId) {
		SttaionId = sttaionId;
	}
	@Override
	public String toString() {
		return "Criminal [criminalId=" + criminalId + ", crname=" + crname + ", age=" + age + ", address=" + address
				+ ", identifyingmark=" + identifyingmark + ", arrestrea=" + arrestrea + ", SttaionId=" + SttaionId
				+ "]";
	}
	
	

}
