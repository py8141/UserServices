package com.example.CartOrderService.services.Impl;

import com.example.CartOrderService.dto.RequestDto;
import com.example.CartOrderService.dto.UserFeignDto;
import com.example.CartOrderService.dto.UserRequestDto;
import com.example.CartOrderService.dto.UserResponseDto;
import com.example.CartOrderService.entity.Requests;
import com.example.CartOrderService.entity.UserDetails;
import com.example.CartOrderService.feignClient.UserFeign;
import com.example.CartOrderService.repositry.UserRepositry;
import com.example.CartOrderService.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
    UserRepositry userRepositry;

   @Autowired
    UserFeign userFeign;
    @Override
    public Boolean addUser(String userId, UserRequestDto userRequestDto) {
        UserDetails userDetails = new UserDetails();

        Boolean existsByUserName = userRepositry.existsByUserName(userRequestDto.getUserName());
        if(existsByUserName){
            return false;
        }
       else{
            if(userRequestDto!=null){
                BeanUtils.copyProperties(userRequestDto,userDetails);
                userRepositry.save(userDetails);
                UserFeignDto userFeignDto = new UserFeignDto();
             BeanUtils.copyProperties(userDetails,userFeignDto);
                userFeign.sendUserDetailsSolar(userFeignDto);
                return true;
            }
            else
                return false;
        }

    }

    @Override
    public UserResponseDto getUserDetailsByUserId(String userId) {

        UserDetails userDetails = userRepositry.findById(userId).orElse(null);
        if(userDetails!=null){
            UserResponseDto userResponseDto = new UserResponseDto();
            BeanUtils.copyProperties(userDetails,userResponseDto);
            return userResponseDto;
        }
        return new UserResponseDto();
    }

    @Override
    public List<String> getListOfFollowingByUserId(String userId) {

        UserDetails userDetails = userRepositry.findById(userId).orElse(null);
        if(userDetails!=null){
            List<String> followers = userDetails.getFollowers();
            return followers;
        }
        return new ArrayList<>();
    }

    @Override
    public Boolean sendRequest(String senderUserId, RequestDto requestDto) {

        UserDetails senderDetails = userRepositry.findById(senderUserId).orElse(null);
          String  recevierUserId = requestDto.getUserId();
          Requests receviedRequest = new Requests();
          receviedRequest.setUserId(senderUserId);
          String senderUsername = senderDetails.getUserName();
          receviedRequest.setUserName(senderUsername);
          receviedRequest.setDate(requestDto.getDate());
          UserDetails recevierDetails = userRepositry.findById(recevierUserId).orElse(null);
          if(senderDetails!=null && recevierDetails!=null){
              Requests sendRequest = new Requests();
              BeanUtils.copyProperties(requestDto,sendRequest);
              if(senderDetails.getRequestsSent()==null){
                  List<Requests> requests = new ArrayList<>();
                  requests.add(sendRequest);
                  senderDetails.setRequestsSent(requests);
              }
              else{
                  senderDetails.getRequestsSent().add(sendRequest);
              }
              if(recevierDetails.getRequestsSent()==null){
                  List<Requests> requests = new ArrayList<>();
                  requests.add(receviedRequest);
                  recevierDetails.setRequestsReceived(requests);
              }
              else{
                  recevierDetails.getRequestsSent().add(receviedRequest);
              }
              userRepositry.save(senderDetails);
              userRepositry.save(recevierDetails);
              return true;
          }
        return false ;
        }

    @Override
    public List<Requests> getReceviedRequests(String userId) {

        UserDetails userDetails = userRepositry.findById(userId).orElse(null);
        if(userDetails!=null){
            List<Requests> requestDtos = userDetails.getRequestsReceived();
            return requestDtos;
        }
        return null;
    }

    @Override
    public Boolean acceptRequest(String userId, Requests request) {
        UserDetails userDetails = userRepositry.findById(userId).orElse(null);
        UserDetails userTobeadded = userRepositry.findById(request.getUserId()).orElse(null);
        Requests sendRequest = new Requests();
        sendRequest.setDate(request.getDate());
        sendRequest.setUserName(userDetails.getUserName());
        sendRequest.setUserId(userId);
        if(userDetails!=null && userTobeadded!=null){
                  if(userDetails.getFollowers()!=null)
                  userDetails.getFollowers().add(userTobeadded.getUserId());
                  else{
                      List<String> followers = new ArrayList<>();
                      followers.add(userTobeadded.getUserId());
                      userDetails.setFollowers(followers);
                  }
                  if(userTobeadded.getFollowers()!=null)
                  userTobeadded.getFollowing().add(userId);
                  else{
                      List<String> following = new ArrayList<>();
                      following.add(userId);
                      userTobeadded.setFollowing(following);
                  }
                 List<Requests> receviedRequests = userDetails.getRequestsReceived();
                  for(Requests requestsInFor : receviedRequests){
                    if(requestsInFor.getUserId().equals(request.getUserId())){
                        receviedRequests.remove(requestsInFor);
                        break;
                    }
                  }
            List<Requests> sentRequests = userTobeadded.getRequestsSent();
                  for(Requests requestsInFor : sentRequests){
                if(requestsInFor.getUserId().equals(sendRequest.getUserId())){
                    sentRequests.remove(requestsInFor);
                    break;
                    }
            }
                userDetails.setRequestsReceived(receviedRequests);
                userTobeadded.setRequestsSent(sentRequests);
                  userRepositry.save(userDetails);
                  userRepositry.save(userTobeadded);
                return true;
        }
       return  false;
    }

}
