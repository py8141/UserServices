package com.example.CartOrderService.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UserRequestDto {
    String userId;
    String userName;
    String name;
    String bio;
    String profilePic;
    @ApiModelProperty
    UserAccountType accountType;
    @ApiModelProperty
    Visibilty visibilty;
}
@ApiModel
enum UserAccountType{
    BUSINESS,
    NORMAL
}
@ApiModel
enum Visibilty{
    PRIVATE,
    PUBLIC
}
