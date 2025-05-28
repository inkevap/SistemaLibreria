package sistemalibreria.util;

import org.mindrot.jbcrypt.BCrypt;
import sistemalibreria.interfaces.IPasswordEncryptor;

public class BCryptEncryptor implements IPasswordEncryptor {


    // Hash de una contraseña en texto plano
    public String hashPassword(String plainTextPassword) {
        if (!isAlreadyHashed(plainTextPassword)) {
            return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
        }else{
            return plainTextPassword;
        }
    }

    // Verifica una contraseña contra el hash guardado
    public boolean checkPassword(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }

    private boolean isAlreadyHashed(String password) {
        return password != null &&
                password.matches("^\\$2[aby]\\$\\d{2}\\$[./A-Za-z0-9]{53}$");
    }
}
