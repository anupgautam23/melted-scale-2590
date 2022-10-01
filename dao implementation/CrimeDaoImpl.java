package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Utility.DBUtil;
import com.masai.bean.CrimeByStationDTO;
import com.masai.bean.Crime_record;
import com.masai.bean.CriminalDTO;
import com.masai.bean.Pstation;
import com.masai.exceptions.CrimesNotFoundException;
import com.masai.exceptions.CriminalNotFoundException;

public class CrimeDaoImpl implements CrimeDao{

	@Override
	public Pstation loginPoliceStation(String username, String password) throws CriminalNotFoundException {
		Pstation station  =  null;
		
		
				try(Connection conn = DBUtil.provideConnection()) {
					
					PreparedStatement ps = conn.prepareStatement("select * from policestation where pemail=? and "
							+ "password = ?");
					ps.setString(1, username);
					ps.setString(2, password);
					
				    ResultSet rs = 	ps.executeQuery();
				    
				    if(rs.next()) {
				    	
				    	int code = rs.getInt("p_code");
				    	String email =  rs.getString("pemail");
				    	String ppassword =  rs.getString("password");
				    	String pstation =  rs.getString("pstation");
				    	String address =  rs.getString("paddress");
				    	
				    	station = new Pstation(code, email, ppassword, pstation, address);
				    	
				    	
				    }else {
				    	 throw new CriminalNotFoundException("please Enter the correct Username or Password");
				    }
				} catch (SQLException e) {
				  throw new CriminalNotFoundException(e.getMessage());
				}
		
		return station;
	}

	
	@Override
	public int numberOfSolvedUnsolvedCase(int status) throws CrimesNotFoundException {
		int num =  0 ;
		if(status==4) {

			try(Connection conn = DBUtil.provideConnection()) {
				
				PreparedStatement ps = conn.prepareStatement("select  count(status) from crime_record where status = \"solved\""); 
			   ResultSet rs =  ps.executeQuery();
			   boolean flag =true;
			   while(rs.next()) {
				   flag =false ;
				   num=rs.getInt("count(status)");
			   }
			if(flag) throw new CrimesNotFoundException("No any solved cases");
			
			} catch (SQLException e) {
			 throw new CrimesNotFoundException(e.getMessage());
			}
		}else if(status==5) {
			try(Connection conn = DBUtil.provideConnection()) {
				
				PreparedStatement ps = conn.prepareStatement("select  count(status) from crime_record where status = \"not solved\""); 
			   ResultSet rs =  ps.executeQuery();
			   boolean flag =true;
			   while(rs.next()) {
				   System.out.println("insdie");
				   num=rs.getInt("count(status)");
			   }
			   if(flag) throw new CrimesNotFoundException("No any active cases");
			
			} catch (SQLException e) {
			 throw new CrimesNotFoundException(e.getMessage());
			}
			
		}
		
		
		
		return num;
	}

	@Override
	public int NumberOfcrime() throws CrimesNotFoundException {
		int number = 0 ;
		

		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(" select  count(status) from crime_record where crime_date >'2022-09-01'"); 
		   ResultSet rs =  ps.executeQuery();
		   
		   while(rs.next()) {
			   number=rs.getInt("count(status)");
		   }
		
		
		} catch (SQLException e) {
		 throw new CrimesNotFoundException(e.getMessage());
		}
		
		
		return number;
	}


	@Override
	public List<CrimeByStationDTO> getCrimeByStation(int stationCode) throws CrimesNotFoundException {
		List<CrimeByStationDTO> crimes = new ArrayList<>();
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select c.crname,t.c_type ,cr.crime_date,cr.victims,cr.detail,cr.suspect,"
					+ "cr.area,p.pstation,cr.status from crime_record cr INNER JOIN criminal_record "
					+ "c INNER JOIN type_criminal_record tcr INNER JOIN policestation p INNER JOIN "
					+ "crime_type t ON cr.crime_id = tcr.crimeid and c.criminal_id = tcr.criminalid "
					+ "and c.pid = p.p_code and \r\n"
					+ "t.crimeid = tcr.typeid and  p_code=?"); 
		ps.setInt(1, stationCode);
		ResultSet rs=ps.executeQuery();
		boolean flag = true;
		while(rs.next()) {
			flag=false;
			
			String criminal = rs.getString("crname");
			String crime_type = rs.getString("c_type");
			String date = rs.getString("crime_date");
			String victims = rs.getString("victims");
			String detail = rs.getString("suspect");
			String area = rs.getString("area");
			String station = rs.getString("pstation");
			String status = rs.getString("status");
			
			CrimeByStationDTO cr = new CrimeByStationDTO(criminal, crime_type, date, victims, detail, detail, area, station, status);
			crimes.add(cr);
		}
		
		if(flag) {
			throw new CrimesNotFoundException("No crime record found");
		}
			
		} catch (SQLException e) {
		 throw new CrimesNotFoundException(e.getMessage());
		}
		
		
		return crimes;
	}


	@Override
	public List<CriminalDTO> getCriminalByStation(int stationcode) throws CriminalNotFoundException {
		List<CriminalDTO> criminals = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
		PreparedStatement ps = conn.prepareStatement("select c.crname,c.age,c.identifying_mark,c.address,p.pstation "
				+ "from criminal_record c INNER JOIN policestation  p ON c.pid = p.p_code and p.p_code = ?"); 
		ps.setInt(1, stationcode);
		ResultSet rs=ps.executeQuery();
		boolean flag = true;
		while(rs.next()) {
			flag=false;
			
			String criminal = rs.getString("crname");
			int age = rs.getInt("age");
			String idmark = rs.getString("identifying_mark");
			String add = rs.getString("address");
			String station = rs.getString("pstation");
			
			CriminalDTO criminalDTO = new CriminalDTO(criminal, age, idmark, add, station);
			criminals.add(criminalDTO);
			
		}
		
		if(flag) {
			throw new CriminalNotFoundException("No criminal record found");
		}
			
		} catch (SQLException e) {
		 throw new CriminalNotFoundException(e.getMessage());
		}
		
		
		
		return criminals;
	}


	@Override
	public List<Crime_record> getAllcrimeRecord() throws CrimesNotFoundException {
		List<Crime_record> crimes = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from crime_record"); 
		
		ResultSet rs=ps.executeQuery();
		boolean flag = true;
		while(rs.next()) {
			flag=false;
			int id = rs.getInt("crime_id");
			String date = rs.getString("crime_date");
			String victim = rs.getString("victims");
			String det = rs.getString("detail");
			String susp = rs.getString("suspect");
			String area = rs.getString("area");
			String st = rs.getString("status");
			
			Crime_record cr = new Crime_record(id, date, victim, det, susp, susp, area, st);
			crimes.add(cr);
		}
		
		if(flag) {
			throw new CrimesNotFoundException("No crime record found");
		}
			
		} catch (SQLException e) {
		 throw new CrimesNotFoundException(e.getMessage());
		}
		
		return crimes;
	}


	@Override
	public String changeCaseStatus(int id) throws CrimesNotFoundException {
		String message = "";
		

		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update crime_record set status = 'solved' where crime_id = ?"); 
			ps.setInt(1, id);
			int x =	ps.executeUpdate();
			
			if(x>0) message= "Status Updated Successfully....";
			else  throw new CrimesNotFoundException("status Not Updated");
			
		} catch (SQLException e) {
			throw new CrimesNotFoundException(e.getMessage());
		}
		
		
		
		return message;
	}

}
