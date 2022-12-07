package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AddressRepository extends JpaRepository <Address,String> {
    //1. Write a derived query to get all address with a specific customer
    List<Address>getAddressByCustomer_Id(Long id);
    //2. Write a derived query to get address with a specific street
    List<Address>getAddressByStreet(String street);
    //3. Write a derived query to get top 3 address with a specific customer email
    List<Address>getTop3ByCustomer_Email(String email);
    //4. Write a derived query to get all address with a specific customer and name
    List<Address>getAllByCustomer_LastName(String lastName);
    //5. Write a derived query to list all address where the beginning of the street contains the keyword
    List<Address>getAllByStreetStartingWith(String pattern);
    //6. Write a JPQL query to get all address with a specific customerId
    @Query("select a from Address a where a.customer.id = ?1")
    List<Address>retrieveAllByCustomer_Id(Long id);
}
