package com.example.Bond.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bondd {
	
	@Id
	String name;
	String car;
	int bondNo;
	
	String username;
	int password;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public Bondd(String name, String car, int bondNo, String username, int password) {
		super();
		this.name = name;
		this.car = car;
		this.bondNo = bondNo;
		this.username = username;
		this.password = password;
	}
	public Bondd(String name, String car, int bondNo) {
		super();
		this.name = name;
		this.car = car;
		this.bondNo = bondNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public int getBondNo() {
		return bondNo;
	}
	public void setBondNo(int bondNo) {
		this.bondNo = bondNo;
	}
	
	

}
