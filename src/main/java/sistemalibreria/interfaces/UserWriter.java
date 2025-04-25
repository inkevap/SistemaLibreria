package sistemalibreria.interfaces;

import sistemalibreria.model.User;

public interface UserWriter {

    void addUser(User user);

    void removeUser(int serialId);

    void updateUser(User user);

//TODO Añadir metodo public void updateUser(String text) para que busque por otro parametro

    void updateUserPassword(int serialId, String newPassword);

    void updateUserEmail(int serialId, String newEmail);

}
