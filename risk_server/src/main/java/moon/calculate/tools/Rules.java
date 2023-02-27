package moon.calculate.tools;

import moon.calculate.models.DataVO;
import moon.calculate.models.WarningVO;

public class Rules {

    private DataVO dataVO;

    public Rules(DataVO dataVO) {
        this.dataVO = dataVO;
    }

    public WarningVO warning() {
        WarningVO result = new WarningVO();
        return WarningLeveOne(result);
    }

    /**
     * 短期偿债比率
     */
    public Double getShortTermDebtServiceRatio() {
        if (dataVO.getFloatingDebt() != 0) {
            return (dataVO.getNetCashflowOperatingActivities() / dataVO.getFloatingDebt()) * 100;
        }
        return 0.00;
    }

    /**
     * 短期负债占比
     */
    public Double getProportionShortTermLiabilities() {
        if (dataVO.getTotalLiabilities() != 0) {
            return (dataVO.getShortTermLiabilities() / dataVO.getTotalLiabilities()) * 100;
        }
        return 0.00;
    }

    /**
     * 中期偿债比率
     */
    public Double getMediumTermDebtServiceRatio() {
        if (dataVO.getMediumTermDebt() != 0) {
            return (dataVO.getNetCashflowOperatingActivities() / dataVO.getMediumTermDebt()) * 100;
        }
        return 0.00;
    }

    /**
     * 长期偿债比率
     */
    public Double getLongTermDebtServiceRatio() {
        if (dataVO.getLongTermDebt() != 0) {
            return (dataVO.getNetCashflowOperatingActivities() / dataVO.getLongTermDebt()) * 100;
        }
        return 0.00;
    }

    /**
     * 经营活动现金占比
     */
    public Double getProportionCashOperatingActivities() {
        if (dataVO.getTotalCashInflow() != 0) {
            return (dataVO.getCashInflowOperatingActivities() / dataVO.getTotalCashInflow()) * 100;
        }
        return 0.00;
    }

    /**
     * 销售现金比率
     */
    public Double getCashSalesRatio() {
        if (dataVO.getSalesRevenue() != 0) {
            return (dataVO.getCashInflowOperatingActivities() / dataVO.getSalesRevenue()) * 100;
        }
        return 0.00;
    }

    /**
     * 筹资活动现金占比
     */
    public Double getProportionCashFinancingActivities() {
        if (dataVO.getTotalCashInflow() != 0) {
            return (dataVO.getCashInflowFinancingActivities() / dataVO.getTotalCashInflow()) * 100;
        }
        return 0.00;
    }

    /**
     * 间接融资比率
     */
    public Double getIndirectFinancingRatio() {
        if (dataVO.getCashInflowFinancingActivities() != 0) {
            return (dataVO.getIndirectFinancingCashInflow() / dataVO.getCashInflowFinancingActivities()) * 100;
        }
        return 0.00;
    }

    /**
     * 或有债务比率
     */
    public Double getContingentDebtRatio() {
        if (dataVO.getTotalLiabilities() != 0) {
            return (dataVO.getContingentLiabilities() / dataVO.getTotalLiabilities()) * 100;
        }
        return 0.00;
    }

    /**
     * 违约担保系数
     */
    public Double getDefaultGuaranteeCoefficient() {
        if (dataVO.getCashInflowOperatingActivities() != 0) {
            return (dataVO.getDefaultGuaranteeAmount() / dataVO.getCashInflowOperatingActivities()) * 100;
        }
        return 0.00;
    }

    /**
     * 一年以内回购债务系数
     */
    public Double getRepurchaseDebtCoefficient() {
        if (dataVO.getCashInflowOperatingActivities() != 0) {
            return (dataVO.getRepurchaseAmount() / dataVO.getCashInflowOperatingActivities()) * 100;
        }
        return 0.00;
    }

