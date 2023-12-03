package com.example.CartOrderService.services.Impl;

import com.example.CartOrderService.entity.Cart;
import com.example.CartOrderService.entity.CartItem;
import com.example.CartOrderService.repositry.CartRepositry;
import com.example.CartOrderService.services.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@Slf4j
public class CartServiceImpl implements CartService {

   @Autowired
    CartRepositry cartRepositry;

    @Override
    public Cart getCartByUserId(String userId) {
        return cartRepositry.findById(userId).orElse(null);
    }

    @Override
    public Boolean addToCart(String userId, CartItem cartItem) {
       Cart newCart = new Cart();
         List<CartItem> cartItems = new ArrayList<>();
         cartItems.add(cartItem);
       newCart.setCartItemList(cartItems);
       newCart.setUserId(userId);
       newCart.setCartId("2");
       cartRepositry.save(newCart);
       return true;
       }

    @Override
    public Boolean removeInCart(String userId, String productId) {
        Cart cart = cartRepositry.findById(userId).orElse(null);

        List<CartItem> cartItemList = cart.getCartItemList();
        cartItemList.remove(productId);
        return true;
    }

    @Override
    public Boolean addProduct(String userId, String productId, String quantity) {
        return null;
    }

    @Override
    public Boolean incrementQuantity(String userId, String productId) {
        Cart cart = cartRepositry.findById(userId).orElse(null);
        return null;
    }

    @Override
    public Boolean decrementQuantity(String userId, String productId) {
        return null;
    }

    @Override
    public int calculateTotalCost() {
        return 0;
    }
}




