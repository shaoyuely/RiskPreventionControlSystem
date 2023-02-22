package moon.calculate.user.service;

import moon.calculate.user.dao.Users;

public class UserVO {

    private String id = "";
    private String username = "";
    private String password = "";
    private String status = "";
    private String category = "";
    private String token = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Users toEntity() {
        Users userEntity = new Users();
        userEntity.setId(this.id);
        userEntity.setUsername(this.username);
        userEntity.setPassword(this.password);
        userEntity.setCategory(this.category);
        userEntity.setStatus(this.status);
        userEntity.setToken(this.token);
        return userEntity;
    }
}
