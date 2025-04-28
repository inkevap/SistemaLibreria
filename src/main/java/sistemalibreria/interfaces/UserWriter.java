package sistemalibreria.interfaces;

import sistemalibreria.model.UserEntity;

public interface UserWriter {

    void addUser(UserEntity userEntity);

    void removeUser(int serialId);

    void updateUser(UserEntity userEntity);

//TODO Añadir metodo public void updateUser(String text) para que busque por otro parametro

}
