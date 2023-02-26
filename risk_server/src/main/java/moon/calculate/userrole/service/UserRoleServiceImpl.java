package moon.calculate.userrole.service;

import moon.calculate.tools.ResultTemplate;
import moon.calculate.tools.StatusCode;
import moon.calculate.userrole.dao.UserRoleEntity;
import moon.calculate.userrole.logic.UserRoleLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 权限
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/org/userrole")
public class UserRoleServiceImpl {

    @Autowired
    private UserRoleLogic userRoleLogic;

    /**
     * 新增
     *
     * @param userRoleVO
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultTemplate insert(@RequestHeader Map<String, Object> header, @RequestBody UserRoleVO userRoleVO) {
        UserRoleEntity userRoleEntity = userRoleVO.toEntity();
        if (userRoleLogic.insert(userRoleEntity) > 0) {
            return new ResultTemplate(StatusCode.SUCCESS, "新增成功", "");
        } else {
            return new ResultTemplate(StatusCode.ERROR, "新增失败", "");
        }
    }

//    /**
//     * 删除
//     *
//     * @param userRoleVO
//     * @return
//     */
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public ResultTemplate delete(@RequestHeader Map<String, Object> header, @RequestBody UserRoleVO userRoleVO) {
//        if (userRoleLogic.delete(userRoleVO.toEntity()) > 0) {
//            return new ResultTemplate(StatusCode.SUCCESS, "删除成功", "");
//        } else {
//            return new ResultTemplate(StatusCode.ERROR, "删除失败", "");
//        }
//    }

    /**
     * 获取列表
     *
     * @param userRoleVO
     * @return
     */
    @RequestMapping(value = "/findbycondition", method = RequestMethod.POST)
    public ResultTemplate findbycondition(@RequestHeader Map<String, Object> header, @RequestBody UserRoleVO userRoleVO) {
        List<UserRoleVO> result = new ArrayList<>();
        List<UserRoleEntity> list = userRoleLogic.findByCondition(userRoleVO.toEntity());
        for (UserRoleEntity u : list) {
            result.add(u.toVO());
        }
        return new ResultTemplate(StatusCode.SUCCESS, "查询成功", result);
    }

    /**
     * 授权
     *
     * @param userRoleVO
     * @return
     */
    @RequestMapping(value = "/roleuser", method = RequestMethod.POST)
    public ResultTemplate roleuser(@RequestHeader Map<String, Object> header, @RequestBody UserRoleVO userRoleVO) {
        if(userRoleLogic.roleuser(userRoleVO.toEntity(),userRoleVO.getRoleIds())){
            return new ResultTemplate(StatusCode.SUCCESS, "授权成功", "");
        } else {
            return new ResultTemplate(StatusCode.ERROR, "授权失败", "");
        }
    }
}
