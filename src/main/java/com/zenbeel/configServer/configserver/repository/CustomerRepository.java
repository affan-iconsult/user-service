package com.zenbeel.configServer.configserver.repository;

import com.zenbeel.configServer.configserver.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{

}