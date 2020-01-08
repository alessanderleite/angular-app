package br.com.alessanderleite.service;

import java.util.List;

import br.com.alessanderleite.model.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	Customer getCustomer(Long id);
	Customer addCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(Long id);
}
