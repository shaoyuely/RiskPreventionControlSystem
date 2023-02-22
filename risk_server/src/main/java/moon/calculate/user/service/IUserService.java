package moon.calculate.user.service;

import moon.calculate.user.dao.Users;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Map;

public interface IUserService {

    int insert(@RequestBody UserVO userVO);

    int update(@RequestHeader Map<String,Object> header, @RequestBody UserVO userVO);

    Users online(@RequestBody UserVO userVO);

    int delete(@RequestHeader Map<String,Object> header, @RequestBody UserVO userVO);

    List<Users> findlist(@RequestHeader Map<String,Object> header, @RequestBody UserVO userVO);
}
