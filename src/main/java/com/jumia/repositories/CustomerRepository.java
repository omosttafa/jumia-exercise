package com.jumia.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jumia.entities.Customer;

@Repository("customerRepository")
public interface CustomerRepository extends CrudRepository<Customer, String> {

}
