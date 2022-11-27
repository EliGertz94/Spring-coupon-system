package com.coupons.couponsystem.controller;

import com.coupons.couponsystem.DOT.LogInDOT;
import com.coupons.couponsystem.exception.CouponSystemException;
import com.coupons.couponsystem.model.Category;
import com.coupons.couponsystem.model.Company;
import com.coupons.couponsystem.model.Coupon;
import com.coupons.couponsystem.service.AdminService;
import com.coupons.couponsystem.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/company/")
public class CompanyController {


    @Autowired
    private AdminService adminService;
    @Autowired
    private CompanyService companyService;


    public CompanyController(AdminService adminService) {
        this.adminService = adminService;
    }


    @PostMapping("/login")
    public ResponseEntity<String> logIn(@RequestBody LogInDOT logInDOT){
        try{
            String messege =  companyService.logIn(logInDOT.getEmail(),logInDOT.getPassword())+" ";
            return new ResponseEntity<>(messege,HttpStatus.OK);
        }catch(CouponSystemException e) {
            throw new ResponseStatusException(e.getStatus(),e.getMessage(),e);
        }
    }

    @PostMapping("/boolean/")
    public String doesCompanyExisit(@RequestBody Company company){
        try{
            String messege =  adminService.logIn(company.getEmail(),company.getPassword())+" ";
            return messege;
        }catch(CouponSystemException e) {
            throw new ResponseStatusException(e.getStatus(),e.getMessage(),e);
        }
    }

    @PostMapping()
    public ResponseEntity<Company> addCompany(@RequestBody Company company){
        return new ResponseEntity<>(adminService.addCompany(company), HttpStatus.OK);
    }



    @PutMapping()
    public ResponseEntity<Company> updateCompany(@RequestBody Company company){
        return new ResponseEntity<>(adminService.updateCompany(company),HttpStatus.OK);
    }
    @PostMapping("/addcoupon/")
    public ResponseEntity<String> addCoupon(@RequestBody Coupon coupon){
        companyService.addCoupon(coupon);
            return new ResponseEntity<>("coupon was added",HttpStatus.OK);
    }

    @GetMapping("/companycoupons/")
    public List<Coupon> getComopanyCoupons(){

       List<Coupon> coupons=  companyService.getAllCompanyCoupons();
        for(Coupon coupon:coupons) {
            System.out.println(coupon.getTitle());
        }
        return coupons ;
    }

    @GetMapping("/companycoupons/{category}")
    public List<String> getComopanyCouponsByCategory(@PathVariable String category){

        Category categoryByNum = Category.valueOf(category);

        List<Coupon> coupons=  companyService.getAllCompanyCouponsByCategory(categoryByNum);
        List<String> couponsTitle=  new ArrayList<>();

        for(Coupon coupon:coupons) {
            couponsTitle.add(coupon.getTitle());
        }
        return couponsTitle ;
    }

}
