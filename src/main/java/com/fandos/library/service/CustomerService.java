package com.fandos.library.service;

import com.fandos.library.domain.Customer;
import com.fandos.library.dto.CustomerInDto;
import com.fandos.library.dto.CustomerOutDto;
import com.fandos.library.repository.CustomerRespository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRespository customerRespository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Customer> findAll(){
        return customerRespository.findAll();
    }

    public CustomerOutDto saveCustomer(CustomerInDto customerInDto){
        Customer customer = new Customer();
        modelMapper.map(customerInDto, customer);
        customer.setRegisterDate(LocalDate.now());
        Customer newCustomer = customerRespository.save(customer);

        CustomerOutDto customerOutDto = new CustomerOutDto();
        modelMapper.map(newCustomer, customerOutDto);

        return customerOutDto;
    }

    public void removeCustomer(long customerId){
        Customer customer = customerRespository.findById(customerId).orElseThrow();
        customerRespository.delete(customer);
    }

    public Customer modifyCustomer(Customer actualCustomer, long customerId) {
        Optional<Customer> customer = customerRespository.findById(customerId);
        if (customer.isPresent()) {
            Customer existingCustomer = customer.get();
            existingCustomer.setName(actualCustomer.getName());
            existingCustomer.setEmail(actualCustomer.getEmail());
            existingCustomer.setPartner(actualCustomer.isPartner());
            return customerRespository.save(existingCustomer);
        } else {
            throw new RuntimeException("Customer not found");
        }
    }
}
