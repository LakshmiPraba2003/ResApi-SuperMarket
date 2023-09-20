package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Repository.CustomerRepo;

@Service
public class CustomerSer {
	@Autowired
    CustomerRepo rep;
    public Customer saveDetails(Customer cus) {
 	   return rep.save(cus);
    }
    public List<Customer> getDetails(){
 	   return rep.findAll();
    }
    public Customer updateDetails(Customer cus) {
 	   return rep.saveAndFlush(cus);
    }
    public void deleteDetails(int id) {
 	   System.out.print("Id is deleted");
 	   rep.deleteById(id);
    }
    public Optional<Customer> getbyid(int id) {
		return rep.findById(id);
	}
//    public Optional<Customer> updateUserById(int id){
// 	   Optional<Customer> hp=rep.findById(id);
// 	   if(hp.isPresent()) {
// 		   return hp;
// 	   }
// 	   return null;
//    }
//    public String updateinfobyid(int id) {
//		rep.saveAndFlush(s);
//		if(rep.existsById(id)) {
//			return "Updated";
//		}
//		else {
//			return "Enter valid id";
//		}
//	}
    public List<Customer> sortbyAsc(String s){
 	   return rep.findAll(Sort.by(Sort.Direction.ASC,s));
    }
    public List<Customer> pagination(int pn,int ps){
 	   Page<Customer> cont=rep.findAll(PageRequest.of(pn, ps));
 	   return cont.getContent();
    }
    public List<Customer> getbypagesort(int pagno,int pagsize,String s){
		 Page<Customer> c=rep.findAll(PageRequest.of(pagno,pagsize,Sort.by(Sort.Direction.ASC, s)));
		 return c.getContent();
	}
    public List<Customer> getAllRows()
    {
    	return rep.getAllRows();
    }
}
