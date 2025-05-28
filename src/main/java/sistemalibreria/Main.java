package sistemalibreria;

import sistemalibreria.config.AppConfig;
import sistemalibreria.interfaces.*;
import sistemalibreria.service.AdminUserManagementService;
import sistemalibreria.service.CommandLineInterfazSystem;
import sistemalibreria.service.DefaultAuthenticationService;
import sistemalibreria.service.RegularUserManagementService;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {

        IUserRepository dataBaseUsers = AppConfig.userRepository();
        IUserService userManagementService = new RegularUserManagementService(dataBaseUsers);
        IAdminUserService adminUserManagementService = new AdminUserManagementService(dataBaseUsers);
        IPasswordEncryptor passwordEncryptor = AppConfig.passwordEncryptor();
        IAuthenticationService authService = new DefaultAuthenticationService(dataBaseUsers, passwordEncryptor);


        new CommandLineInterfazSystem(
                userManagementService, adminUserManagementService, authService
        ).innitCLI();
    }

}

