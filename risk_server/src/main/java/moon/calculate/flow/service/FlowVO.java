package moon.calculate.flow.service;

import moon.calculate.approve.service.ApproveVO;
import moon.calculate.flow.dao.FlowEntity;

import java.util.List;

public class FlowVO {

    private String id = "";
    private String flowTitle = "";
    private String flowContent = "";
    private String status = "";
    private String createTime = "";
    private String userId = "";
    private Integer warnLevel;
    private List<ApproveVO> approves;

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

    public List<ApproveVO> getApproves() {
        return approves;
    }

    public void setApproves(List<ApproveVO> approves) {
        this.approves = approves;
    }

    public Integer getWarnLevel() {
        return warnLevel;
    }

    public void setWarnLevel(Integer warnLevel) {
        this.warnLevel = warnLevel;
    }

    public FlowEntity toEntity() {
        FlowEntity entity = new FlowEntity();
        entity.setId(this.id);
        entity.setFlowTitle(this.flowTitle);
        entity.setFlowContent(this.flowContent);
        entity.setCreateTime(this.createTime);
        entity.setUserId(this.userId);
        entity.setWarnLevel(this.warnLevel);
        return entity;
    }
}
