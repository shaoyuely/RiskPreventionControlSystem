package moon.calculate.user.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import moon.calculate.tools.ResultTemplate;
import moon.calculate.tools.StatusCode;
import moon.calculate.user.dao.UserEntity;
import moon.calculate.user.logic.UserLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 用户
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/org/user")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserLogic userLogic;

    /**
     * 新增
     *
     * @param userVO
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultTemplate insert(@RequestBody UserVO userVO) {
        UserEntity userEntity = userVO.toEntity();
        List<UserEntity> findlist = userLogic.findlist(userVO.toEntity());
        if (findlist != null && findlist.size() > 0) {
            return new ResultTemplate(StatusCode.ERROR, "该用户名已存在", "");
        }
        if (userLogic.insert(userEntity) > 0) {
            return new ResultTemplate(StatusCode.SUCCESS, "新增成功", "");
        } else {
            return new ResultTemplate(StatusCode.ERROR, "新增失败", "");
        }
    }

    /**
     * 更新
     *
     * @param userVO
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultTemplate update(@RequestHeader Map<String, Object> header, @RequestBody UserVO userVO) {
        UserEntity userEntity = userVO.toEntity();
        List<UserEntity> findlist = userLogic.findlist(userVO.toEntity());
        if (findlist != null && findlist.size() > 0) {
            return new ResultTemplate(StatusCode.ERROR, "该用户名已存在", "");
        }
        if (userLogic.update(userEntity) > 0) {
            return new ResultTemplate(StatusCode.SUCCESS, "更新成功", "");
        } else {
            return new ResultTemplate(StatusCode.ERROR, "更新失败", "");
        }
    }

    /**
     * 登录
     *
     * @param userVO
     * @return
     */
    @RequestMapping(value = "/online", method = RequestMethod.POST)
    public ResultTemplate online(@RequestBody UserVO userVO) {
        UserEntity user = userVO.toEntity();
        user.setStatus("1");
        List<UserEntity> records = userLogic.findlist(user);
        if (records != null && records.size() == 1) {
            UserEntity record = records.get(0);
            String token = UUID.randomUUID().toString();
            record.setToken(token);
            int result = userLogic.update(record);
            if (result > 0) {
                return new ResultTemplate(StatusCode.SUCCESS, "登录成功", record.toVO());
            }
        }
        return new ResultTemplate(StatusCode.ERROR, "登录失败", "");
    }

    /**
     * 删除
     *
     * @param userVO
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultTemplate delete(@RequestHeader Map<String, Object> header, @RequestBody UserVO userVO) {
        if (userLogic.delete(userVO.toEntity()) > 0) {
            return new ResultTemplate(StatusCode.SUCCESS, "删除成功", "");
        } else {
            return new ResultTemplate(StatusCode.ERROR, "删除失败", "");
        }
    }

    /**
     * 获取列表
     *
     * @param userVO
     * @return
     */
    @RequestMapping(value = "/findlist", method = RequestMethod.POST)
    public ResultTemplate findlist(@RequestHeader Map<String, Object> header, @RequestBody UserVO userVO) {
        Page page = null;
        if (Objects.nonNull(userVO.getPageNum()) && Objects.nonNull(userVO.getPageSize())) {
            page = PageHelper.startPage(userVO.getPageNum(), userVO.getPageSize());
        }
        List<UserVO> resultList = new ArrayList<>();
        List<UserEntity> list = userLogic.findlist(userVO.toEntity());
        for (UserEntity u : list) {
            resultList.add(u.toVO());
        }
        Map<String, Object> keyMap = new HashMap<>();
        Object result;
        if (Objects.nonNull(page)) {
            keyMap.put("total", page.getTotal());
            keyMap.put("data", resultList);
            result = keyMap;
        } else {
            result = resultList;
        }
        return new ResultTemplate(StatusCode.SUCCESS, "查询成功", result);
    }
}
