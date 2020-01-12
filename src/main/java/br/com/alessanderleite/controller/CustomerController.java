package br.com.alessanderleite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.alessanderleite.model.Customer;
import br.com.alessanderleite.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
}
