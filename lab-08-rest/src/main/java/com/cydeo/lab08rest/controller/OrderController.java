package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.mapper.OrderMapper;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

private final OrderService orderService;
private final OrderMapper orderMapper;

    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createOrder(@RequestBody OrderDTO orderDTO){
        orderService.createOrder(orderDTO);
        return ResponseEntity.ok(new ResponseWrapper("Order is created",orderDTO, HttpStatus.OK));
    }
    @PutMapping
    public ResponseEntity<ResponseWrapper>  updateOrder(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(new ResponseWrapper("Order are successfully updated"
                , orderService.updateOrder(orderDTO), HttpStatus.OK));
    }
    @GetMapping
    public ResponseEntity<ResponseWrapper> getAddressList() {
        List<OrderDTO> orderDTOList = orderService.getOrderList();
        return ResponseEntity.ok(new ResponseWrapper("Order list is retrieved", orderDTOList, HttpStatus.OK));
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseWrapper> getOrderListByEmail(@PathVariable("email") String email ){
        List<OrderDTO> orderDTOList = orderService.getOrderListByEmail(email);
        return ResponseEntity.ok(new ResponseWrapper("Order List by email", orderDTOList, HttpStatus.OK));
    }
    @GetMapping("/paymentMethod/{paymentMethod}")
    public ResponseEntity<ResponseWrapper> getOrderListByPaymentMethod(@PathVariable ("paymentMethod")PaymentMethod method){
        List<OrderDTO> orderDTOList = orderService.getOrderListByPaymentMethod(method);
        return ResponseEntity.ok(new ResponseWrapper("Order List by payment method", orderDTOList, HttpStatus.OK));
    };





}
