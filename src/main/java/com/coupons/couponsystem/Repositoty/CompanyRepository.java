package com.coupons.couponsystem.Repositoty;

import com.coupons.couponsystem.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {

//    boolean existsBy(String email,String password);

    Optional<Company> findByEmailAndPassword(String email, String Password);


    boolean existsByEmailAndPassword(String email,String password);


    boolean existsByEmail(String email);
    boolean existsByPassword(String password);

    Company findByName(String name);

    List<Company> getAllCompanies();



}
