package moon.calculate.role.dao;

import moon.calculate.role.service.RoleVO;

/**
 * 角色
 */
public class RoleEntity {
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

    public RoleVO toVo() {
        RoleVO vo = new RoleVO();
        vo.setId(this.id);
        vo.setRoleName(this.roleName);
        vo.setStatus(this.status);
        return vo;
    }
}
