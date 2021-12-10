package com.lti.producerservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.producerservice.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
