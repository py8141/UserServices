package com.example.CartOrderService.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
public class CartItem {
      private String productId;
      private String merchantId;
      private int quantity;
}
