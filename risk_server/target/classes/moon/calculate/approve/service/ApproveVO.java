package moon.calculate.approve.service;

import moon.calculate.approve.dao.ApproveEntity;

/**
 * 审批
 */
public class ApproveVO {

    String id = "";
    String flowId = "";
    String checkUserId = "";
    String checkContent = "";
    String status = "";
    String userId = "";
    String checkTime = "";
    String isFinal = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(String checkUserId) {
        this.checkUserId = checkUserId;
    }

    public String getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIsFinal() {
        return isFinal;
    }

    public void setIsFinal(String isFinal) {
        this.isFinal = isFinal;
    }

    public ApproveEntity toEntity() {
        ApproveEntity entity = new ApproveEntity();
        entity.setId(this.id);
        entity.setFlowId(this.flowId);
        entity.setCheckUserId(this.checkUserId);
        entity.setCheckContent(this.checkContent);
        entity.setStatus(this.status);
        entity.setCheckTime(this.checkTime);
        entity.setIsFinal(this.isFinal);
        return entity;
    }
}