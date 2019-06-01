package com.maria.inzynierka.shop.product.repository;

import com.maria.inzynierka.shop.product.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends  CrudRepository<Product, Long> {

}
