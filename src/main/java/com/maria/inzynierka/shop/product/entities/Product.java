package com.maria.inzynierka.shop.product.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maria.inzynierka.shop.basket.entities.ProductsForUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    private String description;
    private String image;
    @OneToMany(mappedBy = "productId")
    @JsonIgnore
    private List<ProductsForUser> productsForUserList;
}