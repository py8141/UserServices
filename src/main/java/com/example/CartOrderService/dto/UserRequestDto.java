package com.example.CartOrderService.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UserRequestDto {
    String userEmail;
    String userName;
    String name;
    String bio;
    String profilePic;
    String accountType;
    String visibilty;
}

