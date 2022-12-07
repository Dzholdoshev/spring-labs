package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Balance;
import com.cydeo.lab07ormqueries.entity.Cart;
import com.cydeo.lab07ormqueries.enums.CartState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    //1.Write a derived query to get all cart by specific discount type
    List<Cart>getAllByDiscount_Id(Long discountId);
    //2.Write a JPQL query to get all cart by customer
    @Query("select c from Cart c where c.customer.id = ?1")
    List<Cart>retrieveAllByCustomerId(Long id);
    //3.Write a derived query to get all cart by customer and cart state
    List<Cart> getAllByCustomer_IdAndCartState(Long id, CartState state);
    //4.Write a derived query to get all cart by customer and cart state and discount is null condition
    List<Cart> getAllByCustomer_IdAndCartStateAndDiscount_IdIsNull(Long id, CartState state);
    //5.Write a native query to get all cart by customer and cart state and discount is not null condition
    @Query(value = "select * from cart c where c.customer_id = ?1 and c.cart_state = ?2 and c.discount_id is not null",nativeQuery = true)
    List<Cart> retrieveAllByCustomer_IdAndCartStateAndDiscountIsNotNull(Long id, String state);
}
