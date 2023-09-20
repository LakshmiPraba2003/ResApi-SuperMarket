package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Login;
import com.example.demo.Repository.LoginRepo;

@Service
public class LoginService {
	@Autowired
	LoginRepo re;
	public Login add(Login d) {
		return re.save(d);
	}
	public List<Login> showdetails(Login d){
		return re.findAll();
	}
	public boolean getsignups(String email,String pass){
		return re.existsByName(email,pass);
	}
	public int dellogin(String email) {
		return re.deletelogin(email);
	}
}
