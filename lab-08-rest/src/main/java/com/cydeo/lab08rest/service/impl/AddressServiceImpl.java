package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.mapper.AddressMapper;
import com.cydeo.lab08rest.repository.AddressRepository;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public List<AddressDTO> getAddressList() {
        List<Address> addressList = addressRepository.findAll();
        return addressList.stream()
                .map(addressMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createAddress(AddressDTO addressDTO) {
        addressRepository.save(addressMapper.convertToEntity(addressDTO));
    }

    @Override
    public void updateAddress(AddressDTO addressDTO) {
        addressRepository.save(addressMapper.convertToEntity(addressDTO));
    }

    @Override
    public List<AddressDTO> getAddressListByCustomerId(Long id) {
      List<Address> addressList = addressRepository.retrieveByCustomerId(id);
      List<AddressDTO> addressDTOList = addressList.stream()
              .map(address -> addressMapper.convertToDto(address))
              .collect(Collectors.toList());
        return addressDTOList;
    }

    @Override
    public List<AddressDTO> getAddressListByStartsWithAddress(String pattern) {
        List<Address> addressList = addressRepository.findAllByStreetStartingWith(pattern);
        List<AddressDTO> addressDTOList = addressList.stream()
                .map(addressMapper::convertToDto)
                .collect(Collectors.toList());
        return addressDTOList;
    }

    @Override
    public List<AddressDTO> getAddressListByCustomerAndName(Long id, String name) {
        List<Address> addressList = addressRepository.findAllByCustomerIdAndName(id,name);
        List<AddressDTO> addressDTOList = addressList.stream()
                .map(addressMapper::convertToDto)
                .collect(Collectors.toList());
        return addressDTOList;
    }
}
