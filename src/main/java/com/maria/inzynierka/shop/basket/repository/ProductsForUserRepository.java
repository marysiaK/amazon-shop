package com.maria.inzynierka.shop.basket.repository;

import com.maria.inzynierka.shop.basket.entities.ProductsForUser;
import com.maria.inzynierka.shop.user.entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductsForUserRepository extends CrudRepository<ProductsForUser, Long> {

    @Query("SELECT a FROM ProductsForUser as a WHERE a.userId=:userId")
    List<ProductsForUser> fetchProducts(@Param("userId") User userId);

    @Transactional
    @Modifying
    @Query("Delete FROM ProductsForUser as a WHERE a.userId=:userId")
    void deleteProductsForUser(@Param("userId") User userId);

}
