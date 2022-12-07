package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Balance;
import com.cydeo.lab07ormqueries.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    //1.Write a derived query to get all customer by id
    List<Customer>getAllById(Long id);
    //2.Write a JPQL query to get customer by email
    @Query("select c from Customer c where c.email = ?1")
    List<Customer>retrieveAllByEmail(String email);

}
