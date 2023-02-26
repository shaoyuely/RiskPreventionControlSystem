package moon.calculate.userrole.service;

import moon.calculate.userrole.dao.UserRoleEntity;

import java.util.List;

/**
 * 权限VO
 */
public class UserRoleVO {
    private String id = "";
    private String userId = "";
    private String roleId = "";
    private List<String> roleIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    public UserRoleEntity toEntity() {
        UserRoleEntity entity = new UserRoleEntity();
        entity.setId(this.id);
        entity.setUserId(this.userId);
        entity.setRoleId(this.roleId);
        return entity;
    }
}
