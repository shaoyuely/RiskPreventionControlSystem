package moon.calculate.userrole.dao;

import moon.calculate.userrole.service.UserRoleVO;

/**
 * 权限
 */
public class UserRoleEntity {
    private String id = "";
    private String userId = "";
    private String roleId = "";

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

    public UserRoleVO toVO() {
        UserRoleVO vo = new UserRoleVO();
        vo.setId(this.id);
        vo.setUserId(this.userId);
        vo.setRoleId(this.roleId);
        return vo;
    }
}
