package sistemalibreria.interfaces;

import sistemalibreria.DTO.UserCredentialsDTO;
import sistemalibreria.model.User;

import java.util.Optional;

public interface IAuthenticationService {

    public Optional<User> validateUser(UserCredentialsDTO credentials);
    public void registerNewUser(User newUser);
}
