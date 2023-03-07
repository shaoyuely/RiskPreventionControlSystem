package moon.calculate.models;

public class DataVO {

    //CashFlowData
    //经营活动现金净流量
    private double netCashflowOperatingActivities;
    //经营活动现金流入
    private double cashInflowOperatingActivities;
    //筹资活动现金流入
    private double cashInflowFinancingActivities;
    //总现金流入
    private double totalCashInflow;
    //间接融资现金流入
    private double indirectFinancingCashInflow;

    //ContingentDebtData
    //对外担保总额
    private double totalExternalGuarantee;
    //回购协议金额
    private double repurchaseAgreementAmount;
    //对赌协议金额
    private double amountGamblingAgreement;
    //违约担保额
    private double defaultGuaranteeAmount;
    //一年以内回购金额
    private double repurchaseAmount;

    //DebtData
    //一年内到期债务
    private double floatingDebt;
    //三年内到期债务
    private double mediumTermDebt;
    //三年以上债务
    private double longTermDebt;
    //短期负债
    private double shortTermLiabilities;
    //总负债
    private double totalLiabilities;

    //FinancialData
    //资产负债率
    private double assetLiabilityRatio;
    //销售收入
    private double salesRevenue;
    //应收账款周转率
    private double turnoverRateAccountsReceivable;
    //销售现金比率
    private double cashSalesRatio;
    //行业平均负债率
    private double industryAverageDebtRatio;

    //一级预警阈值
    private double longTermDebtServiceRatioMax;//阈值:长期偿债比率≤10%

    //二级预警阈值
    private double mediumTermDebtServiceRatioMax;//阈值:中期偿债比率≤20%
    private double proportionShortTermLiabilitiesMin;//阈值:短期负债占比≥70%
    private double proportionCashOperatingActivitiesMax;//阈值:经营活动现金占比≤60%
    private double indirectFinancingRatioMin;//阈值:间接融资比率≥80%

    //三级预警阈值
    private double cashSalesRatioMax;//阈值:销售现金比率≤50%
    private double proportionCashFinancingActivitiesMin;//阈值:筹资活动现金占比≥60%
    private double contingentDebtRatioMin;//阈值:或有债务比率≥50%

    //四级预警阈值
    private double shortTermDebtServiceRatioMax;//阈值:短期偿债比率≤30%
    private double defaultGuaranteeCoefficientMin;//阈值:违约担保系数≥30%
    private double repurchaseDebtCoefficientMin;//阈值:一年以内回购债务系数≥40%

    private String showContent;
    private String showColor;

    public double getNetCashflowOperatingActivities() {
        return netCashflowOperatingActivities;
    }

    public void setNetCashflowOperatingActivities(double netCashflowOperatingActivities) {
        this.netCashflowOperatingActivities = netCashflowOperatingActivities;
    }

    public double getCashInflowOperatingActivities() {
        return cashInflowOperatingActivities;
    }

    public void setCashInflowOperatingActivities(double cashInflowOperatingActivities) {
        this.cashInflowOperatingActivities = cashInflowOperatingActivities;
    }

    public double getCashInflowFinancingActivities() {
        return cashInflowFinancingActivities;
    }

    public void setCashInflowFinancingActivities(double cashInflowFinancingActivities) {
        this.cashInflowFinancingActivities = cashInflowFinancingActivities;
    }

    public double getTotalCashInflow() {
        return totalCashInflow;
    }

    public void setTotalCashInflow(double totalCashInflow) {
        this.totalCashInflow = totalCashInflow;
    }

    public double getIndirectFinancingCashInflow() {
        return indirectFinancingCashInflow;
    }

    public void setIndirectFinancingCashInflow(double indirectFinancingCashInflow) {
        this.indirectFinancingCashInflow = indirectFinancingCashInflow;
    }

    public double getTotalExternalGuarantee() {
        return totalExternalGuarantee;
    }

    public void setTotalExternalGuarantee(double totalExternalGuarantee) {
        this.totalExternalGuarantee = totalExternalGuarantee;
    }

    public double getRepurchaseAgreementAmount() {
        return repurchaseAgreementAmount;
    }

    public void setRepurchaseAgreementAmount(double repurchaseAgreementAmount) {
        this.repurchaseAgreementAmount = repurchaseAgreementAmount;
    }

    public double getAmountGamblingAgreement() {
        return amountGamblingAgreement;
    }

    public void setAmountGamblingAgreement(double amountGamblingAgreement) {
        this.amountGamblingAgreement = amountGamblingAgreement;
    }

    public double getDefaultGuaranteeAmount() {
        return defaultGuaranteeAmount;
    }

    public void setDefaultGuaranteeAmount(double defaultGuaranteeAmount) {
        this.defaultGuaranteeAmount = defaultGuaranteeAmount;
    }

    public double getRepurchaseAmount() {
        return repurchaseAmount;
    }

    public void setRepurchaseAmount(double repurchaseAmount) {
        this.repurchaseAmount = repurchaseAmount;
    }

    public double getFloatingDebt() {
        return floatingDebt;
    }

    public void setFloatingDebt(double floatingDebt) {
        this.floatingDebt = floatingDebt;
    }

    public double getMediumTermDebt() {
        return mediumTermDebt;
    }

    public void setMediumTermDebt(double mediumTermDebt) {
        this.mediumTermDebt = mediumTermDebt;
    }

