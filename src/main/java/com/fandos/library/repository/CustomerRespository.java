package com.fandos.library.repository;

import com.fandos.library.domain.Customer;
import org.hibernate.id.enhanced.CustomOptimizerDescriptor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRespository extends CrudRepository<Customer, Long> {

    List<Customer> findAll();

}
