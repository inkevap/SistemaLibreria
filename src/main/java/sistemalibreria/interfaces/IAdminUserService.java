package sistemalibreria.interfaces;

import sistemalibreria.model.User;
import sistemalibreria.model.UserRole;

public interface IAdminUserService extends IUserService {

    public Boolean updateUserRole(User updatingUser, UserRole newRole);

    public Boolean updateUserPersonalID(User updatingUser, String newPersonalID);

    public Boolean updateUserStatus(User updatingUser, Boolean newUserStatus);



}
