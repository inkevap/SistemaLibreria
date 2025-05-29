package sistemalibreria.DTO;

public class UserCredentialsDTO {
    private String password;
    private String username;

    public UserCredentialsDTO(String username, String password){
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
