package moon.calculate.flow.logic;

import moon.calculate.flow.dao.FlowDAO;
import moon.calculate.flow.dao.FlowEntity;
import moon.calculate.tools.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class FlowLogic {

    public static final String INIT_STATUS = "0";
    public static final String FINAL_STATUS = "1";

    /**
     * 新增
     *
     * @param flowEntity
     * @return
     */
    public int insert(FlowEntity flowEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            flowEntity.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            FlowDAO flowDAO = sqlSession.getMapper(FlowDAO.class);
            flowEntity.setId(UUID.randomUUID().toString());
            flowEntity.setStatus(INIT_STATUS);
            return flowDAO.insert(flowEntity);
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
     *
     * @param flowEntity
     * @return
     */
    public int update(FlowEntity flowEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            FlowDAO flowDAO = sqlSession.getMapper(FlowDAO.class);
            return flowDAO.update(flowEntity);
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
     *
     * @param flowEntity
     * @return
     */
    public int delete(FlowEntity flowEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            FlowDAO flowDAO = sqlSession.getMapper(FlowDAO.class);
            return flowDAO.delete(flowEntity);
        } catch (Exception e) {
            return -1;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 根据预警等级查询
     *
     * @param flowEntity
     * @return
     */
    public FlowEntity findByLevel(FlowEntity flowEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            FlowDAO flowDAO = sqlSession.getMapper(FlowDAO.class);
            return flowDAO.findByLevel(flowEntity);
        } catch (Exception e) {
            return null;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 根据审批人获取
     *
     * @param flowEntity
     * @return
     */
    public List<FlowEntity> findByUserId(FlowEntity flowEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            FlowDAO flowDAO = sqlSession.getMapper(FlowDAO.class);
            return flowDAO.findByUserId(flowEntity);
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
