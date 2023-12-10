package com.example.CartOrderService.repositry;

import com.example.CartOrderService.entity.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepositry extends MongoRepository<UserDetails,String > {

    boolean existsByUserName(String userName);

}
