package sistemalibreria.interfaces;

import sistemalibreria.model.User;

public interface IUserService {

    public Boolean updateUserEmail(User updatingUser, String email);

    public Boolean updateUserNickname(User updatingUser, String username);

    public Boolean updatePassword(User updatingUser, String password);

    public Boolean updateUserPhoneNumber(User updatingUser, String phoneNumber);

    public Boolean updateUserAddress(User updatingUser, String address);

    public Boolean deleteUser(User deletingUser);


}
