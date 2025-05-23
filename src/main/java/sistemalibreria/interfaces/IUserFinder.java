package sistemalibreria.interfaces;

import sistemalibreria.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserFinder {

    Optional<UserEntity> findUserById(int serialId);

    List<UserEntity> findUsersByText(String text);

    List<UserEntity> findAllUsers(); // Ideal para paginación futura

    List<UserEntity> findUsersByRole(String role);

    Optional<UserEntity> findUserByEmail(String email);

    boolean existsById(int serialId);

    boolean existsByEmail(String email);

}
