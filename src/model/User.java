package model;

import static util.Constants.USER_ROLE;

public class User {
    private String userName;
    private String userNickName;
    private String userPassword;
    private String role;
    private String userAddress;
    private String userPhoneNumber;
    private String userPersonalId;
    private final int userSerialId;
    private static int userSerialIdCount = 1;

    public User(String userName, String userNickName,
                String userPassword,
                String userAddress, String userPhoneNumber,
                String userPersonalId) {
        this.userName = userName;
        this.userNickName = userNickName;
        this.userPassword = userPassword;
        this.role = USER_ROLE;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.userPersonalId = userPersonalId;
        this.userSerialId = ++userSerialIdCount;
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
        this.userPassword = userPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
}
