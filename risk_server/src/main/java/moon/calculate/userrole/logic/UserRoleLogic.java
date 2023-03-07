package moon.calculate.userrole.logic;

import moon.calculate.userrole.dao.UserRoleDAO;
import moon.calculate.userrole.dao.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserRoleLogic {

    @Autowired
    private UserRoleDAO userRoleDAO;

    /**
     * 新增
     *
     * @param userRoleEntity
     * @return
     */
    public int insert(UserRoleEntity userRoleEntity) {
        try {
            UserRoleEntity urEntity = new UserRoleEntity();
            urEntity.setUserId(userRoleEntity.getUserId());
            userRoleEntity.setId(UUID.randomUUID().toString());
            if (userRoleDAO.delete(urEntity) > 0) {
                if (userRoleDAO.insert(userRoleEntity) > 0) {
                    return 1;
                }
            }
            throw new Exception("更新错误");
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 删除
     *
     * @param userRoleEntity
     * @return
     */
    public int delete(UserRoleEntity userRoleEntity) {
        try {
            return userRoleDAO.delete(userRoleEntity);
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 获取角色
     *
     * @param userRoleEntity
     * @return
     */
    public List<UserRoleEntity> findByCondition(UserRoleEntity userRoleEntity) {
        try {
            return userRoleDAO.findByCondition(userRoleEntity);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    /**
     * 批量授权
     *
     * @param userRoleEntity
     * @return
     */
    public boolean roleuser(UserRoleEntity userRoleEntity, List<String> roles) {
        UserRoleEntity roleEntity = new UserRoleEntity();
        roleEntity.setUserId(userRoleEntity.getUserId());
        try {
            //不在一个事务里，需要修改
            if (userRoleDAO.delete(roleEntity) > -1) {
                for (String roleId : roles) {
                    UserRoleEntity item = new UserRoleEntity();
                    item.setId(UUID.randomUUID().toString());
                    item.setUserId(userRoleEntity.getUserId());
                    item.setRoleId(roleId);
                    if (userRoleDAO.insert(item) > 0) {
                        continue;
                    } else {
                        throw new Exception("更新错误");
                    }
                }
            } else {
                throw new Exception("更新错误");
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
