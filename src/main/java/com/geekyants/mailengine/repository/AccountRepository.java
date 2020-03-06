package com.geekyants.mailengine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.geekyants.mailengine.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{

}
