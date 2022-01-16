package EmployeManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import EmployeManagement.Entity.Employe;

public interface EmployeRepository extends JpaRepository<Employe,Integer>{
	
	
	List<Employe> findBySalary(double salary);

}
