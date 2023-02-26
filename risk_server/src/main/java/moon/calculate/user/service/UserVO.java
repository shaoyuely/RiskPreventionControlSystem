package moon.calculate.user.service;

import moon.calculate.user.dao.UserEntity;

/**
 * 用户VO
 */
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

    public UserEntity toEntity() {
        UserEntity entity = new UserEntity();
        entity.setId(this.id);
        entity.setUsername(this.username);
        entity.setPassword(this.password);
        entity.setCategory(this.category);
        entity.setStatus(this.status);
        entity.setToken(this.token);
        return entity;
    }
}
