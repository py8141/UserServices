package com.example.CartOrderService.repositry;

import com.example.CartOrderService.entity.OrderHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderHistoryRepositry extends MongoRepository<OrderHistory,String> {

    @Query("{'userId': ?0}")
    List<OrderHistory> getAllOrders(String userId);

}
