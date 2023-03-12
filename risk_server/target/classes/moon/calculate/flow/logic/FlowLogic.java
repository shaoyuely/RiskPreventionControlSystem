package moon.calculate.flow.logic;

import moon.calculate.flow.dao.FlowDAO;
import moon.calculate.flow.dao.FlowEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FlowLogic {

    @Autowired
    private FlowDAO flowDAO;

    public static final String INIT_STATUS = "0";
    public static final String FINAL_STATUS = "1";

    /**
     * 新增
     *
     * @param flowEntity
     * @return
     */
    public int insert(FlowEntity flowEntity) {
        try {
            flowEntity.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            flowEntity.setId(UUID.randomUUID().toString());
            flowEntity.setStatus(INIT_STATUS);
            return flowDAO.insert(flowEntity);
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 更新
     *
     * @param flowEntity
     * @return
     */
    public int update(FlowEntity flowEntity) {
        try {
            return flowDAO.update(flowEntity);
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 删除
     *
     * @param flowEntity
     * @return
     */
    public int delete(FlowEntity flowEntity) {
        try {
            return flowDAO.delete(flowEntity);
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 根据预警等级查询
     *
     * @param flowEntity
     * @return
     */
    public FlowEntity findByLevel(FlowEntity flowEntity) {
        try {
            return flowDAO.findByLevel(flowEntity);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据审批人获取
     *
     * @param flowEntity
     * @return
     */
    public List<FlowEntity> findByUserId(FlowEntity flowEntity) {
        try {
            return flowDAO.findByUserId(flowEntity);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    /**
     * 根据审批人获取待审批
     *
     * @param flowEntity
     * @return
     */
    public List<FlowEntity> findapprove(FlowEntity flowEntity) {
        try {
            return flowDAO.findapprove(flowEntity);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
