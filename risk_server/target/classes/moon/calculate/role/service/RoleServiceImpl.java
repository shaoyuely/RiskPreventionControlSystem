package moon.calculate.role.service;

import moon.calculate.role.dao.RoleEntity;
import moon.calculate.role.logic.RoleLogic;
import moon.calculate.tools.ResultTemplate;
import moon.calculate.tools.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 角色
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/org/role")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleLogic roleLogic;

    /**
     * 新增
     *
     * @param roleVO
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultTemplate insert(@RequestHeader Map<String, Object> header, @RequestBody RoleVO roleVO) {
        RoleEntity roleEntity = roleVO.toEntity();
        List<RoleEntity> findlist = roleLogic.findByCondition(roleEntity);
        if (findlist != null && findlist.size() > 0) {
            return new ResultTemplate(StatusCode.ERROR, "该角色已存在", "");
        }
        if (roleLogic.insert(roleEntity) > 0) {
            return new ResultTemplate(StatusCode.SUCCESS, "新增成功", "");
        } else {
            return new ResultTemplate(StatusCode.ERROR, "新增失败", "");
        }
    }

    /**
     * 更新
     *
     * @param roleVO
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultTemplate update(@RequestHeader Map<String, Object> header, @RequestBody RoleVO roleVO) {
        RoleEntity roleEntity = roleVO.toEntity();
        List<RoleEntity> findlist = roleLogic.findByCondition(roleEntity);
        if (findlist != null && findlist.size() > 0) {
            return new ResultTemplate(StatusCode.ERROR, "该角色已存在", "");
        }
        if (roleLogic.update(roleEntity) > 0) {
            return new ResultTemplate(StatusCode.SUCCESS, "更新成功", "");
        } else {
            return new ResultTemplate(StatusCode.ERROR, "更新失败", "");
        }
    }

    /**
     * 删除
     *
     * @param roleVO
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultTemplate delete(@RequestHeader Map<String, Object> header, @RequestBody RoleVO roleVO) {
        if (roleLogic.delete(roleVO.toEntity()) > 0) {
            return new ResultTemplate(StatusCode.SUCCESS, "删除成功", "");
        } else {
            return new ResultTemplate(StatusCode.ERROR, "删除失败", "");
        }
    }

    /**
     * 获取列表
     *
     * @param roleVO
     * @return
     */
    @RequestMapping(value = "/findbycondition", method = RequestMethod.POST)
    public ResultTemplate findbycondition(@RequestHeader Map<String, Object> header, @RequestBody RoleVO roleVO) {
        List<RoleVO> result = new ArrayList<>();
        List<RoleEntity> records = roleLogic.findByCondition(roleVO.toEntity());
        for (RoleEntity r : records) {
            result.add(r.toVo());
        }
        return new ResultTemplate(StatusCode.SUCCESS, "查询成功", records);
    }
}
