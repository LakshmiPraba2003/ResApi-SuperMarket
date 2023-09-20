package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Signup;
import com.example.demo.Repository.SignupRepo;

@Service
public class SignupService {
	@Autowired 
	SignupRepo sr;
	public Signup add(Signup d) {
		return sr.save(d);
	}
	public List<Signup> showdetails(Signup d){
		return sr.findAll();
	}
	public boolean getsignup(String email,String pass){
		return sr.existsByName(email,pass);
	}
}
