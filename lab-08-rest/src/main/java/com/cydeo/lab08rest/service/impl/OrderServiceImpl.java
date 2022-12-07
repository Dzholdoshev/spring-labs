package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.entity.Discount;
import com.cydeo.lab08rest.entity.Order;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.mapper.OrderMapper;
import com.cydeo.lab08rest.repository.OrderRepository;
import com.cydeo.lab08rest.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }


    @Override
    public void createOrder(OrderDTO orderDTO) {
        orderRepository.save(orderMapper.convertToEntity(orderDTO));
    }

    @Override
    public void updateOrder(OrderDTO orderDTO) {
        orderRepository.save(orderMapper.convertToEntity(orderDTO));
    }

    @Override
    public List<OrderDTO> getOrderList() {
        List<Order> orderDTOList =  orderRepository.findAll();
        return orderDTOList.stream()
                .map(orderMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrderListByEmail(String email) {
        List<Order> orderList =  orderRepository.findAllByCustomer_Email(email);
        List<OrderDTO> orderDTOList = orderList.stream()
                .map(orderMapper::convertToDto)
                .collect(Collectors.toList());
        return orderDTOList;
    }

    @Override
    public List<OrderDTO> getOrderListByPaymentMethod(PaymentMethod method) {
        List<Order> orderList =  orderRepository.findAllByPayment_PaymentMethod(method);
        List<OrderDTO> orderDTOList = orderList.stream()
                .map(orderMapper::convertToDto)
                .collect(Collectors.toList());
        return orderDTOList;
    }
}
