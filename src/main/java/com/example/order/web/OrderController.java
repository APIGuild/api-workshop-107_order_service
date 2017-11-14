package com.example.order.web;

import com.example.order.agent.ProductAgent;
import com.example.order.agent.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 10/24/17.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserAgent userAgent;

    @Autowired
    private ProductAgent productAgent;

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public String getOrder(@PathVariable("orderId") String orderId) {
        //String user = userAgent.getUser("UserA");
        String product = productAgent.getProduct("productA");
        return "This is simple order " + " " + product;
    }
}
