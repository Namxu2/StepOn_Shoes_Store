package com.vn.datn.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_code", length = 255)
    private String customerCode;

    @Column(name = "full_name", length = 50)
    private String fullName;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "city", length = 255)
    private String city;

    @Column(name = "district", length = 255)
    private String district;

    @Column(name = "village", length = 255)
    private String village;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "deleted")
    private Boolean deleted;

}
