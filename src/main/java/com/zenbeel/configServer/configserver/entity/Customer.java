package com.zenbeel.configServer.configserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;
    private String emailAddress;
    private String mobileNumber;
    private String cnic;
    private String dateOfBirth;
    private String language;
    private String productType;
    private String firstName;
    private String middleName;
    private String nationality;
    private String lastName;
    private String gender;
    private String address;
    private String country;
    private Boolean isEnable;

}
