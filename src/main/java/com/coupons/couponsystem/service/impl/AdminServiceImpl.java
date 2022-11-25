package com.coupons.couponsystem.service.impl;

import com.coupons.couponsystem.Repositoty.CompanyRepository;
import com.coupons.couponsystem.exception.CouponSystemException;
import com.coupons.couponsystem.exception.ResourceNotFound;
import com.coupons.couponsystem.model.Company;
import com.coupons.couponsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public boolean doesCompanyExist(String email,String password){

               return  companyRepository.existsByEmail(email)
                       && companyRepository.existsByPassword(password);

    }

    @Override
    public Company addCompany(Company company) {
        if(!companyRepository.existsByEmail(company.getEmail())) {
            if (!companyRepository.existsByPassword(company.getPassword())) {
                Company newCompany = companyRepository.save(company);
                return newCompany;
            }
            throw new CouponSystemException(HttpStatus.BAD_REQUEST,"addCompany error password exists already");

        }

        throw new CouponSystemException(HttpStatus.BAD_REQUEST,"addCompany error email  exists already");

    }


    //if the name is the same should I have a set name ?
        @Override
        public Company updateCompany(Company company,long id) {

          Company company1 = companyRepository.findById(id).orElseThrow(
                  ()->new CouponSystemException(HttpStatus.NOT_FOUND,"existsBy error at CompanyServiceImpl "));

                return companyRepository.findById(id).map(companyEntity -> {
                            companyEntity.setEmail(company.getEmail());
                            companyEntity.setPassword(company.getPassword());

                            return companyEntity;
                        }
                ).orElseThrow(() -> new ResourceNotFound("updateCompany", "company id", id));
          
            }

        public void deleteCompany(long id)
        {
            Company company = companyRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFound("deleteCompany", "company id", id));

            companyRepository.delete(company);

        }

        @Override
        public List<Company> getAllCompanies(){
          return companyRepository.findAll();
        }

        @Override
        public Company getOneCompany(long id) {
          return  companyRepository.findById(id).orElseThrow
                  (() -> new ResourceNotFound("getOneCompany", "company id", id));
        }


//
//    @Override
//    public boolean existsBy(String email, String password) throws Exception {
//        Company company = companyRepository.findByEmailAndPassword(email,password)
//                .orElseThrow(()-> new CouponSystemException(HttpStatus.NOT_FOUND,"existsBy error at CompanyServiceImpl "));
//        System.out.println(company);
//        if(company!=null){
//            return true;
//        }
//        return false;
//    }
}
