package com.coupons.couponsystem.model;


import lombok.Data;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@ToString(exclude = "customer")
@Table(name = "coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id",nullable = false)
    private Company company;
    private long categoryId;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int amount;
    private double price;
    private String image;

}
