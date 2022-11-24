package com.coupons.couponsystem.Repositoty;

import com.coupons.couponsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
