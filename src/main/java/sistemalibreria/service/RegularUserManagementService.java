package sistemalibreria.service;

import sistemalibreria.abstracts.AbstractUserService;
import sistemalibreria.adapter.UserEntityAdapter;
import sistemalibreria.interfaces.IUserRepository;
import sistemalibreria.model.User;
import sistemalibreria.model.UserEntity;

public class RegularUserManagementService extends AbstractUserService {
    IUserRepository userDataBase;

    public RegularUserManagementService(IUserRepository userDataBase) {
        super(userDataBase);
        this.userDataBase = userDataBase;
    }
}
