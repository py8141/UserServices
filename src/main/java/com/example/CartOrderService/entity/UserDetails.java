package com.example.CartOrderService.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
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
    @Indexed(unique = true)
    String userName;
    String name;
    String bio;
    String profilePicUrl;

    String accountType;
    String  visibilty;

    List<String> followers = new ArrayList<>();
    List<String> following = new ArrayList<>();
    List<String> interest = new ArrayList<>();
    List<Requests> requestsSent = new ArrayList<>();
    List<Requests> requestsReceived = new ArrayList<>();

}
