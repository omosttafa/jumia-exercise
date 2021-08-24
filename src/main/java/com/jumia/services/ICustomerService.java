package com.jumia.services;

import java.util.List;

import com.jumia.entities.Customer;

public interface ICustomerService {

	public Iterable<Customer> getAllCustomers();
	List<Customer> getCustomersFromCountry(String country);
	
	
//	
}
