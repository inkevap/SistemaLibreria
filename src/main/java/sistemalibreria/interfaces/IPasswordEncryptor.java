package sistemalibreria.interfaces;

public interface IPasswordEncryptor {

    public String hashPassword(String plainTextPassword);
    public boolean checkPassword(String plainTextPassword, String HashedPassword);

}
