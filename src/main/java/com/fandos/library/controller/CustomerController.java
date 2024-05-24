package com.fandos.library.controller;

import com.fandos.library.domain.Customer;
import com.fandos.library.dto.CustomerInDto;
import com.fandos.library.dto.CustomerOutDto;
import com.fandos.library.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAll(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerOutDto> saveCustomer(@Valid @RequestBody CustomerInDto customer){
        CustomerOutDto newCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<Void> removeCustomer(@PathVariable long customerId){
        customerService.removeCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/customer/{customerId}")
    public ResponseEntity<Customer> modifyCustomer(@Valid @RequestBody Customer customer, @PathVariable long customerId) {
        Customer updatedCustomer = customerService.modifyCustomer(customer, customerId);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
}
