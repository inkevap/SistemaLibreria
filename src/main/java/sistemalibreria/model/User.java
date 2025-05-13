package sistemalibreria.model;

import java.util.HashSet;
import java.util.Set;

import static sistemalibreria.util.Constants.GUEST_ROLE;
import static sistemalibreria.util.Constants.USER_ROLE;

public class User {
    private final String userName;
    private final String userEmail;
    private final String userNickName;
    private final String userPassword;
    private final String userRole;
    private final String userAddress;
    private final String userPhoneNumber;
    private final String userPersonalId;
    private final Boolean userStatus;
    private int userSerialId = -1;


    public User(String userName,
                String userEmail,
                String userNickName,
                String userPassword,
                String userAddress,
                String userPhoneNumber,
                String userPersonalId,
                int userSerialId) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userNickName = userNickName;
        this.userPassword = userPassword;
        this.userRole = USER_ROLE;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.userPersonalId = userPersonalId;
        this.userStatus = true;
        this.userSerialId = userSerialId;
    }

    public User(String userName,
                String userEmail,
                String userNickName,
                String userPassword,
                String userAddress,
                String userPhoneNumber,
                String userPersonalId) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userNickName = userNickName;
        this.userPassword = userPassword;
        this.userRole = USER_ROLE;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.userPersonalId = userPersonalId;
        this.userStatus = true;
    }




    public String getUserName() {
        return userName;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public String getUserPersonalId() {
        return userPersonalId;
    }

    public int getUserSerialId() {
        return userSerialId;
    }

    public Boolean getUserStatus() {
        return userStatus;
    }

    public String getUserEmail() {
        return userEmail;
    }

    @Override
    public String toString() {
        return "Nuevo Usuario { \n" +
                "Nombre Completo: '" + userName + '\'' +
                ", Correo Electronico: '" + userEmail + '\'' +
                ",\n Nombre de Usuario: '" + userNickName + '\'' +
                ", Contraseña: '" + userPassword + '\'' +
                ",\n Rol de usuario: '" + userRole + '\'' +
                ", Direccion: '" + userAddress + '\'' +
                ",\n Numero de Telefono: '" + userPhoneNumber + '\'' +
                ", Identifiacion Personal: '" + userPersonalId + '\'' +
                ",\n Estado del usuario: " + (userStatus ? "Activo": "Desactivado") +
                ", Codigo Serial Unico: " + userSerialId +
                " }";
    }
}
