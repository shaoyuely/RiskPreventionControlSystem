package moon.calculate.flow.dao;

import moon.calculate.approve.dao.ApproveEntity;
import moon.calculate.approve.service.ApproveVO;
import moon.calculate.flow.service.FlowVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FlowEntity {

    private String id = "";
    private String flowTitle = "";
    private String flowContent = "";
    private String status = "";
    private String createTime = "";
    private String userId = "";
    private Integer warnLevel;
    private List<ApproveEntity> approves;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlowTitle() {
        return flowTitle;
    }

    public void setFlowTitle(String flowTitle) {
        this.flowTitle = flowTitle;
    }

    public String getFlowContent() {
        return flowContent;
    }

    public void setFlowContent(String flowContent) {
        this.flowContent = flowContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<ApproveEntity> getApproves() {
        return approves;
    }

    public void setApproves(List<ApproveEntity> approves) {
        this.approves = approves;
    }

    public Integer getWarnLevel() {
        return warnLevel;
    }

    public void setWarnLevel(Integer warnLevel) {
        this.warnLevel = warnLevel;
    }

    public FlowVO toVO() {
        FlowVO vo = new FlowVO();
        vo.setId(this.id);
        vo.setFlowTitle(this.flowTitle);
        vo.setFlowContent(this.flowContent);
        vo.setCreateTime(this.createTime);
        vo.setUserId(this.userId);
        vo.setWarnLevel(this.warnLevel);
        if(Objects.nonNull(this.approves)){
            List<ApproveVO> result=new ArrayList<>();
            for(ApproveEntity a:this.approves) {
                if(!a.isEmpty()) {
                    ApproveVO item = a.toVo();
                    result.add(item);
                }
            }
            if(result.size()>0) {
                vo.setApproves(result);
            }
        }
        return vo;
    }
}
