package moon.calculate.flow.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FlowDAO {

    /**
     * 新增
     * @param flowEntity
     * @return
     */
    int insert(FlowEntity flowEntity);

    /**
     * 更新
     * @param flowEntity
     * @return
     */
    int update(FlowEntity flowEntity);

    /**
     * 删除
     * @param roleEntity
     * @return
     */
    int delete(FlowEntity roleEntity);

    /**
     * 根据预警等级查询
     * @param flowEntity
     * @return
     */
    FlowEntity findByLevel(FlowEntity flowEntity);

    /**
     * 根据审批人获取
     * @param flowEntity
     * @return
     */
    List<FlowEntity> findByUserId(FlowEntity flowEntity);
}
