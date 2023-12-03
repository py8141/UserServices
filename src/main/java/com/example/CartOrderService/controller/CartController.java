package com.example.CartOrderService.controller;
import com.example.CartOrderService.entity.Cart;
import com.example.CartOrderService.entity.CartItem;
import com.example.CartOrderService.services.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@Slf4j
@RequestMapping("/cart")
public class CartController {

  @Autowired
    CartService cartService;

    @GetMapping("/cartofUser")
    Cart getCardById(@RequestParam String userId){

       return cartService.getCartByUserId(userId);
    }

    @PostMapping("/addToCart")
    Boolean addToCart(@RequestParam String userId, @RequestBody CartItem cartItem){

        return cartService.addToCart(userId,cartItem);
    }

    @DeleteMapping("/removeProduct")
    Boolean removeProduct(@RequestParam String userId,@RequestParam String productId){

        return cartService.removeInCart(userId,productId);
    }

}
