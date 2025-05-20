package sistemalibreria.adapter;

import sistemalibreria.model.User;
import sistemalibreria.model.UserEntity;

public class UserEntityAdapter {

    public static User entityToUser(UserEntity userEntity){
          return new User(
                  userEntity.getUserName(),
                  userEntity.getUserEmail(),
                  userEntity.getUserNickName(),
                  userEntity.getUserPassword(),
                  userEntity.getUserAddress(),
                  userEntity.getUserPhoneNumber(),
                  userEntity.getUserPersonalId(),
                  userEntity.getUserSerialId()
          );
    }

    public static UserEntity userToEntity(User user){
        return new UserEntity(
                user.getUserName(),
                user.getUserEmail(),
                user.getUserNickName(),
                user.getUserPassword(),
                user.getUserAddress(),
                user.getUserPhoneNumber(),
                user.getUserPersonalId()
        );
    }
}
