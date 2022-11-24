package com.coupons.couponsystem.controller;

import com.coupons.couponsystem.model.Company;
import com.coupons.couponsystem.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//@Trunsuctional delete update
@RestController
@RequestMapping("api/company/")
public class CompanyController {


    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @PostMapping("/boolean/")
    public ResponseEntity<String> doesCompanyExisit(@RequestBody Company company){
        return new ResponseEntity<>(" "+companyService.doesCompanyExist(company.getEmail(),company.getPassword()),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Company> createPost(@RequestBody Company company){
        return new ResponseEntity<>(companyService.addCompany(company), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company, @PathVariable long id){
        return new ResponseEntity<>(companyService.updateCompany(company, id),HttpStatus.OK);
    }

}
