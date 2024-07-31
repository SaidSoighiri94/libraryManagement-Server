package com.soighiri.libraryAp.customer;

import com.soighiri.libraryAp.loan.LoanEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = true, nullable = false, updatable = true)
    private Long customerId;

    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;
    private String job;
    private Date customerBirthDate;

    @Temporal(TemporalType.DATE)
    private Date customerCreationDate;

    @OneToMany(mappedBy = "customer")
    private List<LoanEntity> loanEntities;
}
