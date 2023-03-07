package moon.calculate.userrole.service;

import moon.calculate.tools.ResultTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

/**
 * 权限
 */
public interface IUserRoleService {

    /**
     * 新增
     * @param header
     * @param userRoleVO
     * @return
     */
    ResultTemplate insert(@RequestHeader Map<String, Object> header, @RequestBody UserRoleVO userRoleVO);

    /**
     * 删除
     * @param header
     * @param userRoleVO
     * @return
     */
    ResultTemplate delete(@RequestHeader Map<String, Object> header, @RequestBody UserRoleVO userRoleVO);

    /**
     * 获取列表
     * @param header
     * @param userRoleVO
     * @return
     */
    ResultTemplate findbycondition(@RequestHeader Map<String, Object> header, @RequestBody UserRoleVO userRoleVO);
}
