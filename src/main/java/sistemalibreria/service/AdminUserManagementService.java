package sistemalibreria.service;

import sistemalibreria.abstracts.AbstractUserService;
import sistemalibreria.adapter.UserEntityAdapter;
import sistemalibreria.interfaces.IAdminUserService;
import sistemalibreria.interfaces.IUserRepository;
import sistemalibreria.model.User;
import sistemalibreria.model.UserEntity;
import sistemalibreria.model.UserRole;

public class AdminUserManagementService extends AbstractUserService implements IAdminUserService {

    IUserRepository userDataBase;

    public AdminUserManagementService(IUserRepository userDataBase) {
        super(userDataBase);
        this.userDataBase = userDataBase;
    }

    @Override
    public Boolean updateUserRole(User updatingUser, UserRole newRole) {
        boolean isUpdated = false;
        UserEntity updatingUserEntity = UserEntityAdapter.userToEntity(updatingUser);
        if (userDataBase.existsById(updatingUserEntity.getUserSerialId())) {
            updatingUserEntity.setUserRole(newRole);
            userDataBase.updateUser(updatingUserEntity);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public Boolean updateUserPersonalID(User updatingUser, String newPersonalID) {
        boolean isUpdated = false;
        UserEntity updatingUserEntity = UserEntityAdapter.userToEntity(updatingUser);
        if (userDataBase.existsById(updatingUserEntity.getUserSerialId())) {
            updatingUserEntity.setUserPersonalId(newPersonalID);
            userDataBase.updateUser(updatingUserEntity);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public Boolean updateUserStatus(User updatingUser, Boolean newUserStatus) {
        boolean isUpdated = false;
        UserEntity updatingUserEntity = UserEntityAdapter.userToEntity(updatingUser);
        if (userDataBase.existsById(updatingUserEntity.getUserSerialId())) {
            updatingUserEntity.setUserStatus(newUserStatus);
            userDataBase.updateUser(updatingUserEntity);
            isUpdated = true;
        }
        return isUpdated;
    }
}
