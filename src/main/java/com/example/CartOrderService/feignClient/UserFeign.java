package com.example.CartOrderService.feignClient;


import com.example.CartOrderService.dto.UserFeignDto;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@FeignClient(value = "users",url = "http://10.20.3.151:9000",fallbackFactory = UserServiceFeignImpl.class)
@EnableFeignClients
public interface UserFeign   {

    @RequestMapping(method = RequestMethod.POST,value = "insta/addprofile")
   public void sendUserDetailsSolar( UserFeignDto userFeignDto);
}
