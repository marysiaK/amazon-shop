package com.maria.inzynierka.shop.user.repository;

import com.maria.inzynierka.shop.user.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
