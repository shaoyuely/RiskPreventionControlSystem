<template>
  <div class="wrapper">
    <div class="title">
      <el-button style="float:right;margin: 5px 10px 0px 10px;" @click="toLogout">注销</el-button>
      <el-button v-if="this.showBtn" style="float:right;margin: 5px 10px 0px 10px;" @click="toFindlist">审批</el-button>
    </div>
    <div class="container">
      <el-form :label-position="labelPosition" :inline="true" label-width="180px" :model="formLabelAlign">
        <div class="infospan">
          <div class="spantitle">现金流量表数据</div>
          <el-form-item label="经营活动现金净流量：">
            <el-input type="number" v-model.number="formLabelAlign.netCashflowOperatingActivities"></el-input>
          </el-form-item>
          <el-form-item label="经营活动现金流入：">
            <el-input type="number" v-model.number="formLabelAlign.cashInflowOperatingActivities"></el-input>
          </el-form-item>
          <el-form-item label="筹资活动现金流入：">
            <el-input type="number" v-model.number="formLabelAlign.cashInflowFinancingActivities"></el-input>
          </el-form-item>
          <el-form-item label="总现金流入：">
            <el-input type="number" v-model.number="formLabelAlign.totalCashInflow"></el-input>
          </el-form-item>
          <el-form-item label="间接融资现金流入：">
            <el-input type="number" v-model.number="formLabelAlign.indirectFinancingCashInflow"></el-input>
          </el-form-item>
        </div>
        <div class="infospan">
          <div class="spantitle">债务数据</div>
          <el-form-item label="一年内到期债务：" prop="floatingDebt">
            <el-input type="number" v-model.number="formLabelAlign.floatingDebt"></el-input>
          </el-form-item>
          <el-form-item label="三年内到期债务：">
            <el-input type="number" v-model.number="formLabelAlign.mediumTermDebt"></el-input>
          </el-form-item>
          <el-form-item label="三年以上债务：">
            <el-input type="number" v-model.number="formLabelAlign.longTermDebt"></el-input>
          </el-form-item>
          <el-form-item label="短期负债：">
            <el-input type="number" v-model.number="formLabelAlign.shortTermLiabilities"></el-input>
          </el-form-item>
          <el-form-item label="总负债：">
            <el-input type="number" v-model.number="formLabelAlign.totalLiabilities"></el-input>
          </el-form-item>
        </div>
        <div class="infospan">
          <div class="spantitle">财务数据</div>
          <el-form-item label="资产负债率：">
            <el-input type="number" v-model.number="formLabelAlign.assetLiabilityRatio"></el-input>
          </el-form-item>
          <el-form-item label="销售收入：">
            <el-input type="number" v-model.number="formLabelAlign.salesRevenue"></el-input>
          </el-form-item>
          <el-form-item label="应收账款周转率：">
            <el-input type="number" v-model.number="formLabelAlign.turnoverRateAccountsReceivable"></el-input>
          </el-form-item>
          <el-form-item label="销售现金比率：">
            <el-input type="number" v-model.number="formLabelAlign.cashSalesRatio"></el-input>
          </el-form-item>
          <el-form-item label="行业平均负债率：">
            <el-input type="number" v-model.number="formLabelAlign.industryAverageDebtRatio"></el-input>
          </el-form-item>
        </div>
        <div class="infospan">
          <div class="spantitle">或有债务数据</div>
          <el-form-item label="对外担保总额：">
            <el-input type="number" v-model.number="formLabelAlign.totalExternalGuarantee"></el-input>
          </el-form-item>
          <el-form-item label="回购协议金额：">
            <el-input type="number" v-model.number="formLabelAlign.repurchaseAgreementAmount"></el-input>
          </el-form-item>
          <el-form-item label="对赌协议金额：">
            <el-input type="number" v-model.number="formLabelAlign.amountGamblingAgreement"></el-input>
          </el-form-item>
          <el-form-item label="违约担保额：">
            <el-input type="number" v-model.number="formLabelAlign.defaultGuaranteeAmount"></el-input>
          </el-form-item>
          <el-form-item label="一年以内回购金额：">
            <el-input type="number" v-model.number="formLabelAlign.repurchaseAmount"></el-input>
          </el-form-item>
        </div>
        <div style="width:100%;text-align: center;">
          <el-form-item>
            <el-button @click="toSubmit">提交</el-button>
            <div class="showmessage">{{ warningMessage }}</div>
          </el-form-item>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      labelPosition: "right",
      warningMessage: "",
      showColor: "#00C800",
      formLabelAlign: {
        netCashflowOperatingActivities: "",
        cashInflowOperatingActivities: "",
        cashInflowFinancingActivities: "",
        totalCashInflow: "",
        indirectFinancingCashInflow: "",

        floatingDebt: "",
        mediumTermDebt: "",
        longTermDebt: "",
        shortTermLiabilities: "",
        totalLiabilities: "",

        assetLiabilityRatio: "",
        salesRevenue: "",
        turnoverRateAccountsReceivable: "",
        cashSalesRatio: "",
        industryAverageDebtRatio: "",

        totalExternalGuarantee: "",
        repurchaseAgreementAmount: "",
        amountGamblingAgreement: "",
        defaultGuaranteeAmount: "",
        repurchaseAmount: ""
      },
      showBtn: false
    };
  },
  computed: {
  },
  methods: {
    toSubmit() {
      let param = {
        netCashflowOperatingActivities: setDefault(this.formLabelAlign.netCashflowOperatingActivities),
        cashInflowOperatingActivities: setDefault(this.formLabelAlign.cashInflowOperatingActivities),
        cashInflowFinancingActivities: setDefault(this.formLabelAlign.cashInflowFinancingActivities),
        totalCashInflow: setDefault(this.formLabelAlign.totalCashInflow),
        indirectFinancingCashInflow: setDefault(this.formLabelAlign.indirectFinancingCashInflow),

        floatingDebt: setDefault(this.formLabelAlign.floatingDebt),
        mediumTermDebt: setDefault(this.formLabelAlign.mediumTermDebt),
        longTermDebt: setDefault(this.formLabelAlign.longTermDebt),
        shortTermLiabilities: setDefault(this.formLabelAlign.shortTermLiabilities),
        totalLiabilities: setDefault(this.formLabelAlign.totalLiabilities),

        assetLiabilityRatio: setDefault(this.formLabelAlign.assetLiabilityRatio),
        salesRevenue: setDefault(this.formLabelAlign.salesRevenue),
        turnoverRateAccountsReceivable: setDefault(this.formLabelAlign.turnoverRateAccountsReceivable),
        cashSalesRatio: setDefault(this.formLabelAlign.cashSalesRatio),
        industryAverageDebtRatio: setDefault(this.formLabelAlign.industryAverageDebtRatio),

        totalExternalGuarantee: setDefault(this.formLabelAlign.totalExternalGuarantee),
        repurchaseAgreementAmount: setDefault(this.formLabelAlign.repurchaseAgreementAmount),
        amountGamblingAgreement: setDefault(this.formLabelAlign.amountGamblingAgreement),
        defaultGuaranteeAmount: setDefault(this.formLabelAlign.defaultGuaranteeAmount),
        repurchaseAmount: setDefault(this.formLabelAlign.repurchaseAmount)
      }
      this.$axios.post('/org/calculate/calculateresult', param
      ).then(res => {
        let earlyWarningLevel = res.data.earlyWarningLevel
        // let earlyWarningProcessing = res.data.earlyWarningProcessing
        switch (earlyWarningLevel) {
          case "LEVEL_ONE":
            this.showColor = "#F8C000"
            break
          case "LEVEL_TWO":
            this.showColor = "#F89800"
            break
          case "LEVEL_THREE":
            this.showColor = "#F86800"
            break
          case "LEVEL_FOUR":
            this.showColor = "#F80000"
            break
          default:
            this.showColor = "#00C800"
            break
        }
        this.warningMessage = res.data.impactConditions
      })
    }, toFindlist() {
      this.$router.push({ path: "/manage" });
    }, toLogout() {
      this.$auth.removeToken()
      this.$auth.removeUserName()
      this.$router.push({ path: "/login" });
    }
  }, created() {
    this.showBtn = (this.$auth.getUserName() == "root")
  }
};
function setDefault(val) {
  if (val == "") {
    return "0";
  }
  return val;
}
</script>

<style lang="scss" scoped>
.wrapper {
  .container {
    .el-form-item {
      width: auto;
    }
  }
}

.message {
  color: v-bind(showColor);
}
</style>