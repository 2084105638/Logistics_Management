<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="关联用户ID" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入关联用户ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="司机工号" prop="jobNumber">
        <el-input
          v-model="queryParams.jobNumber"
          placeholder="请输入司机工号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="驾驶证号" prop="licenseNo">
        <el-input
          v-model="queryParams.licenseNo"
          placeholder="请输入驾驶证号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="领证日期" prop="licenseDate">
        <el-date-picker clearable
          v-model="queryParams.licenseDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择领证日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="状态：1在职 0休息" prop="state">
        <el-input
          v-model="queryParams.state"
          placeholder="请输入状态：1在职 0休息"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['LT:driver:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['LT:driver:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['LT:driver:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['LT:driver:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="driverList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="司机ID" align="center" prop="id" />
      <el-table-column label="关联用户ID" align="center" prop="userId" />
      <el-table-column label="司机工号" align="center" prop="jobNumber" />
      <el-table-column label="驾驶证号" align="center" prop="licenseNo" />
      <el-table-column label="驾驶证类型" align="center" prop="licenseType" />
      <el-table-column label="领证日期" align="center" prop="licenseDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.licenseDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="状态：1在职 0休息" align="center" prop="state" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['LT:driver:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['LT:driver:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改司机信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="关联用户ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入关联用户ID" />
        </el-form-item>
        <el-form-item label="司机工号" prop="jobNumber">
          <el-input v-model="form.jobNumber" placeholder="请输入司机工号" />
        </el-form-item>
        <el-form-item label="驾驶证号" prop="licenseNo">
          <el-input v-model="form.licenseNo" placeholder="请输入驾驶证号" />
        </el-form-item>
        <el-form-item label="领证日期" prop="licenseDate">
          <el-date-picker clearable
            v-model="form.licenseDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择领证日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="状态：1在职 0休息" prop="state">
          <el-input v-model="form.state" placeholder="请输入状态：1在职 0休息" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDriver, getDriver, delDriver, addDriver, updateDriver } from "@/api/LT/driver"

export default {
  name: "Driver",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 司机信息表格数据
      driverList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        jobNumber: null,
        licenseNo: null,
        licenseType: null,
        licenseDate: null,
        state: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userId: [
          { required: true, message: "关联用户ID不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询司机信息列表 */
    getList() {
      this.loading = true
      listDriver(this.queryParams).then(response => {
        this.driverList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        userId: null,
        jobNumber: null,
        licenseNo: null,
        licenseType: null,
        licenseDate: null,
        state: null,
        createTime: null,
        updateTime: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加司机信息"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getDriver(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改司机信息"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateDriver(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addDriver(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids
      this.$modal.confirm('是否确认删除司机信息编号为"' + ids + '"的数据项？').then(function() {
        return delDriver(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('LT/driver/export', {
        ...this.queryParams
      }, `driver_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
