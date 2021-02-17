package com.stackssimplify.restservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackssimplify.restservices.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
