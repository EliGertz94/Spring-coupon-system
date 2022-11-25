package com.coupons.couponsystem.controller;

import com.coupons.couponsystem.exception.CouponSystemException;
import com.coupons.couponsystem.model.Company;
import com.coupons.couponsystem.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("api/company/")
public class CompanyController {


    private AdminService adminService;

    public CompanyController(AdminService adminService) {
        this.adminService = adminService;
    }


    @PostMapping("/boolean/")
    public String doesCompanyExisit(@RequestBody Company company){
        try{
            String messege =  adminService.doesCompanyExist(company.getEmail(),company.getPassword())+" ";
            return messege;
        }catch(CouponSystemException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e);
        }
    }

    @PostMapping()
    public ResponseEntity<Company> createPost(@RequestBody Company company){
        return new ResponseEntity<>(adminService.addCompany(company), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company, @PathVariable long id){
        return new ResponseEntity<>(adminService.updateCompany(company, id),HttpStatus.OK);
    }

}
