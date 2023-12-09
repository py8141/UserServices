package com.example.CartOrderService.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {
    String profilePicUrl;
    String name;
    List<String> followers;
    List<String> following;
}
