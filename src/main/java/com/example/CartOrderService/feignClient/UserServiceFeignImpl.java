package com.example.CartOrderService.feignClient;

import com.example.CartOrderService.dto.UserFeignDto;
import feign.hystrix.FallbackFactory;

public class UserServiceFeignImpl implements FallbackFactory<UserFeign> {
    @Override
    public UserFeign create(Throwable throwable) {
        return new UserFeign() {
            @Override
            public void sendUserDetailsSolar(UserFeignDto userFeignDto) {
                return ;
            }
        };
    }
}
