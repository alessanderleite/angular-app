package br.com.alessanderleite.dao;

import java.util.List;
import java.util.Optional;

import br.com.alessanderleite.model.Customer;

public interface CustomerDao {
	List<Customer> getAllCustomers();
	Optional<Customer> getCustomer(Long id);
	Customer addCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(Long id);
}
