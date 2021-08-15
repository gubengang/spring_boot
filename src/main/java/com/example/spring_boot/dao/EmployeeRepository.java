package com.example.spring_boot.dao;

import com.example.spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author gubengang
 * @create 2021-08-15 13:28
 */
@Repository
public interface EmployeeRepository extends JpaRepository<User,Integer> {
}
