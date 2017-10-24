package com.example.order.agent;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 10/24/17.
 */
@FeignClient(name = "product-service")
public interface ProductAgent {
    @RequestMapping("/product/{productId}")
    public String getProduct(@PathVariable("productId") String productId);
}
