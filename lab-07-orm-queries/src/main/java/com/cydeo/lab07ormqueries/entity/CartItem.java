package com.cydeo.lab07ormqueries.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    private Integer quantity;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="cart_id")
    private Cart cart;

    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn(name="product_id")


//    @JoinColumns({
//            @JoinColumn(name="product_id", referencedColumnName="id"),
//            @JoinColumn(name="quantity", referencedColumnName="quantity")
//    })
    private Product product;

    @Override
    public String toString() {
        return "CartItem{" +
                "quantity=" + quantity +
                ", cart=" + cart.getId()+
                ", product=" + product.getName() +
               // " " +  cart.getCartState().toString()                 +
                '}'+"\n";
    }
}
