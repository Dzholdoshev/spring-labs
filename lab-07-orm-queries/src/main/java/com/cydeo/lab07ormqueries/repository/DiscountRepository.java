package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Balance;
import com.cydeo.lab07ormqueries.entity.Discount;
import com.cydeo.lab07ormqueries.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {
    //1.Write a derived query to get discount by name
    List<Discount> findAllByName(String name);
    //2.Write a derived query to get all discounts greater than discount amount
    List<Discount> findAllByDiscountGreaterThan(Double discountAmount);
    //3.Write a derived query to get all discounts by specific discount type
    List<Discount>findAllByDiscountType(DiscountType type);
    //4.Write a JPQL query to get all discounts amount between range of discount amount
    @Query("select d from Discount d where d.discount between ?1 and ?2")
    List<Discount> retrieveAllByBetweenAmountRange(Double discount1, Double discount2);


}
