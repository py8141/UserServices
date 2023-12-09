package com.example.CartOrderService.controller;

import com.example.CartOrderService.dto.RequestDto;
import com.example.CartOrderService.dto.UserRequestDto;
import com.example.CartOrderService.dto.UserResponseDto;
import com.example.CartOrderService.entity.Requests;
import com.example.CartOrderService.entity.UserDetails;
import com.example.CartOrderService.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

  @Autowired
    UserService userService;

  @GetMapping("/getUserDetails")
  ResponseEntity<UserResponseDto> getUserDetails(@RequestParam String userId){

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto = userService.getUserDetailsByUserId(userId);
        if(userResponseDto!=null)
            return new ResponseEntity<>(userResponseDto,HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(userResponseDto,HttpStatus.BAD_REQUEST);
  }

  @PostMapping("/addUserDetails")
  ResponseEntity<Boolean> addUserDetails(@RequestBody UserRequestDto userRequestDto){

      Boolean isAdded = userService.addUser(userRequestDto);

      if(isAdded)
          return new ResponseEntity<>(true,HttpStatus.ACCEPTED);
      else
          return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
  }

  @GetMapping("/getUserFollowers")
    ResponseEntity<List<String >> getUserFollowers(@RequestParam String userId){

      List<String> followerList = new ArrayList<>();
      followerList = userService.getListOfFollowingByUserId(userId);
       if(!followerList.isEmpty()){
           return new ResponseEntity<>(followerList,HttpStatus.ACCEPTED);
       }
       else
           return new ResponseEntity<>(followerList,HttpStatus.BAD_REQUEST);
  }


   @PostMapping("/sendRequest")
    ResponseEntity<Boolean> sendRequest (@RequestParam String userId, @RequestBody RequestDto requestDto){

        Boolean isSent = userService.sendRequest(userId,requestDto);

        if(isSent)
            return new ResponseEntity<>(true,HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
   }

   @GetMapping("/getRequests")
    ResponseEntity<List<Requests>> getRequestsList(@RequestParam String userId){

      List<Requests> requestsList = userService.getReceviedRequests(userId);

      if(requestsList!=null)
          return new ResponseEntity<>(requestsList,HttpStatus.ACCEPTED);
      else
          return new ResponseEntity<>(requestsList,HttpStatus.BAD_REQUEST);

   }

    @GetMapping("/acceptRequest")
    ResponseEntity<Boolean> acceptRequest(@RequestParam String userId, @RequestBody Requests requests){

         Boolean isAccepted = userService.acceptRequest(userId,requests);
         if(isAccepted)
             return  new ResponseEntity<>(true,HttpStatus.ACCEPTED);
         else
             return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }

}
