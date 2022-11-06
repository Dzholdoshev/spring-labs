package com.cydeo.lab07ormqueries.entity;


import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor

public class Address {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;


    private String name;
    private String street;
    private String zipCode;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Override
    public String toString() {
        return "Address{" +

                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", customer=" + customer +
                '}'+"\n";
    }
}
