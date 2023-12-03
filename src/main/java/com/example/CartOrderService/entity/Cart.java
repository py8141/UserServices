package com.example.CartOrderService.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Data
@Document(collection = "carts")
public class Cart {
    @nonapi.io.github.classgraph.json.Id
    private String cartId;
    private String userId;
    private List<CartItem> cartItemList ;


}
