package com.example.furama.service;

import com.example.furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    boolean addOrUpdate(Customer customer);
    Page<Customer> getList(String nameSearch, Pageable pageable);
}
