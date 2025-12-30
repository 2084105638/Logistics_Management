<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="运单编号" prop="waybillNo">
        <el-input
          v-model="queryParams.waybillNo"
          placeholder="请输入运单编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="货主ID" prop="shipperId">
        <el-input
          v-model="queryParams.shipperId"
          placeholder="请输入货主ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="调度员ID" prop="dispatcherId">
        <el-input
          v-model="queryParams.dispatcherId"
          placeholder="请输入调度员ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="司机ID" prop="driverId">
        <el-input
          v-model="queryParams.driverId"
          placeholder="请输入司机ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车辆ID" prop="vehicleId">
        <el-input
          v-model="queryParams.vehicleId"
          placeholder="请输入车辆ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="货物描述" prop="cargoInfo">
        <el-input
          v-model="queryParams.cargoInfo"
          placeholder="请输入货物描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="重量" prop="weight">
        <el-input
          v-model="queryParams.weight"
          placeholder="请输入重量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="体积" prop="volume">
        <el-input
          v-model="queryParams.volume"
          placeholder="请输入体积"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发货人" prop="senderName">
        <el-input
          v-model="queryParams.senderName"
          placeholder="请输入发货人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发货人电话" prop="senderPhone">
        <el-input
          v-model="queryParams.senderPhone"
          placeholder="请输入发货人电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发货地址" prop="senderAddress">
        <el-input
          v-model="queryParams.senderAddress"
          placeholder="请输入发货地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收货人" prop="receiverName">
        <el-input
          v-model="queryParams.receiverName"
          placeholder="请输入收货人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收货人电话" prop="receiverPhone">
        <el-input
          v-model="queryParams.receiverPhone"
          placeholder="请输入收货人电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收货地址" prop="receiverAddress">
        <el-input
          v-model="queryParams.receiverAddress"
          placeholder="请输入收货地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="期望到达时间" prop="expectedTime">
        <el-date-picker clearable
          v-model="queryParams.expectedTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择期望到达时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="开始运输时间" prop="pickupTime">
        <el-date-picker clearable
          v-model="queryParams.pickupTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择开始运输时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="完成时间" prop="finishTime">
        <el-date-picker clearable
          v-model="queryParams.finishTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择完成时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="运费" prop="fee">
        <el-input
          v-model="queryParams.fee"
          placeholder="请输入运费"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否支付：0否 1是" prop="paid">
        <el-input
          v-model="queryParams.paid"
          placeholder="请输入是否支付：0否 1是"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="支付时间" prop="payTime">
        <el-date-picker clearable
          v-model="queryParams.payTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择支付时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="电子回单路径" prop="receiptPath">
        <el-input
          v-model="queryParams.receiptPath"
          placeholder="请输入电子回单路径"
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
          v-hasPermi="['LT:waybill:add']"
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
          v-hasPermi="['LT:waybill:edit']"
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
          v-hasPermi="['LT:waybill:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['LT:waybill:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="waybillList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="运单ID" align="center" prop="id" />
      <el-table-column label="运单编号" align="center" prop="waybillNo" />
      <el-table-column label="货主ID" align="center" prop="shipperId" />
      <el-table-column label="调度员ID" align="center" prop="dispatcherId" />
      <el-table-column label="司机ID" align="center" prop="driverId" />
      <el-table-column label="车辆ID" align="center" prop="vehicleId" />
      <el-table-column label="货物描述" align="center" prop="cargoInfo" />
      <el-table-column label="重量" align="center" prop="weight" />
      <el-table-column label="体积" align="center" prop="volume" />
      <el-table-column label="发货人" align="center" prop="senderName" />
      <el-table-column label="发货人电话" align="center" prop="senderPhone" />
      <el-table-column label="发货地址" align="center" prop="senderAddress" />
      <el-table-column label="收货人" align="center" prop="receiverName" />
      <el-table-column label="收货人电话" align="center" prop="receiverPhone" />
      <el-table-column label="收货地址" align="center" prop="receiverAddress" />
      <el-table-column label="期望到达时间" align="center" prop="expectedTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.expectedTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="开始运输时间" align="center" prop="pickupTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.pickupTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="完成时间" align="center" prop="finishTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.finishTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="状态：0待派车 1运输中 2已完成" align="center" prop="status" />
      <el-table-column label="运费" align="center" prop="fee" />
      <el-table-column label="是否支付：0否 1是" align="center" prop="paid" />
      <el-table-column label="支付时间" align="center" prop="payTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.payTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="电子回单路径" align="center" prop="receiptPath" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['LT:waybill:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['LT:waybill:remove']"
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

    <!-- 添加或修改运单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="运单编号" prop="waybillNo">
          <el-input v-model="form.waybillNo" placeholder="请输入运单编号" />
        </el-form-item>
        <el-form-item label="货主ID" prop="shipperId">
          <el-input v-model="form.shipperId" placeholder="请输入货主ID" />
        </el-form-item>
        <el-form-item label="调度员ID" prop="dispatcherId">
          <el-input v-model="form.dispatcherId" placeholder="请输入调度员ID" />
        </el-form-item>
        <el-form-item label="司机ID" prop="driverId">
          <el-input v-model="form.driverId" placeholder="请输入司机ID" />
        </el-form-item>
        <el-form-item label="车辆ID" prop="vehicleId">
          <el-input v-model="form.vehicleId" placeholder="请输入车辆ID" />
        </el-form-item>
        <el-form-item label="货物描述" prop="cargoInfo">
          <el-input v-model="form.cargoInfo" placeholder="请输入货物描述" />
        </el-form-item>
        <el-form-item label="重量" prop="weight">
          <el-input v-model="form.weight" placeholder="请输入重量" />
        </el-form-item>
        <el-form-item label="体积" prop="volume">
          <el-input v-model="form.volume" placeholder="请输入体积" />
        </el-form-item>
        <el-form-item label="发货人" prop="senderName">
          <el-input v-model="form.senderName" placeholder="请输入发货人" />
        </el-form-item>
        <el-form-item label="发货人电话" prop="senderPhone">
          <el-input v-model="form.senderPhone" placeholder="请输入发货人电话" />
        </el-form-item>
        <el-form-item label="发货地址" prop="senderAddress">
          <el-input v-model="form.senderAddress" placeholder="请输入发货地址" />
        </el-form-item>
        <el-form-item label="收货人" prop="receiverName">
          <el-input v-model="form.receiverName" placeholder="请输入收货人" />
        </el-form-item>
        <el-form-item label="收货人电话" prop="receiverPhone">
          <el-input v-model="form.receiverPhone" placeholder="请输入收货人电话" />
        </el-form-item>
        <el-form-item label="收货地址" prop="receiverAddress">
          <el-input v-model="form.receiverAddress" placeholder="请输入收货地址" />
        </el-form-item>
        <el-form-item label="期望到达时间" prop="expectedTime">
          <el-date-picker clearable
            v-model="form.expectedTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择期望到达时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="开始运输时间" prop="pickupTime">
          <el-date-picker clearable
            v-model="form.pickupTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择开始运输时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="完成时间" prop="finishTime">
          <el-date-picker clearable
            v-model="form.finishTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择完成时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="运费" prop="fee">
          <el-input v-model="form.fee" placeholder="请输入运费" />
        </el-form-item>
        <el-form-item label="是否支付：0否 1是" prop="paid">
          <el-input v-model="form.paid" placeholder="请输入是否支付：0否 1是" />
        </el-form-item>
        <el-form-item label="支付时间" prop="payTime">
          <el-date-picker clearable
            v-model="form.payTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择支付时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="电子回单路径" prop="receiptPath">
          <el-input v-model="form.receiptPath" placeholder="请输入电子回单路径" />
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
import { listWaybill, getWaybill, delWaybill, addWaybill, updateWaybill } from "@/api/LT/waybill"

