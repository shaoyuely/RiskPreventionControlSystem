package moon.calculate.user.dao;


import moon.calculate.role.dao.RoleEntity;
import moon.calculate.user.service.UserVO;
import moon.calculate.userrole.dao.UserRoleEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserEntity {

    private String id = "";
    private String username = "";
    private String password = "";
    private String status = "";
    private String category = "";
    private String token = "";
    private List<UserRoleEntity> userRoleEntity;
    private List<RoleEntity> roleEntity;

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

    public List<UserRoleEntity> getUserRoleEntity() {
        return userRoleEntity;
    }

    public void setUserRoleEntity(List<UserRoleEntity> userRoleEntity) {
        this.userRoleEntity = userRoleEntity;
    }

    public List<RoleEntity> getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(List<RoleEntity> roleEntity) {
        this.roleEntity = roleEntity;
    }

    public UserVO toVO() {
        UserVO vo = new UserVO();
        vo.setId(this.id);
        vo.setUsername(this.username);
//        vo.setPassword(this.password);
        vo.setCategory(this.category);
        vo.setStatus(this.status);
        vo.setToken(this.token);
        if (Objects.nonNull(userRoleEntity)) {
            vo.setRoleIds(userRoleEntity.stream()
                    .filter(ur-> StringUtils.isNoneBlank(ur.getRoleId()))
                    .map(ur -> ur.getRoleId())
                    .collect(Collectors.toList()));
        }
        if (Objects.nonNull(roleEntity)) {
            vo.setRoleNames(roleEntity.stream()
                    .filter(r-> StringUtils.isNoneBlank(r.getRoleName()))
                    .map(r -> r.getRoleName())
                    .collect(Collectors.toList()));
        }
        return vo;
    }
}
