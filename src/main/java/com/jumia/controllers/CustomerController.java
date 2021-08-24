package com.jumia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.jumia.entities.Customer;
import com.jumia.services.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping("/customers")
	public Iterable<Customer> findAllCustomers() {

		return customerService.getAllCustomers();
	}

	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping("/customers/{country}")
	public List<Customer> getCustomers(@PathVariable String country) {

		return customerService.getCustomersFromCountry(country);
	}

}
