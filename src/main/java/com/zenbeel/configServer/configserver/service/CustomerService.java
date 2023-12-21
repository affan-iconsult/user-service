package com.zenbeel.configServer.configserver.service;

import com.zenbeel.configServer.configserver.entity.Customer;

public interface CustomerService
{
    Customer addUser(Customer customer);

    Customer register(Customer customer);

    void deleteUser(Long id);

    Customer updateUser(Customer customer);
}
