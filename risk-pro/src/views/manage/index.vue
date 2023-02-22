<template>
    <div>
        <div class="title">
            <el-button style="float:right;margin: 5px 10px 0px 10px;" @click="toLogout">注销</el-button>
            <el-button style="float:right;margin: 5px 10px 0px 10px;" @click="toCalculate">计算</el-button>
        </div>
        <el-table :data="tableData" border style="width: 100%">
            <template slot="empty">
                <div>暂无数据</div>
            </template>
            <el-table-column fixed prop="username" label="用户名">
            </el-table-column>
            <el-table-column fixed="right" prop="status" label="操作" width="100">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row, true)" type="text" size="small">同意</el-button>
                    <el-button @click="handleClick(scope.row, false)" type="text" size="small">驳回</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>
<script>
export default {
    data() {
        return {
            tableData: [{
                id: "",
                username: ""
            }],
            findUser: {
                status: "0"
            },
            updateUser: {
                id: "",
                status: "1"
            }
        }
    },
    methods: {
        handleClick(row, result) {
            this.updateUser.id = row.id;
            if (result) {
                this.$axios.post('/org/user/update', this.updateUser
                ).then(res => {
                    this.updateList()
                    if (res.data > 0) {
                        alert("审批成功")
                    }
                })
            } else {
                this.$axios.post('/org/user/delete', this.updateUser
                ).then(res => {
                    this.updateList()
                })
            }
        },
        updateList() {
            this.$axios.post('/org/user/findlist', this.findUser
            ).then(res => {
                this.isLogin = false;
                if (res.data && res.data.length > 0) {
                    this.tableData = res.data;
                }
            })
        }, toCalculate() {
            this.$router.push({ path: "/calculate" });
        }, toLogout() {
            this.$auth.removeToken()
            this.$auth.removeUserName()
            this.$router.push({ path: "/login" });
        }
    },
    created() {
        this.updateList();
    }
}
</script>