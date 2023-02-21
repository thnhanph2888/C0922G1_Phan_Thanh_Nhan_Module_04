package com.example.furama.service;

import com.example.furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    boolean addOrUpdate(Customer customer);
    Page<Customer> findByNameAndEmail(String nameSearch, String emailSearch, Pageable pageable);
    Page<Customer> searchByNameAndEmailAndCustomerType(Pageable pageable, String name, String email, int customerTypeId);
    Boolean delete(int idDelete);
    Customer findById(int id);


}
