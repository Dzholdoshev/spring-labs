package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.entity.Discount;
import com.cydeo.lab08rest.mapper.DiscountMapper;
import com.cydeo.lab08rest.repository.DiscountRepository;
import com.cydeo.lab08rest.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;
    private final DiscountMapper discountMapper;

    public DiscountServiceImpl(DiscountRepository discountRepository, DiscountMapper discountMapper) {
        this.discountRepository = discountRepository;
        this.discountMapper = discountMapper;
    }

    @Override
    public List<DiscountDTO> getDiscountList() {
        List<Discount> discountList =  discountRepository.findAll();
        return discountList.stream()
                .map(discountMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DiscountDTO getDiscountByName(String name) {
        Discount discount =  discountRepository.findByName(name);
        return discountMapper.convertToDto(discount);
    }

    @Override
    public void createDiscount(DiscountDTO discountDTO) {
        discountRepository.save(discountMapper.convertToEntity(discountDTO));

    }

    @Override
    public void updateDiscount(DiscountDTO discountDTO) {
        discountRepository.save(discountMapper.convertToEntity(discountDTO));

    }
}
