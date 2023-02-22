package moon.calculate.user.logic;

import moon.calculate.tools.MyBatisUtil;
import moon.calculate.user.dao.UserMapper;
import moon.calculate.user.dao.Users;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class UserLogic {

    public int insert(Users userEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userEntity.setId(UUID.randomUUID().toString());
            userEntity.setStatus("0");
            return userMapper.insert(userEntity);
        } catch (Exception e) {
            return -1;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public int update(Users userEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.update(userEntity);
        } catch (Exception e) {
            return -1;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public int delete(Users userEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.delete(userEntity);
        } catch (Exception e) {
            return -1;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public List<Users> findlist(Users userEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.findlist(userEntity);
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
