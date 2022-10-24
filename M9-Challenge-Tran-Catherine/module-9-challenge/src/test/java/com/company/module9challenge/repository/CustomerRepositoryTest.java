package com.company.module9challenge.repository;

import com.company.module9challenge.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepo;

    @Before
    public void setUp() throws Exception {
        customerRepo.deleteAll();
    }

    @Test
    public void shouldCreateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Squidward");
        customer.setLastName("Tennisballs");
        customer.setEmail("squidward@krabby.com");
        customer.setCompany("Krabby Patty LLC");
        customer.setPhone("1-123-456-7890");
        customer.setFirstAddress("234 Fisherman Lane");
        customer.setSecondAddress("567 Squid Avenue");
        customer.setCity("Bikini Bottom");
        customer.setState("Underwater");
        customer.setPostalCode("12345");
        customer.setCountry("Somewhere in the Pacific");

        // ACT
        customerRepo.save(customer);

        // ASSERT
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());
        assertEquals(customer1.get(), customer);

        assertTrue(true);
    }

    @Test
    public void shouldUpdateCustomer() {

        // ARRANGE
        Customer customer = new Customer();
        customer.setFirstName("Squidward");
        customer.setLastName("Tennisballs");
        customer.setEmail("squidward@krabby.com");
        customer.setCompany("Krabby Patty LLC");
        customer.setPhone("1-123-456-7890");
        customer.setFirstAddress("234 Fisherman Lane");
        customer.setSecondAddress("567 Squid Avenue");
        customer.setCity("Bikini Bottom");
        customer.setState("Underwater");
        customer.setPostalCode("12345");
        customer.setCountry("Somewhere in the Pacific");

        // ACT
        customerRepo.save(customer);

        // ASSERT
        Optional<Customer> oldCustomer = customerRepo.findById(customer.getId());
        assertEquals(oldCustomer.get(), customer);

        // ARRANGE
        customer.setLastName("Tentacles");

        // ACT
        customerRepo.save(customer);

        // ASSERT
        Optional<Customer> newCustomer = customerRepo.findById(customer.getId());
        assertEquals(newCustomer.get(), customer);

        assertTrue(true);

        // update code

    }

    @Test
    public void shouldDeleteCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Squidward");
        customer.setLastName("Tennisballs");
        customer.setEmail("squidward@krabby.com");
        customer.setCompany("Krabby Patty LLC");
        customer.setPhone("1-123-456-7890");
        customer.setFirstAddress("234 Fisherman Lane");
        customer.setSecondAddress("567 Squid Avenue");
        customer.setCity("Bikini Bottom");
        customer.setState("Underwater");
        customer.setPostalCode("12345");
        customer.setCountry("Somewhere in the Pacific");

        // ACT
        customerRepo.save(customer);

        // ASSERT
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());
        assertEquals(customer1.get(), customer);

        customerRepo.deleteById(customer.getId());

        customer1 = customerRepo.findById(customer.getId());

        assertFalse(customer1.isPresent());
    }

    @Test
    public void shouldFindCustomerById() {
        Customer customer = new Customer();
        customer.setFirstName("Squidward");
        customer.setLastName("Tennisballs");
        customer.setEmail("squidward@krabby.com");
        customer.setCompany("Krabby Patty LLC");
        customer.setPhone("1-123-456-7890");
        customer.setFirstAddress("234 Fisherman Lane");
        customer.setSecondAddress("567 Squid Avenue");
        customer.setCity("Bikini Bottom");
        customer.setState("Underwater");
        customer.setPostalCode("12345");
        customer.setCountry("Somewhere in the Pacific");

        // ACT
        customerRepo.save(customer);

        // ASSERT
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());
        assertEquals(customer1.get(), customer);

        customer1 = customerRepo.findById(customer.getId());

        assertTrue(customer1.isPresent());
    }

    @Test
    public void shouldFindCustomerByState() {
        Customer customer = new Customer();
        customer.setFirstName("Squidward");
        customer.setLastName("Tennisballs");
        customer.setEmail("squidward@krabby.com");
        customer.setCompany("Krabby Patty LLC");
        customer.setPhone("1-123-456-7890");
        customer.setFirstAddress("234 Fisherman Lane");
        customer.setSecondAddress("567 Squid Avenue");
        customer.setCity("Bikini Bottom");
        customer.setState("Underwater");
        customer.setPostalCode("12345");
        customer.setCountry("Somewhere in the Pacific");

        // ACT
        customerRepo.save(customer);

        // ASSERT
        List<Customer> customer1 = customerRepo.findCustomersByState(customer.getState());
        assertEquals(customer1.equals(customer), customer);

        customer1 = customerRepo.findCustomersByState("Underwater");

        assertEquals(customer.getState(), customer1, customer1);
    }
}