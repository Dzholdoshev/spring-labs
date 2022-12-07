package com.cydeo.lab07ormqueries.repository;


import com.cydeo.lab07ormqueries.entity.Balance;
import com.cydeo.lab07ormqueries.entity.Cart;
import com.cydeo.lab07ormqueries.entity.CartItem;
import com.cydeo.lab07ormqueries.enums.CartState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    //1. Write a derived query to get count cart items
    Integer countByIdIsNotNull();
    //2. Write a derived query to get cart items for specific cart state
    List<CartItem> getCartItemByCart_CartState(CartState cartState);
    //3. Write a native query to get cart items for specific cart state and product name
    @Query(value = "select * from cart_item ci, product p, cart c " +
            "where ci.product_id=p.id and p.name = ?1 and ci.cart_id=c.id and c.cart_state = ?2 ", nativeQuery = true)
    List<CartItem> retrieveCartsByCartStateAndProduct(String name, String state);
    //4. Write a native query to get cart items for specific cart state and without discount
    @Query(value = "select * from cart_item ci " +
            "join cart c on ci.cart_id=c.id " +
            "where c.cart_state = ?1 and c.discount_id is null", nativeQuery = true)
    List<CartItem> retrieveByStateAndDiscountNull(String state);
    //5. Write a native query to get cart items for specific cart state and with specific Discount type
    @Query(value = "select * from cart_item ci " +
            "join cart c on ci.cart_id=c.id " +
            "join discount d on c.discount_id= d.id " +
            "where c.cart_state = ?1 and d.discount_type = ?2", nativeQuery = true)
    List<CartItem> retrieveByStateAndDiscount(String state, String type);
}
