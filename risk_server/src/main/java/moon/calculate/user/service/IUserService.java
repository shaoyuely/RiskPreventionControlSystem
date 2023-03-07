package moon.calculate.user.service;

import moon.calculate.tools.ResultTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

/**
 * 用户
 */
public interface IUserService {

    /**
     * 新增
     * @param userVO
     * @return
     */
    ResultTemplate insert(@RequestBody UserVO userVO);

    /**
     * 更新
     * @param header
     * @param userVO
     * @return
     */
    ResultTemplate update(@RequestHeader Map<String, Object> header, @RequestBody UserVO userVO);

    /**
     * 登录
     * @param userVO
     * @return
     */
    ResultTemplate online(@RequestBody UserVO userVO);

    /**
     * 删除
     * @param header
     * @param userVO
     * @return
     */
    ResultTemplate delete(@RequestHeader Map<String, Object> header, @RequestBody UserVO userVO);

    /**
     * 获取列表
     * @param header
     * @param userVO
     * @return
     */
    ResultTemplate findlist(@RequestHeader Map<String, Object> header, @RequestBody UserVO userVO);
}
