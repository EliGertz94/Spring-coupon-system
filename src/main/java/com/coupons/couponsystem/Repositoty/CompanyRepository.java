package com.coupons.couponsystem.Repositoty;
import com.coupons.couponsystem.model.Company;
import com.coupons.couponsystem.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {

//    boolean existsBy(String email,String password);

    Optional<Company> findByEmailAndPassword(String email, String Password);

    boolean existsByEmailAndPassword(String email,String password);


    boolean existsByEmail(String email);
    boolean existsByPassword(String password);

    Company findByName(String name);



//
//    Company companyByLogin(String email, String password);
//
//    int addCompany(Company company);
//
//    void updateCompany(Company company);
//
//    void deleteCompany(int companyId);
//
//    void deleteFromCoupons(int companyId);
//
//    void deleteFromCVC(int companyId);
//
//    boolean getCompanyByName(String companyName);
//
//    ArrayList<Company> getAllCompanies();
//
//    Company getOneCompany(int companyId);
//
//    boolean getCompanyByEmail(String companyEmail);
//
//    ArrayList<Coupon> getAllCompanyCoupons(int companyId);
//

}
