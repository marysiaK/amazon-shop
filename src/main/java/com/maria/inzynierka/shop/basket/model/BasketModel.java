package com.maria.inzynierka.shop.basket.model;

import com.maria.inzynierka.shop.basket.entities.ProductsForUser;
import com.maria.inzynierka.shop.basket.repository.ProductsForUserRepository;
import com.maria.inzynierka.shop.product.entities.Product;
import com.maria.inzynierka.shop.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BasketModel {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductsForUserRepository productsForUserRepository;

    public List<Product> getAllProductsForUserById(Long id) {
        List<Product> list = new ArrayList();
        userRepository.findById(id).get().getProducts().forEach(prod -> list.add(prod.getProductId()));
        return list;
    }

    public void addProductToUser(Long id, Product product) {
        productsForUserRepository.save(new ProductsForUser(userRepository.findById(id).get(), product));
    }

    public int checkout(Long id) {
        int priceToPay = calculatePaymentForUser(id);
        removeElementsFromBasketForUser(id);
        return priceToPay;
    }

    private void removeElementsFromBasketForUser(Long id) {
        productsForUserRepository.deleteProductsForUser(userRepository.findById(id).get());
    }

    public int calculatePaymentForUser(Long id) {
        int priceToPay = 0;
        for (ProductsForUser productsForUser : productsForUserRepository.fetchProducts(userRepository.findById(id).get())) {
            priceToPay += Integer.valueOf(productsForUser.getProductId().getPrice());
        }
        return priceToPay;
    }
}
