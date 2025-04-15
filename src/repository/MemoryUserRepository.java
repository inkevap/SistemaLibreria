package repository;

import interfaces.IUserRepository;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryUserRepository implements IUserRepository {
    private final List<User> users;

    public MemoryUserRepository() {
        users = new ArrayList<User>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Optional<User> findUserById(int serialId) {
        return users.stream().filter(
                        actualUser ->
                                actualUser.getUserSerialId() == serialId)
                .findFirst();
    }

    public Optional<User> findUserByText(String text) {
        return users.stream().filter(
                        actualUser ->
                                actualUser.getUserPersonalId().equals(text) ||
                                        actualUser.getUserAddress().equals(text) ||
                                        actualUser.getUserPhoneNumber().equals(text) ||
                                        actualUser.getUserSerialId() == Integer.parseInt(text) ||
                                        actualUser.getUserName().equals(text)
                )
                .findFirst();
    }

    public void removeUser(int serialId) {
        findUserById(serialId).ifPresent(users::remove);
    }

    public void updateUser(User user) {
    }
}
