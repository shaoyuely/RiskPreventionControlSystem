package moon.calculate.approve.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 审批
 */
@Mapper
public interface ApproveDAO {

    /**
     * 新增
     * @param approveEntity
     * @return
     */
    int insert(ApproveEntity approveEntity);

    /**
     * 更新审批状态
     * @param approveEntity
     * @return
     */
    int updateStatus(ApproveEntity approveEntity);

    /**
     * 获取上一个审批
     * @param approveEntity
     * @return
     */
    ApproveEntity findPre(ApproveEntity approveEntity);

    /**
     * 获取列表
     * @param approveEntity
     * @return
     */
    List<ApproveEntity> findList(ApproveEntity approveEntity);
}
