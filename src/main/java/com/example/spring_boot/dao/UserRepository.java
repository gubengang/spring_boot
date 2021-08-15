package com.example.spring_boot.dao;

import com.example.spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author gubengang
 * @create 2021-08-15 12:37
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
