package moon.calculate.role.logic;

import moon.calculate.role.dao.RoleDAO;
import moon.calculate.role.dao.RoleEntity;
import moon.calculate.tools.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * 角色
 */
@Component
public class RoleLogic {

    /**
     * 新增
     * @param roleEntity
     * @return
     */
    public int insert(RoleEntity roleEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            RoleDAO roleDAO = sqlSession.getMapper(RoleDAO.class);
            roleEntity.setId(UUID.randomUUID().toString());
            return roleDAO.insert(roleEntity);
        } catch (Exception e) {
            return -1;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 更新
     * @param roleEntity
     * @return
     */
    public int update(RoleEntity roleEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            RoleDAO roleDAO = sqlSession.getMapper(RoleDAO.class);
            return roleDAO.update(roleEntity);
        } catch (Exception e) {
            return -1;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 删除
     * @param roleEntity
     * @return
     */
    public int delete(RoleEntity roleEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            RoleDAO roleDAO = sqlSession.getMapper(RoleDAO.class);
            return roleDAO.delete(roleEntity);
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
     * @param roleEntity
     * @return
     */
    public List<RoleEntity> findByCondition(RoleEntity roleEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            RoleDAO roleDAO = sqlSession.getMapper(RoleDAO.class);
            return roleDAO.findByCondition(roleEntity);
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
