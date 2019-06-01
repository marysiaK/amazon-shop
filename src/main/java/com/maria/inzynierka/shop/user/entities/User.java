package com.maria.inzynierka.shop.user.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maria.inzynierka.shop.basket.entities.ProductsForUser;
import com.maria.inzynierka.shop.product.entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String password;
    private String description;
    private String age;
    @OneToMany(
            mappedBy = "userId")
    @JsonIgnore
    private List<ProductsForUser> products;
}