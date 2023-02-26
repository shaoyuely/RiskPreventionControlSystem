package moon.calculate.userrole.logic;

import moon.calculate.tools.MyBatisUtil;
import moon.calculate.userrole.dao.UserRoleDAO;
import moon.calculate.userrole.dao.UserRoleEntity;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Transactional
public class UserRoleLogic {

    /**
     * 新增
     *
     * @param userRoleEntity
     * @return
     */
    public int insert(UserRoleEntity userRoleEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession(false);
            Connection conn = sqlSession.getConnection();
            conn.setAutoCommit(false);
            UserRoleDAO userRoleDAO = sqlSession.getMapper(UserRoleDAO.class);
            UserRoleEntity urEntity = new UserRoleEntity();
            urEntity.setUserId(userRoleEntity.getUserId());
            userRoleEntity.setId(UUID.randomUUID().toString());
            if (userRoleDAO.delete(urEntity) > 0) {
                if (userRoleDAO.insert(userRoleEntity) > 0) {
                    conn.commit();
                    return 1;
                }
            }
            throw new Exception("更新错误");
        } catch (Exception e) {
            sqlSession.rollback();
            return -1;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 删除
     *
     * @param userRoleEntity
     * @return
     */
    public int delete(UserRoleEntity userRoleEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            UserRoleDAO userRoleDAO = sqlSession.getMapper(UserRoleDAO.class);
            return userRoleDAO.delete(userRoleEntity);
        } catch (Exception e) {
            return -1;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 获取角色
     *
     * @param userRoleEntity
     * @return
     */
    public List<UserRoleEntity> findByCondition(UserRoleEntity userRoleEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            UserRoleDAO userRoleDAO = sqlSession.getMapper(UserRoleDAO.class);
            return userRoleDAO.findByCondition(userRoleEntity);
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
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

        SqlSession sqlSession = null;
        try {
            //不在一个事务里，需要修改
            sqlSession = MyBatisUtil.getSqlSession();
            UserRoleDAO userRoleDAO = sqlSession.getMapper(UserRoleDAO.class);
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
            sqlSession.commit();
            return true;
        } catch (Exception e) {
            sqlSession.rollback();
            return false;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }


}
