package com.mybank.repository;


import com.mybank.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Accounts,Long> {

    Accounts findByCustomerId(int customerId);

}
