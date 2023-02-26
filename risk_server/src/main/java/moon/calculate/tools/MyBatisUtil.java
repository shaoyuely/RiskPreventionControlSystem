package moon.calculate.tools;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {
            String config = "mybatis.xml";
            InputStream in = null;
            try {
                in = Resources.getResourceAsStream(config);
            } catch (IOException e) {
                e.printStackTrace();
            }
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        }
        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        if (getSqlSessionFactory() != null) {
            sqlSession = getSqlSessionFactory().openSession(true);
        }
        return sqlSession;
    }

    public static SqlSession getSqlSession(boolean b) {
        SqlSession sqlSession = null;
        if (getSqlSessionFactory() != null) {
            sqlSession = getSqlSessionFactory().openSession(b);
        }
        return sqlSession;
    }
}