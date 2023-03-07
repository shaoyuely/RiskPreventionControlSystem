package moon.calculate.userrole.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 权限
 */
@Mapper
public interface UserRoleDAO {

    /**
     * 新增
     * @param userRoleEntity
     * @return
     */
    int insert(UserRoleEntity userRoleEntity);

    /**
     * 删除
     * @param userRoleEntity
     * @return
     */
    int delete(UserRoleEntity userRoleEntity);

    /**
     * 获取列表
     * @param userRoleEntity
     * @return
     */
    List<UserRoleEntity> findByCondition(UserRoleEntity userRoleEntity);
}
