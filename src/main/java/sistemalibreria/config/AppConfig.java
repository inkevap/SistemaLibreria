package sistemalibreria.config;

import sistemalibreria.interfaces.IUserRepository;
import sistemalibreria.interfaces.IPasswordEncryptor;
import sistemalibreria.repository.MemoryUserRepository;
import sistemalibreria.util.BCryptEncryptor;

public class AppConfig {
    private static IUserRepository userRepo = new MemoryUserRepository();
    private static IPasswordEncryptor passwordEncryptor = new BCryptEncryptor();

    public static IUserRepository userRepository(){
        return userRepo;
    }

    public static void setUserRepository(IUserRepository newUserRepo){
        userRepo = newUserRepo;
    }

    public static IPasswordEncryptor passwordEncryptor(){
        return passwordEncryptor;
    }

    public static void setPasswordEncryptor(IPasswordEncryptor newPasswordEncryptor){
        passwordEncryptor = newPasswordEncryptor;
    }
}
