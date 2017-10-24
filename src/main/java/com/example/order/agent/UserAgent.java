package com.example.order.agent;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 10/24/17.
 */
@FeignClient(value = "user-service")
public interface UserAgent {

    @RequestMapping("/user/{userId}")
    String getUser(@PathVariable("userId") String userId);

}
