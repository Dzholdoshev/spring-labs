package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.AddressDTO;

import java.util.List;

public interface AddressService {

    List<AddressDTO> getAddressList();
    void createAddress(AddressDTO addressDTO);
    void updateAddress(AddressDTO addressDTO);
    List<AddressDTO> getAddressListByCustomerId(Long id);
    List<AddressDTO> getAddressListByStartsWithAddress(String pattern);
    List<AddressDTO> getAddressListByCustomerAndName(Long id, String name);





}
