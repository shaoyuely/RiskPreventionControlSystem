package moon.calculate.user.dao;


import moon.calculate.user.service.UserVO;

public class UserEntity {

    private String id = "";
    private String username = "";
    private String password = "";
    private String status = "";
    private String category = "";
    private String token = "";

    public UserEntity() {
    }

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

    public UserVO toVO() {
        UserVO vo = new UserVO();
        vo.setId(this.id);
        vo.setUsername(this.username);
//        vo.setPassword(this.password);
        vo.setCategory(this.category);
        vo.setStatus(this.status);
        vo.setToken(this.token);
        return vo;
    }
}
