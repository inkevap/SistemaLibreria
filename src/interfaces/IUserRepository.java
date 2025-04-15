package interfaces;

import model.User;

import java.util.Optional;

public interface IUserRepository {

    public void addUser(User user);

    public Optional<User> findUserById(int serialId);

    public Optional<User> findUserByText(String text);

    public void removeUser(int serialId);

    public void updateUser(User user);


}
