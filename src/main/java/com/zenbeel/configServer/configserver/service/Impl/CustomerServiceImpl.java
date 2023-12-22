package com.zenbeel.configServer.configserver.service.Impl;

import com.zenbeel.configServer.configserver.FeignClients.CustomerWalletClient;
import com.zenbeel.configServer.configserver.controller.UserController;
import com.zenbeel.configServer.configserver.model.entity.Customer;
import com.zenbeel.configServer.configserver.repository.CustomerRepository;
import com.zenbeel.configServer.configserver.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerWalletClient customerWalletClient;

    @Override
    public Customer addUser(Customer customer)
    {
        return save(customer);
    }

    @Override
    public Customer register(Customer customer)
    {
        LOGGER.info("Sign up Request recvived");
        if(customer != null)
        {
            this.customerWalletClient.register(customer);
            Customer customer1 = addUser(customer);
            LOGGER.info("Customer has been saved with Id {}", customer1.getId());
            return new ResponseEntity<>(customer, HttpStatus.OK).getBody();
        }
        else
        {
            LOGGER.error("Entity not found");
        }
        return customer;
    }

    @Override
    public void deleteUser(Long id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public Customer updateUser(Customer customer) {
        return this.customerRepository.save(customer);
    }

    public Customer save(Customer customer)
    {
        return customerRepository.save(customer);
    }
}
