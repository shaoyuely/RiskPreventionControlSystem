package moon.calculate.user.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户
 */
@Mapper
public interface UserDAO {

    /**
     * 新增
     * @param userEntity
     * @return
     */
    int insert(UserEntity userEntity);

    /**
     * 删除
     * @param userEntity
     * @return
     */
    int update(UserEntity userEntity);

    /**
     * 删除
     * @param userEntity
     * @return
     */
    int delete(UserEntity userEntity);

    /**
     * 获取列表
     * @param userEntity
     * @return
     */
    List<UserEntity> findlist(UserEntity userEntity);
}