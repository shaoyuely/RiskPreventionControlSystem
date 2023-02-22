<template>
  <div id="loginBG">
    <div class="title">企业财务风险防范与控制系统</div>
    <div class="container">
      <div class="header">{{ isLogin ? '登录' : '注册' }}</div>
      <div class="content">
        <el-form v-if="isLogin" :label-position="labelPosition" label-width="120px" :model="formLabelAlign">
          <el-form-item label="用户名">
            <el-input v-model="formLabelAlign.username" style="width:90%"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="formLabelAlign.password" style="width:90%" show-password></el-input>
          </el-form-item>
        </el-form>
        <el-form v-else :label-position="labelPosition" label-width="120px" :model="registForm">
          <el-form-item label="注册用户名">
            <el-input v-model="registForm.username" style="width:90%"></el-input>
          </el-form-item>
          <el-form-item label="注册密码">
            <el-input v-model="registForm.password" style="width:90%"></el-input>
          </el-form-item>
        </el-form>
      </div>

      <div>
        <div v-if="isLogin">
          <el-button @click="toLogin">登录</el-button>
          <el-button @click="isLogin = false">注册</el-button>
        </div>

        <div v-else>
          <el-button @click="toResiger">注册</el-button>
          <el-button @click="isLogin = true">返回</el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      labelPosition: "right",
      formLabelAlign: {
        username: "",
        password: ""
      },
      registForm: {
        username: "",
        password: ""
      },
      isLogin: true,
    };
  },
  methods: {
    toLogin() {
      this.$axios.post('/org/user/online', this.formLabelAlign).then(resp => {
        let isSuccess = true;
        if (resp.data) {
          if (resp.data.username && resp.data.token) {
            this.isLogin = true;
            this.isSuccess = true;
            this.$auth.setToken(resp.data.token)
            this.$auth.setUserName(resp.data.username)
            //如果登录成功 跳入计算页面
            this.$router.push({ path: "/calculate" });
          }
        }
        if (!this.isSuccess) {
          alert("登陆失败")
          //this.$message.warning('登录失败')
        }
      })
    },
    toResiger() {
      this.$axios.post('/org/user/insert', this.registForm
      ).then(res => {
        this.isLogin = false;
        if (res.data > 0) {
          alert("注册成功，等待审批")
        } else if (res.data == -2) {
          alert("该账号已存在")
        } else {
          alert("注册失败")
        }
      })
    }
  }
};
</script>

<style lang="scss" scoped>
.header {
  margin: 0px 0px 30px 0px;
  font-size: 24px;
  color: white;
}

.title {
  padding: 5px 20px;
  font-size: 36px;
  color: white;
}

.container {
  padding: 3%;
  background-color: rgb(175, 175, 175);
  border-radius: 30px;
  width: 600px;
  height: 300px;
  margin: 0 auto;
  text-align: center;
  position: absolute;
  top: 40%;
  left: 50%;
  transform: translate(-50%, -50%);
}
</style>