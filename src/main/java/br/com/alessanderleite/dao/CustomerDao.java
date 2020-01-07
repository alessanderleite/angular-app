package br.com.alessanderleite.dao;

import java.util.List;

import br.com.alessanderleite.model.Customer;

public interface CustomerDao {
	List<Customer> getAllCustomers();
	Customer getCustomer(Long id);
	Customer addCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(Long id);
}
