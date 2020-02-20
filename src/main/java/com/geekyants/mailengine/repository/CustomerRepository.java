package com.geekyants.mailengine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.geekyants.mailengine.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
