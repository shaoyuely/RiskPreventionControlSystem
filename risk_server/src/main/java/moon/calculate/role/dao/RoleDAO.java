package moon.calculate.role.dao;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色
 */
@Mapper
public interface RoleDAO {

    /**
     * 新增
     * @param roleEntity
     * @return
     */
    int insert(RoleEntity roleEntity);

    /**
     * 更新
     * @param roleEntity
     * @return
     */
    int update(RoleEntity roleEntity);

    /**
     * 删除
     * @param roleEntity
     * @return
     */
    int delete(RoleEntity roleEntity);

    /**
     * 获取列表
     * @param roleEntity
     * @return
     */
    List<RoleEntity> findByCondition(RoleEntity roleEntity);
}
