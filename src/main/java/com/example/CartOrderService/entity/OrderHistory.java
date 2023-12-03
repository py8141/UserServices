package com.example.CartOrderService.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Data
@Document(collection = "orderhistory")
public class OrderHistory {
    @Id
    private String orderId;
    private String userId;
    private List<CartItem> cartItemList;
}
