package interfaces;

import model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    public void addUser(User user);

    public Optional<User> findUserById(int serialId);

    public Optional<User> findUserByText(String text);

    public void removeUser(int serialId);

    public void updateUser(User user);

    /* Nuevas funciones
    List<User> findAllUsers(); // Ideal para paginación futura

    List<User> findUsersByRole(String role);

    Optional<User> findUserByEmail(String email);

    boolean existsById(int id);

    boolean existsByEmail(String email);

    void deactivateUser(int id);

    void activateUser(int id);

    long countUsers();

    List<User> searchUsers(String keyword);

    void updateUserPassword(int id, String newPassword);

    void updateUserEmail(int id, String newEmail);

    int getLastInsertedUserId();
    */

}
