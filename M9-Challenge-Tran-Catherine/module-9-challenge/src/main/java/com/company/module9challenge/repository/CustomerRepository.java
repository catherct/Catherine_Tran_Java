package com.company.module9challenge.repository;

import com.company.module9challenge.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> createCustomer(Customer customer);

    List<Customer> updateCustomer(Customer customer);

    List<Customer> deleteCustomer();

    List<Customer> findCustomerById(int customerId);

    List<Customer> findCustomersByState(String state);
}
