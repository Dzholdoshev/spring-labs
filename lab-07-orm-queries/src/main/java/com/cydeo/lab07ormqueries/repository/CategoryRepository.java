package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Balance;
import com.cydeo.lab07ormqueries.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
//    //1.Write a derived query to get category by name
//    Category getCategoryByName(String name);
//
//    //2.Write a derived query to get top 3 categories order by name desc
//    List<Category> getTop3ByOrderByNameDesc();

}
