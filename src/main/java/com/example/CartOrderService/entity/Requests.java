package com.example.CartOrderService.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Requests {
    String userId;
    String userName;
    Date date;
}
