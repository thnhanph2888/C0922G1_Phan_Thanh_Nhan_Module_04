package com.example.phone_management.repository;

import com.example.phone_management.model.Smartphone;
import org.springframework.data.repository.CrudRepository;

public interface IRepository extends CrudRepository<Smartphone, Long> {
    
}
