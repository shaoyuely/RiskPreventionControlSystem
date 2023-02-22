package moon.calculate.user.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(Users users);

    int update(Users users);

    int delete(Users users);

    List<Users> findlist(Users users);
}