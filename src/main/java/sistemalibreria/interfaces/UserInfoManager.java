package sistemalibreria.interfaces;

public interface UserInfoManager {

    void deactivateUser(int serialId);

    void activateUser(int serialId);

    void updateUserPassword(int serialId, String newPassword);

    void updateUserEmail(int serialId, String newEmail);

}
