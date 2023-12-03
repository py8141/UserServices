package com.example.CartOrderService.services.Impl;

import com.example.CartOrderService.dto.responses.OrderHistoryResponseDto;
import com.example.CartOrderService.entity.CartItem;
import com.example.CartOrderService.entity.OrderHistory;
import com.example.CartOrderService.repositry.OrderHistoryRepositry;
import com.example.CartOrderService.services.OrderHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class OrderHistoryServiceImpl implements OrderHistoryService {

 @Autowired
    OrderHistoryRepositry orderHistoryRepositry;


    @Override
    public List<OrderHistoryResponseDto> getOrderHistory(String userId) {


        List<OrderHistory> orderHistory =  orderHistoryRepositry.getAllOrders(userId);

        List<OrderHistoryResponseDto> orderHistoryResponseDtos = new ArrayList<>();

        for(OrderHistory order : orderHistory){
            OrderHistoryResponseDto responseDto = new OrderHistoryResponseDto();
            BeanUtils.copyProperties(order,responseDto);
            orderHistoryResponseDtos.add(responseDto);
        }
        return orderHistoryResponseDtos;
    }

    @Override
    public Boolean addOrderHistory(String userId, CartItem cartItem) {

        OrderHistory newOrder = new OrderHistory();
        newOrder.setUserId(userId);
        List<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(cartItem);
        newOrder.setCartItemList(cartItemList);
        orderHistoryRepositry.save(newOrder);
       return true;
    }
}
