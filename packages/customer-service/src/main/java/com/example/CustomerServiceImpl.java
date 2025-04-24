package com.example;

//import com.google.inject.Inject;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

//    private final CustomerRepository customerRepository;
//
//    @Inject
//    public CustomerServiceImpl(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    @Override
    public List<String> getCustomers() {
//        return customerRepository.fetchCustomers();
        return List.of("Alice", "Bob", "Charlie");
    }

    @Override
    public void createCustomer(String customer) {
//        customerRepository.saveCustomer(customer);
    }
}