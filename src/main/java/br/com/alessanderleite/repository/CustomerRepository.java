package br.com.alessanderleite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alessanderleite.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
