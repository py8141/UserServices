package com.example.CartOrderService.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RequestDto {
    String userId;
    String userName;
    Date date;
}
