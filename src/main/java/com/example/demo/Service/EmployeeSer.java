package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepo;


@Service
public class EmployeeSer {
	@Autowired
    EmployeeRepo rep;
    public Employee saveDetails(Employee cus) {
 	   return rep.save(cus);
    }
    public List<Employee> getDetails(){
 	   return rep.findAll();
    }
    public Employee updateDetails(Employee cus) {
 	   return rep.saveAndFlush(cus);
    }
    public void deleteDetails(int id) {
 	   System.out.print("Id is deleted");
 	   rep.deleteById(id);
    }
    public Optional<Employee> getbyid(int id) {
		return rep.findById(id);
	}
    public String updateinfobyid(int id,Employee s) {
		rep.saveAndFlush(s);
		if(rep.existsById(id)) {
			return "Updated";
		}
		else {
			return "Enter valid id";
		}
	}
}
