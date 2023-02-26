package moon.calculate.approve.service;

import moon.calculate.approve.dao.ApproveEntity;
import moon.calculate.approve.logic.ApproveLogic;
import moon.calculate.tools.ResultTemplate;
import moon.calculate.tools.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 审批
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/org/approve")
public class ApproveServiceImpl {

    @Autowired
    private ApproveLogic approveLogic;

    /**
     * 新增
     *
     * @param approveVO
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultTemplate insert(@RequestHeader Map<String, Object> header, @RequestBody ApproveVO approveVO) {
        ApproveEntity approveEntity = approveVO.toEntity();
        if (approveLogic.insert(approveEntity) > 0) {
            return new ResultTemplate(StatusCode.SUCCESS, "新增成功", "");
        } else {
            return new ResultTemplate(StatusCode.ERROR, "新增失败", "");
        }
    }

    /**
     * 获取审批
     *
     * @param approveVO
     * @return
     */
    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public ResultTemplate approve(@RequestHeader Map<String, Object> header, @RequestBody ApproveVO approveVO) {
        if (approveLogic.approve(approveVO.toEntity()) > 0) {
            return new ResultTemplate(StatusCode.SUCCESS, "审批成功", "");
        } else {
            return new ResultTemplate(StatusCode.ERROR, "审批失败", "");
        }
    }
}
