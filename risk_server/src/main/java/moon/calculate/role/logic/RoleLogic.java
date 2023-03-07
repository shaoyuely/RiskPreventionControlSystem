package moon.calculate.role.logic;

import moon.calculate.role.dao.RoleDAO;
import moon.calculate.role.dao.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * 角色
 */
@Service
public class RoleLogic {

    @Autowired
    private RoleDAO roleDAO;

    /**
     * 新增
     *
     * @param roleEntity
     * @return
     */
    public int insert(RoleEntity roleEntity) {
        try {
            roleEntity.setId(UUID.randomUUID().toString());
            return roleDAO.insert(roleEntity);
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 更新
     *
     * @param roleEntity
     * @return
     */
    public int update(RoleEntity roleEntity) {
        try {
            return roleDAO.update(roleEntity);
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 删除
     *
     * @param roleEntity
     * @return
     */
    public int delete(RoleEntity roleEntity) {
        try {
            return roleDAO.delete(roleEntity);
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 获取角色
     *
     * @param roleEntity
     * @return
     */
    public List<RoleEntity> findByCondition(RoleEntity roleEntity) {
        try {
            return roleDAO.findByCondition(roleEntity);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
