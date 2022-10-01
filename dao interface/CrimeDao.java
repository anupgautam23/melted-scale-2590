package com.masai.Dao;

import java.util.List;

import com.masai.bean.CrimeByStationDTO;
import com.masai.bean.Crime_record;
import com.masai.bean.CriminalDTO;
import com.masai.bean.Pstation;
import com.masai.exceptions.CrimesNotFoundException;
import com.masai.exceptions.CriminalNotFoundException;

public interface CrimeDao {
	
	public Pstation loginPoliceStation(String username, String password) throws CriminalNotFoundException;
	public List<CrimeByStationDTO> getCrimeByStation(int stationCode) throws CrimesNotFoundException;
	public List<CriminalDTO> getCriminalByStation(int stationcode) throws CriminalNotFoundException;
	public List<Crime_record> getAllcrimeRecord() throws CrimesNotFoundException;
	public int numberOfSolvedUnsolvedCase(int status) throws CrimesNotFoundException;
	public int NumberOfcrime() throws CrimesNotFoundException;
	public String changeCaseStatus(int id) throws CrimesNotFoundException;
}
