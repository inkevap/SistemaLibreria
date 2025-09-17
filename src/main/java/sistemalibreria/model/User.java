package sistemalibreria.model;

public class User {
    private final String userName;
    private final String userEmail;
    private final String userNickName;
    private final String userPassword;
    private final UserRole userRole;
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
                UserRole role,
                boolean userStatus,
                String userPersonalId,
                int userSerialId) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userNickName = userNickName;
        this.userPassword = userPassword;
        this.userRole = role;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.userPersonalId = userPersonalId;
        this.userStatus = userStatus;
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
        this.userRole = UserRole.USER;
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

    public UserRole getUserRole() {
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
        return "Nuevo Usuario {" +
                "Nombre Completo: '" + userName + '\'' +
                ",\n Correo Electronico: '" + userEmail + '\'' +
                ",\n Nombre de Usuario: '" + userNickName + '\'' +
                ",\n Contraseña: '" + userPassword + '\'' +
                ",\n Rol de usuario: '" + userRole + '\'' +
                ",\n Direccion: '" + userAddress + '\'' +
                ",\n Numero de Telefono: '" + userPhoneNumber + '\'' +
                ",\n Identifiacion Personal: '" + userPersonalId + '\'' +
                ",\n Estado del usuario: " + (userStatus ? "Activo": "Desactivado") +
                ",\n Codigo Serial Unico: " + userSerialId +
                " }";
    }
}
