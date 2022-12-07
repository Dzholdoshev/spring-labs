package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.mapper.CustomerMapper;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;


    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getCustomerList() {
        List<CustomerDTO> customerDTOList = customerService.getCustomerList();
        return ResponseEntity.ok(new ResponseWrapper("List of Customers is retrieved", customerDTOList, HttpStatus.OK));
    }

    @GetMapping("/{email}")
    public ResponseEntity<ResponseWrapper> getCustomerListByEmail(@PathVariable("email") String email) {
        List<CustomerDTO> customerDTOList = customerService.getCustomerListByEmail(email);
        return ResponseEntity.ok(new ResponseWrapper("List of Customers by email", customerDTOList, HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.createCustomer(customerDTO);
        return ResponseEntity.ok(new ResponseWrapper("Customer is created",customerDTO,HttpStatus.OK));
    };

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerDTO);
        return ResponseEntity.ok(new ResponseWrapper("Customer is updated",customerDTO,HttpStatus.OK));
    };


}
