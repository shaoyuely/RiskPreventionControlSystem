package moon.calculate.models;

import moon.calculate.tools.Tools;

public class WarningVO {

    //预警等级
    private Tools.EarlyWarningLevel earlyWarningLevel = Tools.EarlyWarningLevel.NONE;
    //预警处理提示
    private Tools.EarlyWarningProcessing earlyWarningProcessing = Tools.EarlyWarningProcessing.NONE;

//    private String impactConditions = "";

    public Tools.EarlyWarningLevel getEarlyWarningLevel() {
        return earlyWarningLevel;
    }

    public void setEarlyWarningLevel(Tools.EarlyWarningLevel earlyWarningLevel) {
        this.earlyWarningLevel = earlyWarningLevel;
    }

    public Tools.EarlyWarningProcessing getEarlyWarningProcessing() {
        return earlyWarningProcessing;
    }

    public void setEarlyWarningProcessing(Tools.EarlyWarningProcessing earlyWarningProcessing) {
        this.earlyWarningProcessing = earlyWarningProcessing;
    }

//    public String getImpactConditions() {
//        return impactConditions;
//    }
//
//    public void setImpactConditions(String impactConditions) {
//        this.impactConditions = impactConditions;
//    }
//
//    public void GetMessage() {
//        String earlyWarningLevelStr = earlyWarningLevel.toString();
//        String earlyWarningProcessingStr = earlyWarningProcessing.toString();
//
//        earlyWarningLevelStr = Tools.getEarlyWarningLevelDescription(earlyWarningLevelStr);
//        earlyWarningProcessingStr = Tools.getEarlyWarningProcessingDescription(earlyWarningProcessingStr);
//
//        if (impactConditions.endsWith("、")) {
//            impactConditions = impactConditions.substring(0, impactConditions.length() - 2);
//        }
//        String icStr = impactConditions;
//        if (StringUtils.isEmpty(impactConditions) || "一级预警：".equals(icStr)) {
//            icStr = "";
//        } else {
//            icStr = String.format("命中规则：%1$s", impactConditions);
//        }
//        impactConditions = String.format("%1$s%2$s%2$s%3$s%2$s%2$s%4$s", earlyWarningLevelStr, "\r\n", icStr,
//                StringUtils.isEmpty(earlyWarningProcessingStr) ? "" : "建议：".concat(earlyWarningProcessingStr));
//    }

    public WarningVO() {
    }

    public WarningVO(Tools.EarlyWarningLevel earlyWarningLevel,
                     Tools.EarlyWarningProcessing earlyWarningProcessing) {
        this.earlyWarningLevel = earlyWarningLevel;
        this.earlyWarningProcessing = earlyWarningProcessing;
    }
}