    /**
     * 一级预警
     *
     * @param result
     * @return
     */
    private WarningVO WarningLeveOne(WarningVO result) {
        int weight = 0;
//        String impactConditions = "一级预警：";
        //阈值:长期偿债比率≤10%
        if (getLongTermDebtServiceRatio() != null &&
                getLongTermDebtServiceRatio() <= dataVO.getLongTermDebtServiceRatioMax()) {
//            impactConditions += String.format("长期偿债比率≤10%%（%.4f%%）、", getLongTermDebtServiceRatio());
            weight++;
        }
        //阈值:资产负债率≥行业平均负债率
        if ((dataVO.getAssetLiabilityRatio() != 0 && dataVO.getIndustryAverageDebtRatio() != 0) &&
                dataVO.getAssetLiabilityRatio() >= dataVO.getIndustryAverageDebtRatio()) {
//            impactConditions += String.format("资产负债率≥行业平均负债率（%s）、",
//                    Double.toString(dataVO.getAssetLiabilityRatio()).concat("≥").concat(Double.toString(dataVO.getIndustryAverageDebtRatio())));
            weight++;
        }

//        result.setImpactConditions(trimEnd(impactConditions, "、"));
        if (weight == 1) {
            result.setEarlyWarningLevel(Tools.EarlyWarningLevel.LEVEL_ONE);
            result.setEarlyWarningProcessing(Tools.EarlyWarningProcessing.LEVEL_ONE);
            return result;
        } else if (weight == 2) {
            return WarningLeveTwo(result);
        } else {
            result.setEarlyWarningLevel(Tools.EarlyWarningLevel.NONE);
            result.setEarlyWarningProcessing(Tools.EarlyWarningProcessing.NONE);
            return result;
        }
    }

    /**
     * 二级预警
     *
     * @param result
     * @return
     */
    private WarningVO WarningLeveTwo(WarningVO result) {
        int weight = 0;
//        String impactConditions = trimEnd(result.getImpactConditions(), "、") + "\r\n" + "二级预警：";
        //阈值:中期偿债比率≤20%
        if (getMediumTermDebtServiceRatio() != null && getMediumTermDebtServiceRatio() <= dataVO.getMediumTermDebtServiceRatioMax()) {
//            impactConditions += String.format("中期偿债比率≤20%%（%.4f%%）、", getMediumTermDebtServiceRatio());
            weight++;
        }
        //阈值:短期负债占比≥70%
        if (getProportionShortTermLiabilities() != null && getProportionShortTermLiabilities() >= dataVO.getProportionShortTermLiabilitiesMin()) {
//            impactConditions += String.format("短期负债占比≥70%%（%.4f%%）、", getProportionShortTermLiabilities());
            weight++;
        }
        //阈值:经营活动现金占比≤60%
        if (getProportionCashOperatingActivities() != null && getProportionCashOperatingActivities() <= dataVO.getProportionCashOperatingActivitiesMax()) {
//            impactConditions += String.format("经营活动现金占比≤60%%（%.4f%%）、", getProportionCashOperatingActivities());
            weight++;
        }
        //阈值:间接融资比率≥80%
        if (getIndirectFinancingRatio() != null && getIndirectFinancingRatio() >= dataVO.getIndirectFinancingRatioMin()) {
//            impactConditions += String.format("间接融资比率≥80%%（%.4f%%）、", getIndirectFinancingRatio());
            weight++;
        }

//        result.setImpactConditions(trimEnd(impactConditions, "、"));
        if (weight == 1) {
            result.setEarlyWarningLevel(Tools.EarlyWarningLevel.LEVEL_TWO);
            result.setEarlyWarningProcessing(Tools.EarlyWarningProcessing.LEVEL_TWO);
            return result;
        } else if (weight == 2) {
            return WarningLeveThree(result);
        } else if (weight >= 3) {
            result.setEarlyWarningLevel(Tools.EarlyWarningLevel.LEVEL_FOUR);
            result.setEarlyWarningProcessing(Tools.EarlyWarningProcessing.LEVEL_FOUR);
            return result;
        } else {
            result.setEarlyWarningLevel(Tools.EarlyWarningLevel.LEVEL_TWO);
            result.setEarlyWarningProcessing(Tools.EarlyWarningProcessing.LEVEL_TWO);
            return result;
        }
    }

