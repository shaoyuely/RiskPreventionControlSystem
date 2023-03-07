package moon.calculate.flow.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import moon.calculate.flow.dao.FlowEntity;
import moon.calculate.flow.logic.FlowLogic;
import moon.calculate.tools.ResultTemplate;
import moon.calculate.tools.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/org/flow")
public class FlowServiceImpl {

    @Autowired
    private FlowLogic flowLogic;

    /**
     * 新增
     *
     * @param flowVO
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultTemplate insert(@RequestHeader Map<String, Object> header, @RequestBody FlowVO flowVO) {
        FlowEntity flowEntity = flowVO.toEntity();
        FlowEntity record = flowLogic.findByLevel(flowVO.toEntity());
        if (record != null) {
            return new ResultTemplate(StatusCode.ERROR, "该等级预警建议已存在", "");
        }
        if (flowLogic.insert(flowEntity) > 0) {
            return new ResultTemplate(StatusCode.SUCCESS, "新增成功", "");
        } else {
            return new ResultTemplate(StatusCode.ERROR, "新增失败", "");
        }
    }

    /**
     * 更新
     *
     * @param flowVO
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultTemplate update(@RequestHeader Map<String, Object> header, @RequestBody FlowVO flowVO) {
        FlowEntity flowEntity = flowVO.toEntity();
        FlowEntity record = flowLogic.findByLevel(flowVO.toEntity());
        if (record != null) {
            return new ResultTemplate(StatusCode.ERROR, "该等级预警建议已存在", "");
        }
        if (flowLogic.update(flowEntity) > 0) {
            return new ResultTemplate(StatusCode.SUCCESS, "更新成功", "");
        } else {
            return new ResultTemplate(StatusCode.ERROR, "更新失败", "");
        }
    }

    /**
     * 删除
     *
     * @param flowVO
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultTemplate delete(@RequestHeader Map<String, Object> header, @RequestBody FlowVO flowVO) {
        if (flowLogic.delete(flowVO.toEntity()) > 0) {
            return new ResultTemplate(StatusCode.SUCCESS, "删除成功", "");
        } else {
            return new ResultTemplate(StatusCode.ERROR, "删除失败", "");
        }
    }

    /**
     * 根据预警等级查询
     *
     * @param flowVO
     * @return
     */
    @RequestMapping(value = "/findbylevel", method = RequestMethod.POST)
    public ResultTemplate findbylevel(@RequestHeader Map<String, Object> header, @RequestBody FlowVO flowVO) {
        FlowEntity records = flowLogic.findByLevel(flowVO.toEntity());
        return new ResultTemplate(StatusCode.SUCCESS, "查询成功", records.toVO());
    }

    /**
     * 根据审批人获取
     *
     * @param flowVO
     * @return
     */
    @RequestMapping(value = "/findbyuserid", method = RequestMethod.POST)
    public ResultTemplate findbyuserid(@RequestHeader Map<String, Object> header, @RequestBody FlowVO flowVO) {
        Page page = null;
        if (Objects.nonNull(flowVO.getPageNum()) && Objects.nonNull(flowVO.getPageSize())) {
            page = PageHelper.startPage(flowVO.getPageNum(), flowVO.getPageSize());
        }
        List<FlowVO> resultList = new ArrayList<>();
        List<FlowEntity> records = flowLogic.findByUserId(flowVO.toEntity());
        for (FlowEntity r : records) {
            resultList.add(r.toVO());
        }
        Map<String, Object> keyMap = new HashMap<>();
        Object result;
        if (Objects.nonNull(page)) {
            keyMap.put("totle", page.getTotal());
            keyMap.put("data", resultList);
            result = keyMap;
        } else {
            result = resultList;
        }
        return new ResultTemplate(StatusCode.SUCCESS, "查询成功", result);
    }
}
