package com.masai.bean;

public class Crime_record {
	
	int id ; 
	String date;
	String victims;
	String  detail;
	String suspect;
	String criminal;
	String area;
	String statu;
	
	public Crime_record() {
		// TODO Auto-generated constructor stub
	}

	public Crime_record(int id, String date, String victims, String detail, String suspect, String criminal,
			String area, String statu) {
		super();
		this.id = id;
		this.date = date;
		this.victims = victims;
		this.detail = detail;
		this.suspect = suspect;
		this.criminal = criminal;
		this.area = area;
		this.statu = statu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getCriminal() {
		return criminal;
	}

	public void setCriminal(String criminal) {
		this.criminal = criminal;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

	@Override
	public String toString() {
		return "Crime_record [id=" + id + ", date=" + date + ", victims=" + victims + ", detail=" + detail
				+ ", suspect=" + suspect + ", criminal=" + criminal + ", area=" + area + ", statu=" + statu + "]";
	}
	
	

}
