package com.maria.inzynierka.shop.product.controller;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.maria.inzynierka.shop.product.entities.Product;
import com.maria.inzynierka.shop.product.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController implements RequestHandler<Product, List<Product>> {


    @Autowired
    ProductModel productModel;

    @GetMapping(value = "/products")
    @PermitAll
    public Iterable<Product> getAllProducts() {
        return productModel.getAllProducts();
    }

    @PostMapping(value = "/products")
    @Secured("ROLE_ADMIN")
    public void addProduct(@RequestBody Product product) {
        productModel.addProduct(product);
    }

    @GetMapping(value = "/products/{id}")
    @PermitAll
    public Product getProduct(@PathVariable("id") Long id) {
        return productModel.getProductById(id);
    }

    @DeleteMapping(value = "/products/{id}")
    @Secured("ROLE_ADMIN")
    public void removeProduct(@PathVariable("id") Long id) {
        productModel.removeProductById(id);
    }


    @Override
    public List<Product> handleRequest(Product product, Context context) {
        return null;
    }
}
