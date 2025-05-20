package sistemalibreria.service;

import sistemalibreria.DTO.UserCredentialsDTO;
import sistemalibreria.adapter.UserEntityAdapter;
import sistemalibreria.interfaces.IUserRepository;
import sistemalibreria.model.User;
import sistemalibreria.model.UserEntity;
import sistemalibreria.repository.MemoryUserRepository;
import sistemalibreria.util.BCryptUtils;

import java.util.Optional;

public class UserManagementService {
    IUserRepository userDataBase = new MemoryUserRepository();

    public void addUser(User newUser) {
        UserEntity newUserEntity = UserEntityAdapter.userToEntity(newUser);
        userDataBase.addUser(newUserEntity);
    }

    public Optional<User> validateUser(UserCredentialsDTO credentials) {
        User userLoginIn = null;
        if (!userDataBase.findUsersByText(credentials.getUsername()).isEmpty()) {
            userLoginIn = UserEntityAdapter.entityToUser(
                    userDataBase.findUsersByText(
                            credentials.getUsername()
                    ).getFirst());
            BCryptUtils.checkPassword(credentials.getPassword(), userLoginIn.getUserPassword());
            if (userLoginIn.getUserSerialId() != -1) {
                return Optional.of(userLoginIn);
            } else {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

    public Boolean updateUserEmail(User updatingUser, String email) {
        boolean isUpdated = false;
        UserEntity updatingUserEntity = UserEntityAdapter.userToEntity(updatingUser);
        if (userDataBase.findUserById(updatingUserEntity.getUserSerialId()).isPresent()) {
            updatingUserEntity.setUserEmail(email);
            userDataBase.updateUser(updatingUserEntity);
            isUpdated = true;
        }
        return isUpdated;
    }

    public Boolean updateUserUsername(User updatingUser, String username) {
        boolean isUpdated = false;
        UserEntity updatingUserEntity = UserEntityAdapter.userToEntity(updatingUser);
        if (userDataBase.findUserById(updatingUserEntity.getUserSerialId()).isPresent()) {
            updatingUserEntity.setUserName(username);
            userDataBase.updateUser(updatingUserEntity);
            isUpdated = true;
        }
        return isUpdated;
    }

    public Boolean updatePassword(User updatingUser, String password) {
        boolean isUpdated = false;
        UserEntity updatingUserEntity = UserEntityAdapter.userToEntity(updatingUser);
        if (userDataBase.findUserById(updatingUserEntity.getUserSerialId()).isPresent()) {
            updatingUserEntity.setUserPassword(password);
            userDataBase.updateUser(updatingUserEntity);
            isUpdated = true;
        }
        return isUpdated;
    }


    public Boolean updateUserPhoneNumber(User updatingUser, String phoneNumber) {
        boolean isUpdated = false;
        UserEntity updatingUserEntity = UserEntityAdapter.userToEntity(updatingUser);
        if (userDataBase.findUserById(updatingUserEntity.getUserSerialId()).isPresent()) {
            updatingUserEntity.setUserPhoneNumber(phoneNumber);
            userDataBase.updateUser(updatingUserEntity);
            isUpdated = true;
        }
        return isUpdated;
    }

    public Boolean updateUserAddress(User updatingUser, String address) {
        boolean isUpdated = false;
        UserEntity updatingUserEntity = UserEntityAdapter.userToEntity(updatingUser);
        if (userDataBase.findUserById(updatingUserEntity.getUserSerialId()).isPresent()) {
            updatingUserEntity.setUserAddress(address);
            userDataBase.updateUser(updatingUserEntity);
            isUpdated = true;
        }
        return isUpdated;
    }

}
