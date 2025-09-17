package sistemalibreria.repository;

import sistemalibreria.interfaces.IUserRepository;
import sistemalibreria.model.User;
import sistemalibreria.model.UserEntity;
import sistemalibreria.model.UserRole;
import sistemalibreria.util.UserUpdater;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryUserRepository implements IUserRepository {
    private final List<UserEntity> userEntities;

    public MemoryUserRepository() {
        userEntities = new ArrayList<>();
        UserEntity adminUser = new UserEntity(
                "Kevin Pocon",
                "inkev.ap@gmail.com",
                "inkevap",
                "inkev1.618",
                "Home Address",
                "49606353",
                "3815 3015 3015"
        );
        adminUser.setUserRole(UserRole.ADMIN);
        System.out.println(adminUser.getUserRole().getDescripcion());
        userEntities.add(adminUser);
    }

    public void addUser(UserEntity userEntity) {
        if (!userEntities.contains(userEntity)) {
            userEntities.add(userEntity);
        }
    }

    public Optional<UserEntity> findUserById(int serialId) {
        return userEntities.stream().filter(actualUser -> actualUser.getUserSerialId() == serialId).findFirst();
    }

    public List<UserEntity> findUsersByText(String text) {
        String loweredText = text.toLowerCase();
        return userEntities.stream().filter(actualUser ->
                        actualUser.getUserPersonalId().toLowerCase().contains(loweredText) ||
                                actualUser.getUserAddress().toLowerCase().contains(loweredText) ||
                                actualUser.getUserRole().getDescripcion().toLowerCase().contains(loweredText) ||
                                actualUser.getUserEmail().toLowerCase().contains(loweredText) ||
                                actualUser.getUserNickName().toLowerCase().contains(loweredText) ||
                                actualUser.getUserPhoneNumber().toLowerCase().contains(loweredText) ||
                                actualUser.getUserName().toLowerCase().contains(loweredText))
                .collect(Collectors.toList());
    }

    public void removeUser(int serialId) {
        findUserById(serialId).ifPresent(userEntities::remove);
    }

    public void updateUser(UserEntity userEntity) {
        if (findUserById(userEntity.getUserSerialId()).isPresent()) {
            int index = userEntities.indexOf(findUserById(userEntity.getUserSerialId()).get());
            UserUpdater.updateUser(userEntities.get(index), userEntity); //reemplaza la informacion del objeto sin cambiar referencia
            //userEntities.set(index,userEntity); // reemplaza la referencia
        } else if (findUserByEmail(userEntity.getUserEmail()).isPresent()) {
            int index = userEntities.indexOf(findUserByEmail(userEntity.getUserEmail()).get());
            UserUpdater.updateUser(userEntities.get(index), userEntity);
        } else if (!findUsersByText(userEntity.getUserPersonalId()).isEmpty()) {
            int index = userEntities.indexOf(findUsersByText(userEntity.getUserPersonalId()).getFirst());
            UserUpdater.updateUser(userEntities.get(index), userEntity);
        }

    }

    //TODO Implementar metodo public void updateUser(String text) para que reemplace por otro parametro

    public List<UserEntity> findAllUsers() {
        return userEntities;
    }

    public List<UserEntity> findUsersByRole(UserRole role) {
        return userEntities.stream().filter(actualUser -> actualUser.getUserRole().getDescripcion().equals(role.getDescripcion())).collect(Collectors.toList());
    }

    public Optional<UserEntity> findUserByEmail(String email) {
        return userEntities.stream().filter(actualUser -> actualUser.getUserEmail().equalsIgnoreCase(email)).findFirst();
    }

    public boolean existsById(int serialId) {
        return userEntities.stream().anyMatch(actualUser -> actualUser.getUserSerialId() == serialId);
    }

    public boolean existsByEmail(String email) {
        return userEntities.stream().anyMatch(actualUser -> actualUser.getUserEmail().equalsIgnoreCase(email));
    }

    /* metodos que no corresponden a esta clase
    public void updateUserPassword(int serialId, String newPassword) {
        findUserById(serialId).ifPresent(user -> user.setUserPassword(newPassword));
    }

    public void updateUserEmail(int serialId, String newEmail) {
        findUserById(serialId).ifPresent(user -> user.setUserEmail(newEmail));
    }


    public int getLastInsertedUserId() {
        return userEntities.getLast().getUserSerialId();
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
        return userEntities.size();
    }
    */
}
