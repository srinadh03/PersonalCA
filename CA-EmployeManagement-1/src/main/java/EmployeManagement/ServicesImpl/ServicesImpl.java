package EmployeManagement.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import EmployeManagement.Entity.Employe;
import EmployeManagement.ExceptionsHandling.EmployeException;
import EmployeManagement.Repository.EmployeRepository;
import EmployeManagement.Servicess.EmployeServices;
@Service
public class ServicesImpl implements EmployeServices{
	
	@Autowired
	EmployeRepository employeRepository;
	
	
	
	public String saveEmploye(Employe employe) {
		
		String message="";
		boolean b=false;
		List<Employe> employes=(List<Employe>) employeRepository.findAll();
		try {
			for(Employe e:employes) {
				if(employe.getId()==e.getId()) {
					
					throw new EmployeException("601","Employe already exists in the database","/employeManagement/addEmploye");
				}
				else {
					b=true;
				}
			}
			
				if(b) {
					employeRepository.save(employe);
					message="Employe Deatils saved Successfully";
				}
			
		}
		catch(Exception e) {
			message=e.toString();			
		}
		return message;
		}
	
	
	
	
	public List<Employe> SalbyDesc(){
		
		return employeRepository.findAll(Sort.by("Salary").descending().and(Sort.by("Name").ascending()));
	}
	
	
	
	
	public ResponseEntity<Employe> updatebysal( int id,double salary) {
		Optional<Employe> Existemp=employeRepository.findById(id);
		
			if(Existemp.isPresent()) {
				Employe emp=Existemp.get();
				emp.setSalary(salary);
				return new ResponseEntity<>(employeRepository.save(emp),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}
	
	
	public List<Employe> getAllEmployes() {
		return employeRepository.findAll();	
		}
	
	
	
	public String Delbyid(int id) {
		 employeRepository.deleteById(id);
		 return "Deleted Sucessfully";
	}
	
	

	public List<Employe> Findbysal(double Salary) {
		return employeRepository.findBySalary(Salary);
	}


	public String deleteall() {
		employeRepository.deleteAll();
		return "Delete Sucessfully";
		
	}

	
	
	
		
	
}


