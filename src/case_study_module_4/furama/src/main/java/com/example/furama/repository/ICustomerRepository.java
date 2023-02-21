package com.example.furama.repository;

import com.example.furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findByNameContainingAndEmailContaining(String nameSearch,String emailSearch, Pageable pageable);

    Page<Customer> findByNameContainingAndEmailContainingAndCustomerType_Id(Pageable pageable, @Param("name") String name, @Param("email") String email, @Param("customerTypeId") int customerTypeId);
    List<Customer> findByIdCardOrPhoneNumberOrEmail(String idCard, String phoneNumber, String email);
}
