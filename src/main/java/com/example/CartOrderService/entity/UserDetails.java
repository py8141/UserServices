package com.example.CartOrderService.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@Document(collection = "userDetails")
@ApiModel
public class UserDetails
{
    @Id
    @MongoId
    String userId;
    String userEmail;
    String userName;
    String name;
    String bio;
    String profilePicUrl;
    @ApiModelProperty
    UserAccountType accountType;
    @ApiModelProperty
    Visibilty visibilty;
    List<String> followers;
    List<String> following;
    List<String> interest;
    List<Requests> requestsSent;
    List<Requests> requestsReceived;

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