    /**
     * 三级预警
     *
     * @param result
     * @return
     */
    private WarningVO WarningLeveThree(WarningVO result) {
        int weight = 0;
//        String impactConditions = trimEnd(result.getImpactConditions(), "、") + "<\r\n" + "三级预警：";
        //阈值:销售现金比率≤50%
        if (getCashSalesRatio() != null && getCashSalesRatio() <= dataVO.getCashSalesRatioMax()) {
//            impactConditions += String.format("销售现金比率≤50%%（%.4f%%）、", getCashSalesRatio());
            weight++;
        }
        //阈值:筹资活动现金占比≥60%
        if (getProportionCashFinancingActivities() != null && getProportionCashFinancingActivities() >= dataVO.getProportionCashFinancingActivitiesMin()) {
//            impactConditions += String.format("筹资活动现金占比≥60%%（%.4f%%）、", getProportionCashFinancingActivities());
            weight++;
        }
        //阈值:或有债务比率≥50%
        if (getContingentDebtRatio() != null && getContingentDebtRatio() >= dataVO.getContingentDebtRatioMin()) {
//            impactConditions += String.format("或有债务比率≥50%%（%.4f%%）、", getContingentDebtRatio());
            weight++;
        }

//        result.setImpactConditions(trimEnd(impactConditions, "、"));
        if (weight == 1) {
            result.setEarlyWarningLevel(Tools.EarlyWarningLevel.LEVEL_THREE);
            result.setEarlyWarningProcessing(Tools.EarlyWarningProcessing.LEVEL_THREE);
            return result;
        } else if (weight == 2) {
            return WarningLeveFour(result);
        } else if (weight >= 3) {
            result.setEarlyWarningLevel(Tools.EarlyWarningLevel.LEVEL_FOUR);
            result.setEarlyWarningProcessing(Tools.EarlyWarningProcessing.LEVEL_FOUR);
            return result;
        } else {
            result.setEarlyWarningLevel(Tools.EarlyWarningLevel.LEVEL_THREE);
            result.setEarlyWarningProcessing(Tools.EarlyWarningProcessing.LEVEL_THREE);
            return result;
        }
    }

    /**
     * 四级预警
     *
     * @param result
     * @return
     */
    private WarningVO WarningLeveFour(WarningVO result) {
        int weight = 0;
//        String impactConditions = trimEnd(result.getImpactConditions(), "、") + "\r\n" + "四级预警：";
        //阈值:短期偿债比率≤30%
        if (getShortTermDebtServiceRatio() != null && getShortTermDebtServiceRatio() <= dataVO.getShortTermDebtServiceRatioMax()) {
//            impactConditions += String.format("短期偿债比率≤30%%（%.4f%%）、", getShortTermDebtServiceRatio());
            weight++;
        }
        //阈值:违约担保系数≥30%
        if (getDefaultGuaranteeCoefficient() != null && getDefaultGuaranteeCoefficient() >= dataVO.getDefaultGuaranteeCoefficientMin()) {
//            impactConditions += String.format("违约担保系数≥30%%（%.4f%%）、", getDefaultGuaranteeCoefficient());
            weight++;
        }
        //阈值:一年以内回购债务系数≥40%
        if (getRepurchaseDebtCoefficient() != null && getRepurchaseDebtCoefficient() >= dataVO.getRepurchaseDebtCoefficientMin()) {
//            impactConditions += String.format("一年以内回购债务系数≥40%%（%.4f%%）、", getRepurchaseDebtCoefficient());
            weight++;
        }

//        result.setImpactConditions(trimEnd(impactConditions, "、"));
        if (weight == 1 || weight == 2 || weight == 3) {
            result.setEarlyWarningLevel(Tools.EarlyWarningLevel.LEVEL_FOUR);
            result.setEarlyWarningProcessing(Tools.EarlyWarningProcessing.LEVEL_FOUR);
            return result;
        } else {
            result.setEarlyWarningLevel(Tools.EarlyWarningLevel.LEVEL_FOUR);
            result.setEarlyWarningProcessing(Tools.EarlyWarningProcessing.LEVEL_FOUR);
            return result;
        }
    }

    /**
     * 去除尾部特定符号
     *
     * @param val
     * @param checkStr
     * @return
     */
    private String trimEnd(String val, String checkStr) {
        if (val.endsWith(checkStr)) {
            return val.substring(0, val.length() - checkStr.length());
        }
        return val;
    }
}
