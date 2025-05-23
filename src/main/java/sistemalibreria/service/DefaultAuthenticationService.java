package sistemalibreria.service;

import sistemalibreria.DTO.UserCredentialsDTO;
import sistemalibreria.adapter.UserEntityAdapter;
import sistemalibreria.config.AppConfig;
import sistemalibreria.interfaces.IAuthenticationService;
import sistemalibreria.interfaces.IPasswordEncryptor;
import sistemalibreria.interfaces.IUserRepository;
import sistemalibreria.model.User;
import sistemalibreria.model.UserEntity;

import java.util.Optional;

public class DefaultAuthenticationService implements IAuthenticationService {
    private final IUserRepository userDataBase;
    private final IPasswordEncryptor passwordEncryptor;

    public DefaultAuthenticationService(IUserRepository userDataBase, IPasswordEncryptor passwordEncryptor) {
        this.userDataBase = userDataBase;
        this.passwordEncryptor = passwordEncryptor;
    }


    public Optional<User> validateUser(UserCredentialsDTO credentials) {
        User userLoginIn = null;
        if (!userDataBase.findUsersByText(credentials.getUsername()).isEmpty()) {
            userLoginIn = UserEntityAdapter.entityToUser(
                    userDataBase.findUsersByText(
                            credentials.getUsername()
                    ).getFirst());
            passwordEncryptor.checkPassword(credentials.getPassword(), userLoginIn.getUserPassword());
            if (userLoginIn.getUserSerialId() != -1) {
                return Optional.of(userLoginIn);
            } else {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

    public void registerNewUser(User newUser) {
        UserEntity newUserEntity = UserEntityAdapter.userToEntity(newUser);
        userDataBase.addUser(newUserEntity);
    }

}
