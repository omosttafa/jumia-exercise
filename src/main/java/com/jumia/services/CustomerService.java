package com.jumia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.entities.Customer;
import com.jumia.repositories.CustomerRepository;

@Service("customerService")
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerService customerService;

	@Override
	public Iterable<Customer> getAllCustomers() {
		return customerRepository.findAll();

	}

	@Override
	public List<Customer> getCustomersFromCountry(String country) {

		List<Customer> customers = new ArrayList<>();
		Pattern countryPattern;
		Pattern numberValidationPattern;
		Matcher countryMatcher;
		Matcher numberValidationMatcher;

		for (Customer customer : customerService.getAllCustomers()) {
			switch (country) {

			case "cameron": {

				countryPattern = Pattern.compile("\\(237\\).*");
				countryMatcher = countryPattern.matcher(customer.getPhone());
				// above to filter country numbers.

				numberValidationPattern = Pattern.compile("\\(237\\)\\ ?[2368]\\d{7,8}$");
				numberValidationMatcher = numberValidationPattern.matcher(customer.getPhone());
				// above to validate numbers.

				if (countryMatcher.matches()) {
					if (numberValidationMatcher.matches()) {
						customer.setValidation("valid");

					}
					else
					{
						customer.setValidation("not valid");
					}
					customer.setCountryCode("+237");
					customers.add(customer);
				}

				break;
			}
			case "ethiopia": {

				countryPattern = Pattern.compile("\\(251\\).*");
				countryMatcher = countryPattern.matcher(customer.getPhone());
				// above to filter country numbers.

				numberValidationPattern = Pattern.compile("\\(251\\)\\ ?[1-59]\\d{8}$");
				numberValidationMatcher = numberValidationPattern.matcher(customer.getPhone());
				// above to validate numbers.

				if (countryMatcher.matches()) {
					if (numberValidationMatcher.matches()) {
						customer.setValidation("valid");

					}
					else
					{
						customer.setValidation("not valid");
					}
					customer.setCountryCode("+251");
					customers.add(customer);
				}

				break;
			}

			case "morocco": {

				countryPattern = Pattern.compile("\\(212\\).*");
				countryMatcher = countryPattern.matcher(customer.getPhone());
				// above to filter country numbers.

				numberValidationPattern = Pattern.compile("\\(212\\)\\ ?[5-9]\\d{8}$");
				numberValidationMatcher = numberValidationPattern.matcher(customer.getPhone());
				// above to validate numbers.

				if (countryMatcher.matches()) {
					if (numberValidationMatcher.matches()) {
						customer.setValidation("valid");

					}
					else
					{
						customer.setValidation("not valid");
					}
					customer.setCountryCode("+212");
					customers.add(customer);
				}
				break;
			}
			case "mozambique": {

				countryPattern = Pattern.compile("\\(258\\).*");
				countryMatcher = countryPattern.matcher(customer.getPhone());
				// above to filter country numbers.

				numberValidationPattern = Pattern.compile("\\(258\\)\\ ?[28]\\d{7,8}$");
				numberValidationMatcher = numberValidationPattern.matcher(customer.getPhone());
				// above to validate numbers.

				if (countryMatcher.matches()) {
					if (numberValidationMatcher.matches()) {
						customer.setValidation("valid");

					}
					else
					{
						customer.setValidation("not valid");
					}
					customer.setCountryCode("+258");
					customers.add(customer);
				}
				break;
			}

			case "uganda": {

				countryPattern = Pattern.compile("\\(256\\).*");
				countryMatcher = countryPattern.matcher(customer.getPhone());
				// above to filter country numbers.

				numberValidationPattern = Pattern.compile("\\(256\\)\\ ?\\d{9}$");
				numberValidationMatcher = numberValidationPattern.matcher(customer.getPhone());
				// above to validate numbers.

				if (countryMatcher.matches()) {
					if (numberValidationMatcher.matches()) {
						customer.setValidation("valid");
					}
					else
					{
						customer.setValidation("not valid");
					}
					customer.setCountryCode("+237");
					customers.add(customer);
				}

				break;
			}

			default:
				break;
			}

		}

		return customers;
	}

}
