package moon.calculate.approve.dao;

import moon.calculate.approve.service.ApproveVO;
import org.apache.commons.lang3.StringUtils;

/**
 * 审批
 */
public class ApproveEntity {

    String id = "";
    String flowId = "";
    String checkUserId = "";
    String checkContent = "";
    String status = "";
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

    public String getIsFinal() {
        return isFinal;
    }

    public void setIsFinal(String isFinal) {
        this.isFinal = isFinal;
    }

    public ApproveVO toVo() {
        ApproveVO vo = new ApproveVO();
        vo.setId(this.id);
        vo.setFlowId(this.flowId);
        vo.setCheckUserId(this.checkUserId);
        vo.setCheckContent(this.checkContent);
        vo.setStatus(this.status);
        vo.setCheckTime(this.checkTime);
        vo.setIsFinal(this.isFinal);
        return vo;
    }

    public boolean isEmpty() {
        if (StringUtils.isBlank(this.id) &&
                StringUtils.isBlank(this.flowId) &&
                StringUtils.isBlank(this.checkUserId) &&
                StringUtils.isBlank(this.checkContent) &&
                StringUtils.isBlank(this.status) &&
                StringUtils.isBlank(this.checkTime) &&
                StringUtils.isBlank(this.isFinal)
        ) {
            return true;
        } else {
            return false;
        }
    }
}