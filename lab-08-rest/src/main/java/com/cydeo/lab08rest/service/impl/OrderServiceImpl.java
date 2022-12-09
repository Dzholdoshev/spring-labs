package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.entity.*;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.mapper.OrderMapper;
import com.cydeo.lab08rest.repository.OrderRepository;
import com.cydeo.lab08rest.service.CartService;
import com.cydeo.lab08rest.service.CustomerService;
import com.cydeo.lab08rest.service.OrderService;
import com.cydeo.lab08rest.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MapperUtil mapperUtil;
    private final CustomerService customerService;
    private final PaymentService paymentService;
    private final CartService cartService;
    private final OrderMapper orderMapper;


    public OrderServiceImpl(OrderRepository orderRepository, MapperUtil mapperUtil, CustomerService customerService, PaymentService paymentService, CartService cartService, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.mapperUtil = mapperUtil;
        this.customerService = customerService;
        this.paymentService = paymentService;
        this.cartService = cartService;
        this.orderMapper = orderMapper;
    }


    @Override
    public void createOrder(OrderDTO orderDTO) {
        orderRepository.save(orderMapper.convertToEntity(orderDTO));
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO) {
        Order order = mapperUtil.convert(orderDTO, new Order());
        order.setCustomer(mapperUtil.convert(customerService.findById(orderDTO.getCustomerId()), new Customer()));
        order.setPayment(mapperUtil.convert(paymentService.findById(orderDTO.getPaymentId()), new Payment()));
        order.setCart(mapperUtil.convert(cartService.findById(orderDTO.getCartId()), new Cart()));
        order.setPaidPrice(orderDTO.getPaidPrice());
        order.setTotalPrice(orderDTO.getTotalPrice());
        Order updatedOrder = orderRepository.save(order);

        return mapperUtil.convert(updatedOrder, new OrderDTO());
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
