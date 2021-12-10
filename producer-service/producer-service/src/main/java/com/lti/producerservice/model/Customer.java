package com.lti.producerservice.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String address;
	private String typeOfAccount;
	private Integer port;

	public Customer() {
		super();
	}

	public Customer(Integer id, String name, String address, String typeOfAccount) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.typeOfAccount = typeOfAccount;
	}
	

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTypeOfAccount() {
		return typeOfAccount;
	}

	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", typeOfAccount=" + typeOfAccount
				+ ", port=" + port + "]";
	}

	

		
	
}
