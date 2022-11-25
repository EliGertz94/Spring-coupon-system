package com.coupons.couponsystem.Repositoty;

import com.coupons.couponsystem.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon,Long> {

    boolean existsByEmailAndPassword(String email,String password);


}

