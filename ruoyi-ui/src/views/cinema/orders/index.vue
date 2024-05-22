<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="会员 ID" prop="memberId">
        <el-input v-model="queryParams.memberId" placeholder="请输入会员 ID" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="放映 ID" prop="showtimeId">
        <el-input v-model="queryParams.showtimeId" placeholder="请输入放映 ID" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="座位 ID" prop="seatId">
        <el-input v-model="queryParams.seatId" placeholder="请输入座位 ID" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="预约时间" prop="bookingTime">
        <el-date-picker clearable v-model="queryParams.bookingTime" type="date" value-format="yyyy-MM-dd"
          placeholder="请选择预约时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
          v-hasPermi="['cinema:orders:add']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
          v-hasPermi="['cinema:orders:edit']">修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['cinema:orders:remove']">删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
          v-hasPermi="['cinema:orders:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="ordersList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="订单 ID" align="center" prop="orderId" />
      <el-table-column label="会员 ID" align="center" prop="memberId" />
      <el-table-column label="放映 ID" align="center" prop="showtimeId" />
      <el-table-column label="座位 ID" align="center" prop="seatId" />
      <el-table-column label="预约时间" align="center" prop="bookingTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.bookingTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
            v-hasPermi="['cinema:orders:edit']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
            v-hasPermi="['cinema:orders:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改订单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="会员 ID" prop="memberId">
          <el-input v-model="form.memberId" placeholder="请输入会员 ID" />
        </el-form-item>
        <el-form-item label="选择场次">
          <el-select @change="changeShow" v-model="form.showtimeId">
            <el-option v-for="show in shows" :key="show.showtimeId" :value="show.showtimeId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="座位表" prop="seatId">
          <el-card v-if="seats">
            <el-row style="margin-bottom: 5px" type="flex" justify="space-around" v-for="row in seats" :key="row.seatId" :value="row.seatId">
              <el-col :span="3" v-for="seat in row" :key="seat.seatId" :value="seat.seatId">
                <el-button @click="choseSeat(seat)" type="danger" v-if="seat.idle == 1">
                  {{ seat.seatNumber }}
                </el-button>
                <el-button @click="choseSeat(seat)" type="success" v-if="seat.idle == 2">
                  {{ seat.seatNumber }}
                </el-button>
                <el-button @click="choseSeat(seat)" type="warning" v-if="seat.idle == 3">
                  {{ seat.seatNumber }}
                </el-button>
              </el-col>
            </el-row>
          </el-card>
        </el-form-item>
        <el-form-item label="预约时间" prop="bookingTime">
          <el-date-picker clearable v-model="form.bookingTime" type="date" value-format="yyyy-MM-dd"
            placeholder="请选择预约时间">
          </el-date-picker>
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
import { listOrders, getOrders, delOrders, addOrders, updateOrders, getSeats, getAvailableShow } from "@/api/cinema/orders";

export default {
  name: "Orders",
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
      // 订单表格数据
      ordersList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        memberId: null,
        showtimeId: null,
        seatId: null,
        bookingTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      shows: [],
      seats: {}
    };
  },
  created() {
    this.getList();
    this.getShows();
  },
  methods: {
    /** 查询订单列表 */
    getList() {
      this.loading = true;
      listOrders(this.queryParams).then(response => {
        this.ordersList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        orderId: null,
        memberId: null,
        showtimeId: null,
        seatId: null,
        bookingTime: null
      };
      this.seats = {}
      this.resetForm("form");
    },
    changeShow() {
      this.seats = {}
      getSeats(this.form.showtimeId).then(resp => {
        resp.data.forEach((v) => {
          if (this.seats[v.rowNumber] == undefined) {
            this.seats[v.rowNumber] = []
          }
          this.seats[v.rowNumber].push(v)
        })
      })
    },
    getShows() {
      getAvailableShow().then(resp => {
        this.shows = resp.data
      })
    },
    choseSeat(seat) {
      this.seats[seat.rowNumber].forEach(v => {
        if (v.seatId == seat.seatId) {
          if (v.idle == 1)
            return
          if (v.idle == 2) {
            v.idle = 3
            return
          }
          if (v.idle == 3) {
            v.idle = 2
            return
          }
        }
      })
      console.log(this.seats)
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.orderId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加订单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const orderId = row.orderId || this.ids
      getOrders(orderId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改订单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.orderId != null) {
            updateOrders(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            let seat = []
            for (var row in this.seats) {
              this.seats[row].forEach(v => {
                if (v.idle == 3)
                  seat.push(v)
              })
            }
            if (seat.length <= 0)
              return

            seat.forEach(v => {
              this.form.seatId = v.seatId
              addOrders(this.form).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            })
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const orderIds = row.orderId || this.ids;
      this.$modal.confirm('是否确认删除订单编号为"' + orderIds + '"的数据项？').then(function () {
        return delOrders(orderIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => { });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('cinema/orders/export', {
        ...this.queryParams
      }, `orders_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
