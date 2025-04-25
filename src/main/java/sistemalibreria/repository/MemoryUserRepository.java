package sistemalibreria.repository;

import sistemalibreria.interfaces.IUserRepository;
import sistemalibreria.model.User;
import sistemalibreria.util.UserUpdater;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryUserRepository implements IUserRepository {
    private final List<User> users;

    public MemoryUserRepository() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        if(!users.contains(user)) {
            users.add(user);
        }
    }

    public Optional<User> findUserById(int serialId) {
        return users.stream().filter(actualUser -> actualUser.getUserSerialId() == serialId).findFirst();
    }

    public List<User> findUsersByText(String text) {
        String loweredText = text.toLowerCase();
        return users.stream().filter(actualUser ->
                actualUser.getUserPersonalId().toLowerCase().contains(loweredText) ||
                actualUser.getUserAddress().toLowerCase().contains(loweredText) ||
                actualUser.getUserRole().toLowerCase().contains(loweredText) ||
                actualUser.getUserEmail().toLowerCase().contains(loweredText) ||
                actualUser.getUserNickName().toLowerCase().contains(loweredText) ||
                actualUser.getUserPhoneNumber().toLowerCase().contains(loweredText) ||
                actualUser.getUserName().toLowerCase().contains(loweredText))
                .collect(Collectors.toList());
    }

    public void removeUser(int serialId) {
        findUserById(serialId).ifPresent(users::remove);
    }

    public void updateUser(User user) {
        if (findUserById(user.getUserSerialId()).isPresent()) {
            int index = users.indexOf(findUserById(user.getUserSerialId()).get());
            UserUpdater.updateUser(users.get(index), user); //reemplaza la informacion del objeto sin cambiar referencia
            //user.set(index,user); // reemplaza la referencia
        }
    }

    //TODO Implementar metodo public void updateUser(String text) para que reemplace por otro parametro

    public List<User> findAllUsers() {
        return users;
    }

    public List<User> findUsersByRole(String role) {
        return users.stream().filter(actualUser -> actualUser.getUserRole().equals(role)).collect(Collectors.toList());
    }

    public Optional<User> findUserByEmail(String email) {
        return users.stream().filter(actualUser -> actualUser.getUserEmail().equalsIgnoreCase(email)).findFirst();
    }

    public boolean existsById(int serialId) {
        return users.stream().anyMatch(actualUser -> actualUser.getUserSerialId() == serialId);
    }

    public boolean existsByEmail(String email) {
        return users.stream().anyMatch(actualUser -> actualUser.getUserEmail().equalsIgnoreCase(email));
    }

    public void updateUserPassword(int serialId, String newPassword) {
        findUserById(serialId).ifPresent(user -> user.setUserPassword(newPassword));
    }

    public void updateUserEmail(int serialId, String newEmail) {
        findUserById(serialId).ifPresent(user -> user.setUserEmail(newEmail));
    }

    /* metodos que no corresponden a esta clase
    public int getLastInsertedUserId() {
        return users.getLast().getUserSerialId();
    }


    public void deactivateUser(int serialId) {
        if (findUserById(serialId).isPresent()) {
            findUserById(serialId).get().setUserStatus(false);
        }
    }

    public void activateUser(int serialId) {
        if (findUserById(serialId).isPresent()) {
            findUserById(serialId).get().setUserStatus(true);
        }
    }

    public long countUsers() {
        return users.size();
    }
    */
}
