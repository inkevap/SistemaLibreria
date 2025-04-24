package interfaces;

import model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    public void addUser(User user);

    public Optional<User> findUserById(int serialId);

    public List<User> findUsersByText(String text);

    public void removeUser(int serialId);

    public void updateUser(User user);

    public List<User> findAllUsers(); // Ideal para paginación futura

    public List<User> findUsersByRole(String role);

    public Optional<User> findUserByEmail(String email);

    public boolean existsById(int  serialId);

    public boolean existsByEmail(String email);

    public void deactivateUser(int serialId);

    public void activateUser(int  serialId);

    public long countUsers();

    public void updateUserPassword(int  serialId, String newPassword);

    public void updateUserEmail(int  serialId, String newEmail);

    public int getLastInsertedUserId();


}
