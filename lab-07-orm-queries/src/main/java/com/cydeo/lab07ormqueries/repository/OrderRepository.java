package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Balance;
import com.cydeo.lab07ormqueries.entity.Order;
import com.cydeo.lab07ormqueries.enums.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    //1.Write a derived query to get top 5 orders by order by total price desc
    List<Order> findTop5ByOrderByTotalPrice();

    //2.Write a derived query to get all orders by customer email
    List<Order> getAllByCustomer_Email(String email);

    //3.Write a derived query to get all orders by specific payment method
    List<Order> getAllByPayment_PaymentMethod(PaymentMethod method);

    //4.Write a derived query to get all orders by specific payment method
    List<Order> getAllByPayment_Id(Long id);

    //5.Write a derived query to get all orders by specific customer email
    List<Order> getAllByCustomer_EmailContains(String email);

    //6.Write a derived query to check is there any orders by customer email
    Boolean existsByCustomer_Email(String email);
    //7.Write a native query to get all orders by specific product name

    @Query(value = "select * from orders o " +
            " left join cart c on o.cart_id = c.id " +
            " left join cart_item ci on c.id=ci.cart_id " +
            " inner join product p on ci.product_id=p.id " +
            "where p.name ilike concat('%',?1,'%')", nativeQuery = true)
    List<Order> retrieveAllByNameContains(String productName);

    //8.Write a native query to get all orders by specific categoryId
//    @Query(value = "select * from orders o " +
//            "left join cart c on o.cart_id = c.id " +
//            "left join cart_item ci on c.id=ci.cart_id " +
//            "left join product p on ci.product_id=p.id " +
//            "left join product_category_rel pcr on p.id=pcr.p_id " +
//            "inner join category cat on pcr.c_id=cat.id where cat.id = ?1 ", nativeQuery = true)
//      List<Order> retrieveAllByCategoryId(Long id);
//
    //9.Write a derived query to get all orders by totalPrice and paidPrice are equals
    List<Order> getAllByTotalPriceAndPaidPriceEquals(Double amount1, Double amount2);

   //10.Write a derived query to get all orders by totalPrice and paidPrice are not equals and discount is not null
    List<Order> getOrdersByTotalPriceIsPaidPrice();
}
