package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Employee;
import com.example.demo.Service.EmployeeSer;


@RestController
@CrossOrigin("*")
public class EmployeeController {
	@Autowired
    EmployeeSer s;
    @PostMapping("/saveEmp")
    public Employee savecontrol(@RequestBody Employee emp) {
    	return s.saveDetails(emp);
    }
    @GetMapping("/getmapEmp")
    public List<Employee> getcontrol(){
    	return s.getDetails();
    }
    @GetMapping("getEmpbyid/{id}")
	public java.util.Optional<Employee> getbyid(@PathVariable int id) {
		return s.getbyid(id);
	}
    @PutMapping("/updateEmp")
    public Employee updatecontrol(@RequestBody Employee cus) {
    	return s.updateDetails(cus);
    }
    @DeleteMapping("/deleteEmpby/{id}")
    public String removeid(@PathVariable ("id") int id) {
    	s.deleteDetails(id);
    	return "Batch Id"+id+" is deleted";
    }
    @PutMapping("updatebusbyid/{id}")
	public String modifybyid(@PathVariable int id,@RequestBody Employee emp) {
		return s.updateinfobyid(id, emp);
	}
    //update
    @PutMapping("updateEmpbyid/{id}")
    public String updatebyid(@RequestBody Employee aa, @PathVariable int id) {
		java.util.Optional<Employee> temp = s.getbyid(id);
		if(temp.isPresent()) {
			s.updateDetails(aa);
			return "Object updated successfully!";
		}
		return "Enter a valid id!";
	}
}
