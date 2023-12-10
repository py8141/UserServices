package com.example.CartOrderService.services;

import com.example.CartOrderService.dto.RequestDto;
import com.example.CartOrderService.dto.UserRequestDto;
import com.example.CartOrderService.dto.UserResponseDto;
import com.example.CartOrderService.entity.Requests;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.List;


public interface UserService {

Boolean addUser(String userId,UserRequestDto userRequestDto);
UserResponseDto getUserDetailsByUserId(String userId);
List<String> getListOfFollowingByUserId(String userId);
Boolean sendRequest(String senderUserId, RequestDto requestDto);
List<Requests> getReceviedRequests(String userId);
Boolean acceptRequest(String userId,Requests request);

}
