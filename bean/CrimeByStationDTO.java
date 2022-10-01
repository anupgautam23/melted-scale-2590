package com.masai.bean;

public class CrimeByStationDTO {
	
	String criminalName;
	String crimetype;
	String crimedate;
	String victims;
	String detail;
	String suspect;
	String area;
	String station;	
	String status;
	
	
	public CrimeByStationDTO() {
		// TODO Auto-generated constructor stub
	}


	public String getCriminalName() {
		return criminalName;
	}


	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	}


	public String getCrimetype() {
		return crimetype;
	}


	public void setCrimetype(String crimetype) {
		this.crimetype = crimetype;
	}


	public String getCrimedate() {
		return crimedate;
	}


	public void setCrimedate(String crimedate) {
		this.crimedate = crimedate;
	}


	public String getVictims() {
		return victims;
	}


	public void setVictims(String victims) {
		this.victims = victims;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public String getSuspect() {
		return suspect;
	}


	public void setSuspect(String suspect) {
		this.suspect = suspect;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getStation() {
		return station;
	}


	public void setStation(String station) {
		this.station = station;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public CrimeByStationDTO(String criminalName, String crimetype, String crimedate, String victims, String detail,
			String suspect, String area, String station, String status) {
		super();
		this.criminalName = criminalName;
		this.crimetype = crimetype;
		this.crimedate = crimedate;
		this.victims = victims;
		this.detail = detail;
		this.suspect = suspect;
		this.area = area;
		this.station = station;
		this.status = status;
	}


	@Override
	public String toString() {
		return "CrimeByStationDTO [criminalName=" + criminalName + ", crimetype=" + crimetype + ", crimedate="
				+ crimedate + ", victims=" + victims + ", detail=" + detail + ", suspect=" + suspect + ", area=" + area
				+ ", station=" + station + ", status=" + status + "]";
	}

	
}
