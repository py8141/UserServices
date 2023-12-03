package com.example.CartOrderService.services;


import com.example.CartOrderService.entity.Cart;
import com.example.CartOrderService.entity.CartItem;
import com.sun.org.apache.xpath.internal.operations.Bool;

public interface CartService {

Cart getCartByUserId(String userId);
Boolean addToCart(String userId,CartItem cartItem);
Boolean removeInCart(String userId,String productId);
Boolean addProduct(String userId,String productId,String quantity);
Boolean incrementQuantity(String userId,String productId);
Boolean decrementQuantity(String userId,String productId);
int calculateTotalCost();
}
