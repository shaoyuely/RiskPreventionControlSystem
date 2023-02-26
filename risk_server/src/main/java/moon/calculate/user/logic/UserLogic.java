package moon.calculate.user.logic;

import moon.calculate.tools.MyBatisUtil;
import moon.calculate.user.dao.UserDAO;
import moon.calculate.user.dao.UserEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 用户
 */
@Component
public class UserLogic {

    /**
     * 新增
     * @param userEntity
     * @return
     */
    public int insert(UserEntity userEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
            userEntity.setId(UUID.randomUUID().toString());
            if(StringUtils.isBlank(userEntity.getStatus())) {
                userEntity.setStatus("0");
            }
            return userDAO.insert(userEntity);
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
     * @param userEntity
     * @return
     */
    public int update(UserEntity userEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
            return userDAO.update(userEntity);
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
     * @param userEntity
     * @return
     */
    public int delete(UserEntity userEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
            return userDAO.delete(userEntity);
        } catch (Exception e) {
            return -1;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 获取列表
     * @param userEntity
     * @return
     */
    public List<UserEntity> findlist(UserEntity userEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
            return userDAO.findlist(userEntity);
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
