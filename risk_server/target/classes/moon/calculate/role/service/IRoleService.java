package moon.calculate.role.service;

import moon.calculate.tools.ResultTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

/**
 * 角色
 */
public interface IRoleService {

    /**
     * 新增
     * @param header
     * @param roleVO
     * @return
     */
    ResultTemplate insert(@RequestHeader Map<String, Object> header, @RequestBody RoleVO roleVO);

    /**
     * 更新
     * @param header
     * @param roleVO
     * @return
     */
    ResultTemplate update(@RequestHeader Map<String, Object> header, @RequestBody RoleVO roleVO);

    /**
     * 删除
     * @param header
     * @param roleVO
     * @return
     */
    ResultTemplate delete(@RequestHeader Map<String, Object> header, @RequestBody RoleVO roleVO);

    /**
     * 获取列表
     * @param header
     * @param roleVO
     * @return
     */
    ResultTemplate findbycondition(@RequestHeader Map<String, Object> header, @RequestBody RoleVO roleVO);
}
