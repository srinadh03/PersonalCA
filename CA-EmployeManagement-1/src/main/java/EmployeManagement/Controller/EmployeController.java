package EmployeManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import EmployeManagement.Entity.Employe;
import EmployeManagement.Servicess.EmployeServices;

@RestController
public class EmployeController {
	
	@Autowired
	EmployeServices services;
	
	
	@PostMapping("/employeManagement/addEmploye")
	public String addEmploye(@RequestBody Employe employe) {
		return services.saveEmploye(employe);
		
	}
	
	@GetMapping("/employeManagement/salbyDescNamesAsc")
	public List<Employe> SalByDescNamesAsc(){
		return services.SalbyDesc();
	}
	
	
	@GetMapping("/employeManagement/updatesalary/{id}/{salary}")
	public ResponseEntity<Employe> updatesalbyid(@PathVariable int id,@PathVariable double salary){
		return services.updatebysal(id, salary);
	}
	
	@GetMapping("/employeManagement/allEmployes")
	public List<Employe> GetAllEmployes(){
		return services.getAllEmployes();
	}
	
	
	@DeleteMapping("/employeManagement/delete/{id}")
	public String DeleteEmploye(@PathVariable int id) {
		return services.Delbyid(id);
	}
	@GetMapping("/employeManagement/bysal/{Salary}")
	public List<Employe> bysal(@PathVariable double Salary)
	{
		return services.Findbysal(Salary);
	}
	
	@DeleteMapping("/employeManagement/deleteAll")
	public String deleteAll() {
		services.deleteall();
		return "All Employees Deleted Successfully";
	}
	

}
