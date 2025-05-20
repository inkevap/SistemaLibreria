package sistemalibreria.util;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptUtils {

    // Hash de una contraseña en texto plano
    public static String hashPassword(String plainTextPassword) {
        if (!isAlreadyHashed(plainTextPassword)) {
            return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
        }else{
            return plainTextPassword;
        }
    }

    // Verifica una contraseña contra el hash guardado
    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }

    private static boolean isAlreadyHashed(String password) {
        return password != null &&
                password.matches("^\\$2[aby]\\$\\d{2}\\$[./A-Za-z0-9]{53}$");
    }
}
