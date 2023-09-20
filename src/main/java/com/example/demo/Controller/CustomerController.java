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

import com.example.demo.Model.Customer;
import com.example.demo.Service.CustomerSer;

@RestController
@CrossOrigin("*")
public class CustomerController {
	@Autowired
    CustomerSer s;
    @PostMapping("/save")
    public Customer savecontrol(@RequestBody Customer cus) {
    	return s.saveDetails(cus);
    }
    @GetMapping("/getmap")
    public List<Customer> getcontrol(){
    	return s.getDetails();
    }
    @GetMapping("getbyid/{id}")
	public java.util.Optional<Customer> getbyid(@PathVariable int id) {
		return s.getbyid(id);
	}
    @PutMapping("/update")
    public Customer updatecontrol(@RequestBody Customer cus) {
    	return s.updateDetails(cus);
    }
    @DeleteMapping("/deleteby/{id}")
    public String removeid(@PathVariable ("id") int id) {
    	s.deleteDetails(id);
    	return "Batch Id"+id+" is deleted";
    }
    //update
    @PutMapping("updateCustbyid/{id}")
    public String updatebyid(@RequestBody Customer aa, @PathVariable int id) {
		java.util.Optional<Customer> temp = s.getbyid(id);
		if(temp.isPresent()) {
			s.updateDetails(aa);
			return "Object updated successfully!";
		}
		return "Enter a valid id!";
	}

    //sort
    @GetMapping("/sortbyAsc/{name}")
    public List<Customer> sortasc(@PathVariable String name){
    	return s.sortbyAsc(name);
    }
    //pagination
    @GetMapping("/pagin/{pn}/{ps}")
    public List<Customer> paginex(@PathVariable("pn") int pn,@PathVariable("ps") int size){
    	return s.pagination(pn,size);
    }
    //page sort
    @GetMapping("showbuspage/{pageno}/{pagesize}/{name}")
	public List<Customer> getpagesort(@PathVariable int pageno,@PathVariable int pagesize,@PathVariable String name){
		return s.getbypagesort(pageno, pagesize, name);
	}
    //getQuery
    @GetMapping("/getAllrows")
    public List<Customer> getAllRows()
    {
    	return s.getAllRows();
    }
}
