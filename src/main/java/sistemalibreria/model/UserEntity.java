package sistemalibreria.model;

import sistemalibreria.config.AppConfig;
import sistemalibreria.interfaces.IPasswordEncryptor;
import sistemalibreria.util.BCryptEncryptor;

import java.util.HashSet;
import java.util.Set;

import static sistemalibreria.util.Constants.GUEST_ROLE;
import static sistemalibreria.util.Constants.USER_ROLE;

public class UserEntity {
    private String userName;
    private String userEmail;
    private String userNickName;
    private String userPassword;
    private String userRole;
    private String userAddress;
    private String userPhoneNumber;
    private String userPersonalId;
    private Boolean userStatus;
    private final int userSerialId;
//    private static final List<Integer> userSerialIdCount = new ArrayList<>(); // mas lento que la implementacion actual
    private final Set<Integer> userSerialIdCount = new HashSet<>();
    private final IPasswordEncryptor passwordEncryptor = AppConfig.passwordEncryptor();


    public UserEntity(String userName,
                      String userEmail,
                      String userNickName,
                      String userPassword,
                      String userAddress,
                      String userPhoneNumber,
                      String userPersonalId) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userNickName = userNickName;
        this.userPassword = passwordEncryptor.hashPassword(userPassword);
        this.userRole = USER_ROLE;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.userPersonalId = userPersonalId;
        this.userStatus = true;
        this.userSerialId = generateUniqueId();
    }

    public UserEntity(){
        this.userName = "";
        this.userEmail = "";
        this.userNickName = "";
        this.userPassword = "";
        this.userRole = GUEST_ROLE;
        this.userAddress = "";
        this.userPhoneNumber = "";
        this.userPersonalId = "";
        this.userStatus = false;
        this.userSerialId = generateUniqueId();
    }
    private int generateUniqueId(){
        int serialID;
        do {
            serialID = (int) (Math.random() * 1000) + 1;
        }
        while (userSerialIdCount.contains(serialID));
        userSerialIdCount.add(serialID);
        return serialID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = passwordEncryptor.hashPassword(userPassword);
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String role) {
        this.userRole = role;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserPersonalId() {
        return userPersonalId;
    }

    public void setUserPersonalId(String userPersonalId) {
        this.userPersonalId = userPersonalId;
    }

    public int getUserSerialId() {
        return userSerialId;
    }

    public Boolean getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Boolean userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
