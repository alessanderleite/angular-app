package br.com.alessanderleite.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.alessanderleite.model.Customer;
import br.com.alessanderleite.repository.CustomerRepository;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getCustomer(Long id) {
		return customerRepository.findById(id);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(Long id) {
		Optional<Customer> customer = this.customerRepository.findById(id);
		if (customer.isPresent()) {
			customerRepository.delete(customer.get());
		}
	}
}
