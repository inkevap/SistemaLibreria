package sistemalibreria.service;

import sistemalibreria.adapter.UserEntityAdapter;
import sistemalibreria.interfaces.IUserRepository;
import sistemalibreria.model.User;
import sistemalibreria.model.UserEntity;

public class RegularUserManagementService {
    private final IUserRepository userDataBase;

    public RegularUserManagementService(IUserRepository userDataBase) {
        this.userDataBase = userDataBase;
    }

    public Boolean updateUserEmail(User updatingUser, String email) {
        boolean isUpdated = false;
        UserEntity updatingUserEntity = UserEntityAdapter.userToEntity(updatingUser);
        if (userDataBase.existsById(updatingUserEntity.getUserSerialId())) {
            updatingUserEntity.setUserEmail(email);
            userDataBase.updateUser(updatingUserEntity);
            isUpdated = true;
        }
        return isUpdated;
    }

    public Boolean updateUserUsername(User updatingUser, String username) {
        boolean isUpdated = false;
        UserEntity updatingUserEntity = UserEntityAdapter.userToEntity(updatingUser);
        if (userDataBase.existsById(updatingUserEntity.getUserSerialId())) {
            updatingUserEntity.setUserName(username);
            userDataBase.updateUser(updatingUserEntity);
            isUpdated = true;
        }
        return isUpdated;
    }

    public Boolean updatePassword(User updatingUser, String password) {
        boolean isUpdated = false;
        UserEntity updatingUserEntity = UserEntityAdapter.userToEntity(updatingUser);
        if (userDataBase.existsById(updatingUserEntity.getUserSerialId())) {
            updatingUserEntity.setUserPassword(password);
            userDataBase.updateUser(updatingUserEntity);
            isUpdated = true;
        }
        return isUpdated;
    }


    public Boolean updateUserPhoneNumber(User updatingUser, String phoneNumber) {
        boolean isUpdated = false;
        UserEntity updatingUserEntity = UserEntityAdapter.userToEntity(updatingUser);
        if (userDataBase.existsById(updatingUserEntity.getUserSerialId())) {
            updatingUserEntity.setUserPhoneNumber(phoneNumber);
            userDataBase.updateUser(updatingUserEntity);
            isUpdated = true;
        }
        return isUpdated;
    }

    public Boolean updateUserAddress(User updatingUser, String address) {
        boolean isUpdated = false;
        UserEntity updatingUserEntity = UserEntityAdapter.userToEntity(updatingUser);
        if (userDataBase.existsById(updatingUserEntity.getUserSerialId())) {
            updatingUserEntity.setUserAddress(address);
            userDataBase.updateUser(updatingUserEntity);
            isUpdated = true;
        }
        return isUpdated;
    }

    public Boolean deleteUser(User deletingUser) {
        UserEntity deletingUserEntity = UserEntityAdapter.userToEntity(deletingUser);
        if (userDataBase.existsById(deletingUserEntity.getUserSerialId())) {
            userDataBase.removeUser(deletingUserEntity.getUserSerialId());
        }
        return !userDataBase.existsById(deletingUserEntity.getUserSerialId());
    }

}
