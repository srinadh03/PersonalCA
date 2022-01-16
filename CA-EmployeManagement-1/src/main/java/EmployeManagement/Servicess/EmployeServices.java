package EmployeManagement.Servicess;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import EmployeManagement.Entity.Employe;

@Service
public interface EmployeServices {
	
	String saveEmploye(Employe employe);
	
	List<Employe> SalbyDesc();
	
	ResponseEntity<Employe> updatebysal( int id,double salary);
	
	List<Employe> getAllEmployes();
	
	String Delbyid(int id);
	
	List<Employe> Findbysal(double Salary);
	
	String deleteall();
	
	
	
}
