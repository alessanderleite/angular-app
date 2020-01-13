package br.com.alessanderleite.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
	public List<Customer> getAllCustomers(Model model) {
		List<Customer> listOfCustomers = customerService.getAllCustomers();
		model.addAttribute("customer", new Customer());
		model.addAttribute("listOfCustomers", listOfCustomers);
		return listOfCustomers;
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT)
	public void updateCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
	}
}
