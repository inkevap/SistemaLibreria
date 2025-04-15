package model;

public class User {
    private String userName;
    private String userAddress;
    private String userPhoneNumber;
    private String userPersonalId;
    private final int userSerialId;
    private static int userSerialIdCount = 1;

    public User(String userName, String userAddress,
                String userPhoneNumber, String userPersonalId) {
        this.userName = userName;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.userPersonalId = userPersonalId;
        this.userSerialId = ++userSerialIdCount;

    }

    public int getUserSerialId() {
        return userSerialId;
    }

    public String getUserPersonalId() {
        return userPersonalId;
    }

    public void setUserPersonalId(String userPersonalId) {
        this.userPersonalId = userPersonalId;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
