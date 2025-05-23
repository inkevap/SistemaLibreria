package sistemalibreria;

import sistemalibreria.config.AppConfig;
import sistemalibreria.interfaces.IUserRepository;
import sistemalibreria.repository.MemoryUserRepository;
import sistemalibreria.service.RegularUserManagementService;

import static sistemalibreria.service.CommandLineInterfazSystem.innitCLI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        IUserRepository dataBaseUsers = AppConfig.userRepository();

        RegularUserManagementService userManagementService = new RegularUserManagementService(dataBaseUsers);

        innitCLI();
    }

}

