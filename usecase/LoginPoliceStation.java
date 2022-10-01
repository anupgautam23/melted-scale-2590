package com.masai.usecase;

import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import com.masai.Dao.CrimeDao;
import com.masai.Dao.CrimeDaoImpl;
import com.masai.bean.CrimeByStationDTO;
import com.masai.bean.Crime_record;
import com.masai.bean.CriminalDTO;
import com.masai.bean.Pstation;
import com.masai.exceptions.CrimesNotFoundException;
import com.masai.exceptions.CriminalNotFoundException;
import com.mysql.cj.protocol.x.ContinuousOutputStream;

public class LoginPoliceStation {

	public static void main(String[] args) throws CrimesNotFoundException  {
		
		int cout = 0 ; 
		while(cout<3) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter username");
		String username =  scanner.next();
		System.out.println("Enter Password");
		String password =  scanner.next();
		
		CrimeDao dao = new CrimeDaoImpl();
		Pstation pstation;
		try {
			pstation = dao.loginPoliceStation(username, password);
			System.out.println("Welcome to "+pstation.getStation()+" police station");
			System.out.println();
			
			
			int count =1 ;
			String Q ="Y";
			while(count<8 && Q.equals("Y")) {
				System.out.println();
				System.out.println("What Do You Want To Search\n");
				System.out.println("1. Get All Crime Record \n"
						+ "2. Get Crime Record by Police station \n"
						+ "3. Get Criminals by Police station \n"
						+ "4. Get Number of Solved Cases \n"
						+ "5. Get Number of active cases \n"
						+ "6. Get Number of crime case in current month \n"
						+ "7. Want to update status as solved ?"
						+ "8. Exit");
				
				
				System.out.println("Enter input here...");
				int select = scanner.nextInt();
				
				if(select==1) {
					CrimeDao dao2 = new CrimeDaoImpl();
					
					List<Crime_record> crimes;
					try {
						crimes = dao2.getAllcrimeRecord();
						System.out.println(" All crime list are:-");
						System.out.println();
						crimes.forEach(c->{
							
							System.out.println("crime date "+c.getDate());
							System.out.println("victims:-"+c.getVictims());
							System.out.println("crime detail:-"+c.getDetail());
							System.out.println("-----------------------------");
							
						});
					} catch (CrimesNotFoundException e) {
						System.out.println(e.getMessage());
					}
					
					
				}else if(select==2) {
					CrimeDao dao2 = new CrimeDaoImpl();
					System.out.println("Type 101 for bhopal station");
					System.out.println("Type 102 for kali chouki station");
					System.out.println("Type 103 for chouragarh station");
					System.out.println();
					int y = scanner.nextInt();
					List<CrimeByStationDTO> crime = dao2.getCrimeByStation(y);
					crime.forEach(c->{
						System.out.println(" All crime list are:-");
						System.out.println("criminal name:-"+c.getCriminalName());
						System.out.println("crime date is:-"+c.getCrimedate());
						System.out.println("victims:-"+c.getVictims());
						System.out.println("crime type:-"+c.getCrimetype());
						System.out.println("details:-"+c.getDetail());
						System.out.println("belongs to:-"+c.getStation());
						System.out.println("status is:-"+c.getStatus());
					});
				}else if(select==3) {
					
					CrimeDao dao2 = new CrimeDaoImpl();
					System.out.println("Type 101 for bhopal station");
					System.out.println("Type 102 for kali chouki station");
					System.out.println("Type 103 for chouragarh station");
					System.out.println();
					int y = scanner.nextInt();
					List<CriminalDTO> crime = dao2.getCriminalByStation(y);
					System.out.println(" All crime list are:-");
					crime.forEach(c->{
						
						System.out.println("criminal name:-"+c.getCriminal());
						System.out.println("criminal age is:-"+c.getAge());
						System.out.println("identifying marks:-"+c.getIdentity());
						System.out.println("police station:-"+c.getStation());
						
					});
				}else if(select==4) {
					CrimeDao dao2 = new CrimeDaoImpl();
					try {
						int x = dao2.numberOfSolvedUnsolvedCase(select);
						System.out.println("The number of solved cases are:- "+x);
					} catch (CrimesNotFoundException e) {
						System.out.println(e.getMessage());
					}
				}else if(select==5) {

					CrimeDao dao2 = new CrimeDaoImpl();
					try {
						int x = dao2.numberOfSolvedUnsolvedCase(select);
						System.out.println("The number of active cases are:- "+x);
					} catch (CrimesNotFoundException e) {
						System.out.println(e.getMessage());
					}
				}else if(select==6) {
					CrimeDao dao3 = new CrimeDaoImpl();
					try {
						int x= dao3.NumberOfcrime();
						System.out.println("Number of crimes in current month is "+x);
					} catch (CrimesNotFoundException e) {						
						System.out.println(e.getMessage());
					}
				}else if(select==7) {
					CrimeDao dao3 = new CrimeDaoImpl();
					System.out.println("Enter Crime ID");
					int id=scanner.nextInt();
					String message=	dao3.changeCaseStatus(id);
					System.out.println(message);
				}else if(select==8) {
					count =  8  ; 
					
				}
				
				count++;
				cout=4;
				System.out.println("Want  to search again ... ???\n Please Type Y/N ");
				Q =scanner.next();
			}
			
			System.out.println("Thank You !!");
			
			
			
			
			
			
		} catch (CriminalNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		cout++;
		}
		
	}

}
