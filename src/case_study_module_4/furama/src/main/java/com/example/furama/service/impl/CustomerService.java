package com.example.furama.service.impl;

import com.example.furama.model.Customer;
import com.example.furama.repository.ICustomerRepository;
import com.example.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;


    @Override
    public boolean addOrUpdate(Customer customer) {
        try {
            customerRepository.save(customer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Page<Customer> getList(String nameSearch, Pageable pageable) {
       return customerRepository.findByName(nameSearch, pageable);
    }
}
