package moon.calculate.user.logic;

import moon.calculate.user.dao.UserDAO;
import moon.calculate.user.dao.UserEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 用户
 */
@Service
public class UserLogic {

    @Autowired
    private UserDAO userDAO;

    /**
     * 新增
     *
     * @param userEntity
     * @return
     */
    public int insert(UserEntity userEntity) {
        try {
            userEntity.setId(UUID.randomUUID().toString());
            if (StringUtils.isBlank(userEntity.getStatus())) {
                userEntity.setStatus("0");
            }
            return userDAO.insert(userEntity);
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 更新
     *
     * @param userEntity
     * @return
     */
    public int update(UserEntity userEntity) {
        try {
            return userDAO.update(userEntity);
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 删除
     *
     * @param userEntity
     * @return
     */
    public int delete(UserEntity userEntity) {
        try {
            return userDAO.delete(userEntity);
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 获取列表
     *
     * @param userEntity
     * @return
     */
    public List<UserEntity> findlist(UserEntity userEntity) {
        try {
            return userDAO.findlist(userEntity);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
