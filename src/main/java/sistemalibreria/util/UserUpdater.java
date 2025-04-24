package sistemalibreria.util;

import sistemalibreria.model.User;

public class UserUpdater {

    public static void updateUser(User outdatedUser, User updatedUser){

        if (updatedUser.getUserName().isBlank()){
            outdatedUser.setUserName(updatedUser.getUserName());
        }

        if (updatedUser.getUserEmail().isBlank()){
            outdatedUser.setUserEmail(updatedUser.getUserEmail());
        }

        if (updatedUser.getUserNickName().isBlank()){
            outdatedUser.setUserNickName(updatedUser.getUserNickName());
        }
        if (updatedUser.getUserPassword().isBlank()){
            outdatedUser.setUserPassword(updatedUser.getUserPassword());
        }

        if (updatedUser.getUserRole().isBlank()){
            outdatedUser.setUserRole(updatedUser.getUserRole());
        }

        if (updatedUser.getUserAddress().isBlank()){
            outdatedUser.setUserAddress(updatedUser.getUserAddress());
        }

        if (updatedUser.getUserPhoneNumber().isBlank()){
            outdatedUser.setUserPhoneNumber(updatedUser.getUserPhoneNumber());
        }

        if (updatedUser.getUserPersonalId().isBlank()){
            outdatedUser.setUserPersonalId(updatedUser.getUserPersonalId());
        }

        if (updatedUser.getUserStatus() != outdatedUser.getUserStatus()){
            outdatedUser.setUserStatus(updatedUser.getUserStatus());
        }


    }
}
