package com.example.CartOrderService.dto.responses;

import com.example.CartOrderService.entity.CartItem;
import lombok.Data;

import java.util.List;
@Data
public class OrderHistoryResponseDto {
    private String orderId;
    private List<CartItem> cartItemList;
}
