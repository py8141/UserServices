package com.example.CartOrderService.config;


import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
@EnableCaching
public class config {



    @Bean
    public CacheManager cacheManager(){

        ConcurrentMapCacheManager mgr = new ConcurrentMapCacheManager();

        ArrayList<String > as = new ArrayList<>();

        as.add("employees");
        mgr.setCacheNames(as);

        return mgr;

    }

}
