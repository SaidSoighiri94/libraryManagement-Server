package com.soighiri.libraryAp.customer;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data

public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = true, nullable = false, updatable = true)
    private Long customerId;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String job;
    private Date birthDate;
    private Date creationDate;
}
