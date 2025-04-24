package sistemalibreria.interfaces;

import sistemalibreria.model.User;

import java.util.List;
import java.util.Optional;

public interface UserFinder {

    Optional<User> findUserById(int serialId);

    List<User> findUsersByText(String text);

    List<User> findAllUsers(); // Ideal para paginación futura

    List<User> findUsersByRole(String role);

    Optional<User> findUserByEmail(String email);

    boolean existsById(int serialId);

    boolean existsByEmail(String email);

}