    public double getLongTermDebt() {
        return longTermDebt;
    }

    public void setLongTermDebt(double longTermDebt) {
        this.longTermDebt = longTermDebt;
    }

    public double getShortTermLiabilities() {
        return shortTermLiabilities;
    }

    public void setShortTermLiabilities(double shortTermLiabilities) {
        this.shortTermLiabilities = shortTermLiabilities;
    }

    public double getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(double totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    public double getAssetLiabilityRatio() {
        return assetLiabilityRatio;
    }

    public void setAssetLiabilityRatio(double assetLiabilityRatio) {
        this.assetLiabilityRatio = assetLiabilityRatio;
    }

    public double getSalesRevenue() {
        return salesRevenue;
    }

    public void setSalesRevenue(double salesRevenue) {
        this.salesRevenue = salesRevenue;
    }

    public double getTurnoverRateAccountsReceivable() {
        return turnoverRateAccountsReceivable;
    }

    public void setTurnoverRateAccountsReceivable(double turnoverRateAccountsReceivable) {
        this.turnoverRateAccountsReceivable = turnoverRateAccountsReceivable;
    }

    public double getCashSalesRatio() {
        return cashSalesRatio;
    }

    public void setCashSalesRatio(double cashSalesRatio) {
        this.cashSalesRatio = cashSalesRatio;
    }

    public double getIndustryAverageDebtRatio() {
        return industryAverageDebtRatio;
    }

    public void setIndustryAverageDebtRatio(double industryAverageDebtRatio) {
        this.industryAverageDebtRatio = industryAverageDebtRatio;
    }

    public String getShowContent() {
        return showContent;
    }

    public void setShowContent(String showContent) {
        this.showContent = showContent;
    }

    public String getShowColor() {
        return showColor;
    }

    public void setShowColor(String showColor) {
        this.showColor = showColor;
    }

    public double getLongTermDebtServiceRatioMax() {
        return longTermDebtServiceRatioMax;
    }

    public void setLongTermDebtServiceRatioMax(double longTermDebtServiceRatioMax) {
        this.longTermDebtServiceRatioMax = longTermDebtServiceRatioMax;
    }

    public double getMediumTermDebtServiceRatioMax() {
        return mediumTermDebtServiceRatioMax;
    }

    public void setMediumTermDebtServiceRatioMax(double mediumTermDebtServiceRatioMax) {
        this.mediumTermDebtServiceRatioMax = mediumTermDebtServiceRatioMax;
    }

    public double getProportionShortTermLiabilitiesMin() {
        return proportionShortTermLiabilitiesMin;
    }

    public void setProportionShortTermLiabilitiesMin(double proportionShortTermLiabilitiesMin) {
        this.proportionShortTermLiabilitiesMin = proportionShortTermLiabilitiesMin;
    }

    public double getProportionCashOperatingActivitiesMax() {
        return proportionCashOperatingActivitiesMax;
    }

    public void setProportionCashOperatingActivitiesMax(double proportionCashOperatingActivitiesMax) {
        this.proportionCashOperatingActivitiesMax = proportionCashOperatingActivitiesMax;
    }

    public double getIndirectFinancingRatioMin() {
        return indirectFinancingRatioMin;
    }

    public void setIndirectFinancingRatioMin(double indirectFinancingRatioMin) {
        this.indirectFinancingRatioMin = indirectFinancingRatioMin;
    }

    public double getCashSalesRatioMax() {
        return cashSalesRatioMax;
    }

    public void setCashSalesRatioMax(double cashSalesRatioMax) {
        this.cashSalesRatioMax = cashSalesRatioMax;
    }

    public double getProportionCashFinancingActivitiesMin() {
        return proportionCashFinancingActivitiesMin;
    }

    public void setProportionCashFinancingActivitiesMin(double proportionCashFinancingActivitiesMin) {
        this.proportionCashFinancingActivitiesMin = proportionCashFinancingActivitiesMin;
    }

    public double getContingentDebtRatioMin() {
        return contingentDebtRatioMin;
    }

    public void setContingentDebtRatioMin(double contingentDebtRatioMin) {
        this.contingentDebtRatioMin = contingentDebtRatioMin;
    }

    public double getShortTermDebtServiceRatioMax() {
        return shortTermDebtServiceRatioMax;
    }

    public void setShortTermDebtServiceRatioMax(double shortTermDebtServiceRatioMax) {
        this.shortTermDebtServiceRatioMax = shortTermDebtServiceRatioMax;
    }

    public double getDefaultGuaranteeCoefficientMin() {
        return defaultGuaranteeCoefficientMin;
    }

    public void setDefaultGuaranteeCoefficientMin(double defaultGuaranteeCoefficientMin) {
        this.defaultGuaranteeCoefficientMin = defaultGuaranteeCoefficientMin;
    }

    public double getRepurchaseDebtCoefficientMin() {
        return repurchaseDebtCoefficientMin;
    }

    public void setRepurchaseDebtCoefficientMin(double repurchaseDebtCoefficientMin) {
        this.repurchaseDebtCoefficientMin = repurchaseDebtCoefficientMin;
    }

    /**
     * 或有债务
     *
     * @return
     */
    public double getContingentLiabilities() {
        double sum = totalExternalGuarantee + repurchaseAgreementAmount + amountGamblingAgreement;
        return sum == 0 ? null : sum;
    }
}
