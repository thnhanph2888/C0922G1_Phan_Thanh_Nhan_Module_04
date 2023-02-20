package com.example.furama.repository;

import com.example.furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer", nativeQuery = true)
    Page<Customer> findAll(Pageable pageable);

    @Query(nativeQuery = true, value = "select * from customer where customer.name like :name and customer.email like :email and customer.customer_type_id like :customerTypeId")
    Page<Customer> findByNameContainingAndEmailAndCustomerType(Pageable pageable, @Param("name") String name, @Param("email") String email, @Param("customerTypeId") String customerTypeId);
}
