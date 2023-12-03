package com.example.CartOrderService.repositry;

import com.example.CartOrderService.entity.Cart;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepositry extends MongoRepository<Cart,String> {

}
