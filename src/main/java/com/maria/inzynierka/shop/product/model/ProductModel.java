package com.maria.inzynierka.shop.product.model;

import com.maria.inzynierka.shop.product.entities.Product;
import com.maria.inzynierka.shop.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductModel {

    @Autowired
    ProductRepository productRepository;

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void removeProductById(Long id) {
        productRepository.deleteById(id);
    }
}
