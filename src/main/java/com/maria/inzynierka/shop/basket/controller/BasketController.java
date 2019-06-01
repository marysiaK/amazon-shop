package com.maria.inzynierka.shop.basket.controller;

import com.maria.inzynierka.shop.basket.model.BasketModel;
import com.maria.inzynierka.shop.product.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BasketController {

    @Autowired
    BasketModel basketModel;

    @GetMapping(value = "/users/{id}/products")
    public List<Product> getAllProductsForUser(@PathVariable("id") Long id) {
        return basketModel.getAllProductsForUserById(id);
    }

    @PostMapping(value = "/users/{id}/products")
    public void addProductToUser(@PathVariable("id") Long id, @RequestBody Product product) {
        basketModel.addProductToUser(id, product);
    }

    @GetMapping(value = "/users/{id}/products/checkout")
    public int addProductToUser(@PathVariable("id") Long id) {
        return basketModel.checkout(id);
    }

    @GetMapping(value = "/users/{id}/products/price")
    public int calculatePaymentForUser(@PathVariable("id") Long id) {
        return basketModel.calculatePaymentForUser(id);
    }


}
