package moon.calculate.user.service;

import moon.calculate.user.dao.Users;
import moon.calculate.user.logic.UserLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/org/user")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserLogic userLogic;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int insert(@RequestBody UserVO userVO) {
        Users users = new Users();
        users.setUsername(userVO.getUsername());
        List<Users> findlist = userLogic.findlist(userVO.toEntity());
        if (findlist != null && findlist.size() > 0) {
            return -2;
        }
        return userLogic.insert(userVO.toEntity());
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public int update(@RequestHeader Map<String, Object> header, @RequestBody UserVO userVO) {
        return userLogic.update(userVO.toEntity());
    }

    @RequestMapping(value = "/online", method = RequestMethod.POST)
    public Users online(@RequestBody UserVO userVO) {
        Users user = userVO.toEntity();
        user.setStatus("1");
        List<Users> records = userLogic.findlist(user);
        if (records != null && records.size() == 1) {
            Users record = records.get(0);
            String token = UUID.randomUUID().toString();
            record.setToken(token);
            int result = userLogic.update(record);
            if (result > 0) {
                return record;
            }
        }
        return null;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(@RequestHeader Map<String, Object> header, @RequestBody UserVO userVO) {
        return userLogic.delete(userVO.toEntity());
    }

    @RequestMapping(value = "/findlist", method = RequestMethod.POST)
    public List<Users> findlist(@RequestHeader Map<String, Object> header, @RequestBody UserVO userVO) {
        return userLogic.findlist(userVO.toEntity());
    }
}
