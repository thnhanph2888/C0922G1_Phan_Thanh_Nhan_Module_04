package com.example.spring_security.repository;

import com.example.spring_security.model.AppRole;
import com.example.spring_security.model.AppUser;
import com.example.spring_security.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
