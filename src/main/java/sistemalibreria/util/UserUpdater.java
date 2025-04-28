package sistemalibreria.util;

import sistemalibreria.model.UserEntity;

public class UserUpdater {

    public static void updateUser(UserEntity outdatedUserEntity, UserEntity updatedUserEntity) {

        if (!updatedUserEntity.getUserName().isBlank()) {
            outdatedUserEntity.setUserName(updatedUserEntity.getUserName());
        }

        if (!updatedUserEntity.getUserEmail().isBlank()) {
            outdatedUserEntity.setUserEmail(updatedUserEntity.getUserEmail());
        }

        if (!updatedUserEntity.getUserNickName().isBlank()) {
            outdatedUserEntity.setUserNickName(updatedUserEntity.getUserNickName());
        }
        if (!updatedUserEntity.getUserPassword().isBlank()) {
            outdatedUserEntity.setUserPassword(updatedUserEntity.getUserPassword());
        }

        if (!updatedUserEntity.getUserRole().isBlank()) {
            outdatedUserEntity.setUserRole(updatedUserEntity.getUserRole());
        }

        if (!updatedUserEntity.getUserAddress().isBlank()) {
            outdatedUserEntity.setUserAddress(updatedUserEntity.getUserAddress());
        }

        if (!updatedUserEntity.getUserPhoneNumber().isBlank()) {
            outdatedUserEntity.setUserPhoneNumber(updatedUserEntity.getUserPhoneNumber());
        }

        if (!updatedUserEntity.getUserPersonalId().isBlank()) {
            outdatedUserEntity.setUserPersonalId(updatedUserEntity.getUserPersonalId());
        }

        if (updatedUserEntity.getUserStatus() != outdatedUserEntity.getUserStatus()) {
            outdatedUserEntity.setUserStatus(updatedUserEntity.getUserStatus());
        }


    }
}
