package moon.calculate.approve.logic;

import moon.calculate.approve.dao.ApproveDAO;
import moon.calculate.approve.dao.ApproveEntity;
import moon.calculate.flow.dao.FlowDAO;
import moon.calculate.flow.dao.FlowEntity;
import moon.calculate.flow.logic.FlowLogic;
import moon.calculate.tools.MyBatisUtil;
import moon.calculate.userrole.dao.UserRoleDAO;
import moon.calculate.userrole.dao.UserRoleEntity;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 审批
 */
@Component
public class ApproveLogic {

    public static final String AGREE = "1";
    public static final String DISAGREE = "0";

    public static final String IS_FINAL = "1";
    public static final String ISNOT_FINAL = "0";

    public static final String FINAL_ROLE_ID = "1";

    /**
     * 新增
     *
     * @param approveEntity
     * @return
     */
    public int insert(ApproveEntity approveEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            ApproveDAO approveDAO = sqlSession.getMapper(ApproveDAO.class);
            approveEntity.setId(UUID.randomUUID().toString());

            UserRoleEntity userEntity = new UserRoleEntity();
            userEntity.setUserId(approveEntity.getCheckUserId());
            userEntity.setRoleId(FINAL_ROLE_ID);
            UserRoleDAO userRoleDAO = sqlSession.getMapper(UserRoleDAO.class);
            //查询当次提交新审批人是否为最终审批人（总经理）
            if (userRoleDAO.findByCondition(userEntity) != null) {
                approveEntity.setIsFinal(IS_FINAL);
            } else {
                approveEntity.setIsFinal(ISNOT_FINAL);
            }
            return approveDAO.insert(approveEntity);
        } catch (Exception e) {
            return -1;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 更新审批状态
     *
     * @param approveEntity
     * @return
     */
    public int approve(ApproveEntity approveEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            ApproveDAO approveDAO = sqlSession.getMapper(ApproveDAO.class);
            approveEntity.setId(UUID.randomUUID().toString());

            //获取当前审批信息判断是否为最后一次
            ApproveEntity pre = approveDAO.findPre(approveEntity);
            if (pre == null) {
                return -1;
            }
            boolean isFinal = IS_FINAL.equals(pre.getIsFinal());

            if (AGREE.equals(approveEntity.getStatus())) {
                //审批同意逻辑
                UserRoleEntity userEntity = new UserRoleEntity();
                userEntity.setUserId(approveEntity.getCheckUserId());
                userEntity.setRoleId(FINAL_ROLE_ID);
                UserRoleDAO userRoleDAO = sqlSession.getMapper(UserRoleDAO.class);
                //查询当次提交新审批人是否为最终审批人（总经理）
                if (userRoleDAO.findByCondition(userEntity) != null) {
                    //更新当前审批内容
                    approveEntity.setCheckTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                    approveDAO.updateStatus(approveEntity);
                    approveEntity.setIsFinal(IS_FINAL);
                } else {
                    approveEntity.setIsFinal(ISNOT_FINAL);
                }
                //如果为最后一层审批则结束
                if (!isFinal) {
                    //提交下一环节审批数据
                    return approveDAO.insert(approveEntity);
                } else {
                    //结束审批更新flow表状态
                    FlowDAO flowDAO = sqlSession.getMapper(FlowDAO.class);
                    FlowEntity flowEntity = new FlowEntity();
                    flowEntity.setId(approveEntity.getFlowId());
                    //更新flow状态为审批结束
                    flowEntity.setStatus(FlowLogic.FINAL_STATUS);
                    if (flowDAO.update(flowEntity) > 0) {
                        return 1;
                    }
                }
            } else if (DISAGREE.equals(approveEntity.getStatus())) {
                //审批驳回逻辑
                //修改当前审批
                approveEntity.setCheckTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                approveDAO.updateStatus(approveEntity);
                ApproveEntity a = new ApproveEntity();
                a.setId(UUID.randomUUID().toString());
                a.setFlowId(pre.getFlowId());
                //插入一条与前一条审批人相同的数据，达到驳回效果
                a.setCheckUserId(pre.getCheckUserId());
                //必然不为最后一条审批
                a.setStatus(ISNOT_FINAL);
                return approveDAO.insert(approveEntity);
            }
            return -1;
        } catch (Exception e) {
            return -1;
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 获取审批
     *
     * @param approveEntity
     * @return
     */
    public List<ApproveEntity> findList(ApproveEntity approveEntity) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            ApproveDAO approveDAO = sqlSession.getMapper(ApproveDAO.class);
            return approveDAO.findList(approveEntity);
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

//    public boolean isApproveFinish(ApproveEntity approveEntity){
//        SqlSession sqlSession = null;
//        try {
//            sqlSession = MyBatisUtil.getSqlSession();
//            ApproveDAO approveDAO = sqlSession.getMapper(ApproveDAO.class);
//            FlowDAO flowDAO = sqlSession.getMapper(FlowDAO.class);
//            flowDAO
//            List<ApproveEntity> list = approveDAO.findList(approveEntity);
//        } catch (Exception e) {
//            return new ArrayList<>();
//        } finally {
//            if (sqlSession != null) {
//                sqlSession.close();
//            }
//        }
//    }
}
