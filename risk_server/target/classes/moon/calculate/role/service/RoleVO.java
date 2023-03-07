package moon.calculate.role.service;

import moon.calculate.role.dao.RoleEntity;

/**
 * 角色
 */
public class RoleVO {
    private String id = "";
    private String roleName = "";
    private String status = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RoleEntity toEntity() {
        RoleEntity entity = new RoleEntity();
        entity.setId(this.id);
        entity.setRoleName(this.roleName);
        entity.setStatus(this.status);
        return entity;
    }
}
