package com.jumia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;



@Entity
@Table(name = "customer")

public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String name;
	private String phone;

	@Transient
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String validation;

	@Transient
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String countryCode;

	public Customer() {
		super();
	}

	public Customer(String id, String name, String phone, String validation, String countryCode) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.validation = validation;
		this.countryCode = countryCode;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
