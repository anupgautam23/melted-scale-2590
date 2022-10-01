package com.masai.bean;

public class crimeByCriminalNameDTO {

		String crinimal;
		String crimedate;
		String victims;
		String detail;
		String suspect;
		String area;
		String pstation;
		String status;
		
		public crimeByCriminalNameDTO() {
			// TODO Auto-generated constructor stub
		}

		public crimeByCriminalNameDTO(String crinimal, String crimedate, String victims, String detail, String suspect,
				String area, String pstation, String status) {
			super();
			this.crinimal = crinimal;
			this.crimedate = crimedate;
			this.victims = victims;
			this.detail = detail;
			this.suspect = suspect;
			this.area = area;
			this.pstation = pstation;
			this.status = status;
		}

		public String getCrinimal() {
			return crinimal;
		}

		public void setCrinimal(String crinimal) {
			this.crinimal = crinimal;
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

		public String getPstation() {
			return pstation;
		}

		public void setPstation(String pstation) {
			this.pstation = pstation;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "crimeByCriminalNameDTO [crinimal=" + crinimal + ", crimedate=" + crimedate + ", victims=" + victims
					+ ", detail=" + detail + ", suspect=" + suspect + ", area=" + area + ", pstation=" + pstation
					+ ", status=" + status + "]";
		}
		
		
}
