package com.company.module9challenge;

import com.company.module9challenge.model.Customer;
import com.company.module9challenge.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Module9ApplicationTests {

    @Autowired
    CustomerRepository customerRepo;

    @Before
    public void setUp() throws Exception {};

    @Test
    public void createTest() {
        customerRepo.deleteAll();

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
        List<Customer> customerList = customerRepo.findAll();
        assertEquals(1, customerList.size());
    }
}
