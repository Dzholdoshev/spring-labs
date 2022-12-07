package com.cydeo.lab07ormqueries.repository;


import com.cydeo.lab07ormqueries.entity.Address;
import com.cydeo.lab07ormqueries.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {
    //1. Write a derived query to check balance exists for specific customer
    Boolean existsByCustomer_Id(Long id);

    //2. Write a derived query to get balance for specific customer
    List<Balance> getBalanceByCustomer_Id(Long id);

    //3. Write a native query to get top 5 max balance
    @Query(value = "select * from balance b where b.amount is not null order by b.amount desc  limit 5", nativeQuery = true)
    List<Balance> retrieveTop5MaxBalance();

    //4. Write a derived query to get all balances greater than or equal specific balance amount
    List<Balance> getBalanceByAmountGreaterThanEqual(Double amount);

    //5. Write a native query to get all balances less than specific balance amount
    @Query("select b from Balance b where b.amount < ?1")
    List<Balance> retrieveBalanceLessThan(Double amount);


}
