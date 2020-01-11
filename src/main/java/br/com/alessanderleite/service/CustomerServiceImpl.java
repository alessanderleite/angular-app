package br.com.alessanderleite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alessanderleite.dao.CustomerDao;
import br.com.alessanderleite.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> getAllCustomers() {
		return this.customerDao.getAllCustomers();
	}

	@Override
	public Optional<Customer> getCustomer(Long id) {
		return this.customerDao.getCustomer(id);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return this.customerDao.addCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		this.customerDao.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(Long id) {
		Optional<Customer> customer = this.customerDao.getCustomer(id);
		if (customer.isPresent()) {
			this.customerDao.deleteCustomer(id);
		}
	}
}
