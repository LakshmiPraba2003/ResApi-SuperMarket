package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = (GenerationType.IDENTITY))
	public int custId;
      public String custName;
      public String custMobile;
      public String custAddr;
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	public String getCustAddr() {
		return custAddr;
	}
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	public Customer(String custName, String custMobile, String custAddr) {
		super();
		this.custName = custName;
		this.custMobile = custMobile;
		this.custAddr = custAddr;
	}
      
}
