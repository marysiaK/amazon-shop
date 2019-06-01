package com.maria.inzynierka.shop.basket.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.maria.inzynierka.shop.product.entities.Product;
import com.maria.inzynierka.shop.user.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ProductsForUser")
@Getter
@Setter
@NoArgsConstructor
public class ProductsForUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User userId;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    private Product productId;


    public ProductsForUser(User userId, Product productId) {
        this.userId = userId;
        this.productId = productId;

    }
}
