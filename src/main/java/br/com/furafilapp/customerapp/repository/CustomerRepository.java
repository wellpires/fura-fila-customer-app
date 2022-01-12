package br.com.furafilapp.customerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.furafilapp.customerapp.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
