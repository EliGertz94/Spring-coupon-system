package ClientLogIn;

import com.coupons.couponsystem.exception.CouponSystemException;
import com.coupons.couponsystem.service.AdminService;
import com.coupons.couponsystem.service.impl.ClientFacade;
import org.springframework.stereotype.Component;

@Component
public class LoginManager {

    static  LoginManager instance=  new LoginManager();
    private LoginManager(){}

    public static LoginManager getInstance(){return instance;}

    public ClientFacade logIn(String email, String password, ClientType clientType) throws CouponSystemException {

        switch (clientType) {
            case Administrator:
                AdminService adminFacade= new AdminService();
                if(adminFacade.logIn(email,password)){
                    return adminFacade;
                }

                break;
            case Company:
                CompanyFacade companyFacade = new CompanyFacade();
                //  AdminFacade adminFacade1 = new AdminFacade();
                if(companyFacade.logIn(email,password))
                {
                    // if(adminFacade1.getOneCompany(companyFacade.getCompanyId()).getEmail()!= null){
                    return companyFacade;
                    //   }
                }

                break;
            case Customer:
                CustomerFacade customerFacade= new CustomerFacade();
                if(customerFacade.logIn(email,password)){
                    return customerFacade;
                }
                break;
        }
        return null;
    }
}




