package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.mapper.AddressMapper;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;
    private final AddressMapper addressMapper;

    public AddressController(AddressService addressService, AddressMapper addressMapper) {
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }


    @GetMapping
    public ResponseEntity<ResponseWrapper> getAddressList() {

        List<AddressDTO> addressDTOList = addressService.getAddressList();
        return ResponseEntity.ok(new ResponseWrapper("List of Addresses Are Retrieved", addressDTOList, HttpStatus.OK));
    }

    @PostMapping()
    public ResponseEntity<ResponseWrapper> createAddress(@RequestBody AddressDTO addressDTO) {
        addressService.createAddress(addressDTO);
        return ResponseEntity.ok(new ResponseWrapper("Address is created",addressDTO,HttpStatus.OK));
    }

    @PutMapping()
    public ResponseEntity<ResponseWrapper> updateAddress(@RequestBody AddressDTO addressDTO){
       addressService.updateAddress(addressDTO);
        return ResponseEntity.ok(new ResponseWrapper("Address is updated",addressDTO,HttpStatus.CREATED));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<ResponseWrapper> getAddressListByCustomerId(@PathVariable("customerId") Long id){
       List<AddressDTO> addressDTOList = addressService.getAddressListByCustomerId(id);
        return ResponseEntity.ok(new ResponseWrapper("Address is retrieved by customer ID",addressDTOList,HttpStatus.CREATED));
    }

    @GetMapping("/startsWith/{address}")
   public ResponseEntity<ResponseWrapper> getAddressListByStartsWithAddress(@PathVariable("address") String address){
        List<AddressDTO> addressDTOList =   addressService.getAddressListByStartsWithAddress(address);
        return ResponseEntity.ok(new ResponseWrapper("Address starting with '"+ address +"' is retrieved",addressDTOList,HttpStatus.OK));
    }

    @GetMapping("/customer/{customerId}/name/{name}")
   public ResponseEntity<ResponseWrapper> getAddressListByCustomerAndName(@PathVariable("customerId")Long id, @PathVariable ("name") String name){
       List<AddressDTO> addressDTOList =addressService.getAddressListByCustomerAndName(id, name);
       return ResponseEntity.ok(new ResponseWrapper("Address by customer and Name is retrieved",addressDTOList,HttpStatus.OK));
   }

}
