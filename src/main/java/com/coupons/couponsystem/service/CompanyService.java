package com.coupons.couponsystem.service;

import com.coupons.couponsystem.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CompanyService {

 //   boolean existsBy(String email,String password) throws Exception;

    public boolean doesCompanyExist(String email,String password);

    Company addCompany(Company company);

    Company updateCompany(Company company,long id);

    void deleteCompany(long id);

    List<Company> getAllCompanies();

    Company getOneCompany(long id);

}