export default {
  name: "Waybill",
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
      // 运单表格数据
      waybillList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        waybillNo: null,
        shipperId: null,
        dispatcherId: null,
        driverId: null,
        vehicleId: null,
        cargoInfo: null,
        weight: null,
        volume: null,
        senderName: null,
        senderPhone: null,
        senderAddress: null,
        receiverName: null,
        receiverPhone: null,
        receiverAddress: null,
        expectedTime: null,
        pickupTime: null,
        finishTime: null,
        status: null,
        fee: null,
        paid: null,
        payTime: null,
        receiptPath: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        waybillNo: [
          { required: true, message: "运单编号不能为空", trigger: "blur" }
        ],
        shipperId: [
          { required: true, message: "货主ID不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询运单列表 */
    getList() {
      this.loading = true
      listWaybill(this.queryParams).then(response => {
        this.waybillList = response.rows
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
        waybillNo: null,
        shipperId: null,
        dispatcherId: null,
        driverId: null,
        vehicleId: null,
        cargoInfo: null,
        weight: null,
        volume: null,
        senderName: null,
        senderPhone: null,
        senderAddress: null,
        receiverName: null,
        receiverPhone: null,
        receiverAddress: null,
        expectedTime: null,
        pickupTime: null,
        finishTime: null,
        status: null,
        fee: null,
        paid: null,
        payTime: null,
        receiptPath: null,
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
      this.title = "添加运单"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getWaybill(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改运单"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateWaybill(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addWaybill(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除运单编号为"' + ids + '"的数据项？').then(function() {
        return delWaybill(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('LT/waybill/export', {
        ...this.queryParams
      }, `waybill_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
