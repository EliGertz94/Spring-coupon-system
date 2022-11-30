package com.coupons.couponsystem.service.impl;

import com.coupons.couponsystem.Repositoty.CompanyRepository;
import com.coupons.couponsystem.Repositoty.CouponRepository;
import com.coupons.couponsystem.Repositoty.CustomerRepository;

public abstract class ClientFacade {

        protected CompanyRepository companyRepository;

        protected CustomerRepository customerRepository;

        protected CouponRepository couponRepository;


    public ClientFacade(CompanyRepository companyRepository, CustomerRepository customerRepository, CouponRepository couponRepository) {
        this.companyRepository = companyRepository;
        this.customerRepository = customerRepository;
        this.couponRepository = couponRepository;
    }

    public abstract boolean logIn(String email, String password);
}
