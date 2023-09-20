package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = (GenerationType.IDENTITY))
 public int empId;
 public String empFname;
 public String empLname;
 public String empMobile;
 public String empAddr;
public Employee(int empId, String empFname, String empLname, String empMobile, String empAddr) {
	super();
	this.empId = empId;
	this.empFname = empFname;
	this.empLname = empLname;
	this.empMobile = empMobile;
	this.empAddr = empAddr;
}
public Employee() {
	super();
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpFname() {
	return empFname;
}
public void setEmpFname(String empFname) {
	this.empFname = empFname;
}
public String getEmpLname() {
	return empLname;
}
public void setEmpLname(String empLname) {
	this.empLname = empLname;
}
public String getEmpMobile() {
	return empMobile;
}
public void setEmpMobile(String empMobile) {
	this.empMobile = empMobile;
}
public String getEmpAddr() {
	return empAddr;
}
public void setEmpAddr(String empAddr) {
	this.empAddr = empAddr;
}
 
}
