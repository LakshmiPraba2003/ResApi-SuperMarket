package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Login;
import com.example.demo.Service.LoginService;
@RestController
@CrossOrigin("*")
public class LoginCon {
	@Autowired
	LoginService cs;
	@PostMapping("addlogin")
	public Login adddetails(@RequestBody Login d) {
		return cs.add(d);
	}
	@GetMapping("displogin")
	public List<Login> show(Login d) {
		return cs.showdetails(d);
	}
	@GetMapping("getlogin/{emailid}/{password}")
	public boolean login(@PathVariable String emailid,@PathVariable String password){
		return cs.getsignups(emailid, password);	
	}
	@DeleteMapping("dellogin/{email}")
	public int dellogin(@PathVariable String email) {
	  return cs.dellogin(email);
		//return "Deleted";
	}
}
