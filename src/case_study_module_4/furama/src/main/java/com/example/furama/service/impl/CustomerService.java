package com.example.furama.service.impl;

import com.example.furama.model.Customer;
import com.example.furama.repository.ICustomerRepository;
import com.example.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public boolean addOrUpdate(Customer customer) {
        if (!(customerRepository.findByIdCardOrPhoneNumberOrEmail(customer.getIdCard()
         , customer.getPhoneNumber()
        , customer.getEmail()) == null)) {
            try {
                customerRepository.save(customer);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Page<Customer> findByNameAndEmail(String nameSearch, String emailSearch, Pageable pageable) {
        return customerRepository.findByNameContainingAndEmailContaining(nameSearch, emailSearch, pageable);
    }

    @Override
    public Page<Customer> searchByNameAndEmailAndCustomerType(Pageable pageable, String name, String email, int customerTypeId) {
        return customerRepository.findByNameContainingAndEmailAndCustomerType_Id(pageable, name, email, customerTypeId);
    }

    @Override
    public Boolean delete(int idDelete) {
        try {
            customerRepository.deleteById(idDelete);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
