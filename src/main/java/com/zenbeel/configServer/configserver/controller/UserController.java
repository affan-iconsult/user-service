package com.zenbeel.configServer.configserver.controller;

import com.zenbeel.configServer.configserver.Implementation.CustomerServiceImpl;
import com.zenbeel.configServer.configserver.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
public class UserController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @GetMapping("/userInfo/{}")
    public String ping()
    {
        LOGGER.info("User-Service is running {}", LocalDateTime.now());
        return "Hello World";
    }

    @PostMapping("/signup")
    public Customer register(@RequestBody Customer customer)
    {
        return this.customerServiceImpl.register(customer);
    }

}
