<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :span="12">
        <el-card>
          <div slot="header">
            <span>企业介绍</span>
            <el-button style="margin-left: 20px;" type="text" @click="submitForm">修改</el-button>
          </div>
          <el-form>
            <el-form-item label="主标题">
              <el-input v-model="form.title"></el-input>
            </el-form-item>
            <el-form-item label="副标题">
              <el-input v-model="form.subTitle"></el-input>
            </el-form-item>
            <el-form-item label="正文">
            </el-form-item>
            <editor v-model="form.content" style="max-height: 400px; overflow: auto;" />
          </el-form>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card>
          <div slot="header">
            <span>关于信息</span>
            <el-button style="margin-left: 20px;" type="text" @click="submitForm">修改</el-button>
          </div>
          <el-form>
            <el-form-item label="地址">
              <el-input v-model="form.address"></el-input>
            </el-form-item>
            <el-form-item label="主邮箱">
              <el-input v-model="form.majorEmail"></el-input>
            </el-form-item>
            <el-form-item label="副邮箱">
              <el-input v-model="form.subEmail"></el-input>
            </el-form-item>
            <el-form-item label="电话">
              <el-input v-model="form.tel"></el-input>
            </el-form-item>
            <el-form-item label="关键词">
              <el-tag :key="tag" v-for="tag in keywords" closable :disable-transitions="false"
                @close="handleClose(tag)" style="margin: 5px">
                {{ tag }}
              </el-tag>
              <el-input class="input-new-tag" v-if="inputVisible" v-model="inputValue" ref="saveTagInput"
                size="small" @keyup.enter.native="handleInputConfirm" @blur="handleInputConfirm">
              </el-input>
              <el-button v-else class="button-new-tag" size="small" @click="showInput">+ 添加</el-button>
            </el-form-item>
          </el-form>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { getAbout } from "@/api/greatzc/baseInfo";
import { updateAbout } from "../api/greatzc/baseInfo";

export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.7",
      form: {
        id: 1,
        title: '',
        subTitle: '',
        content: '',
        address: '',
        majorEmail: '',
        subEmail: '',
        tel: '',
        keywords: ''
      },
      keywords: [],
      inputVisible: false,
      inputValue: ''
    };
  },
  mounted() {
    this.getAboutInfo()
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
    getAboutInfo() {
      this.loading = true
      getAbout(1).then(res => {
        this.form = res.data
        this.keywords = res.data.keywords.split(',')
        this.loading = false
      })
    },
    submitForm() {
      this.form.keywords = this.keywords.toString()
      updateAbout(this.form).then(res => {
        this.$modal.msgSuccess("修改成功")
        this.getAboutInfo()
      })
    },
    handleClose(tag) {
      this.keywords.splice(this.keywords.indexOf(tag), 1);
    },
    showInput() {
      this.inputVisible = true;
      this.$nextTick(_ => {
        this.$refs.saveTagInput.$refs.input.focus();
      });
    },
    handleInputConfirm() {
      let inputValue = this.inputValue;
      if (inputValue) {
        this.keywords.push(inputValue);
      }
      this.inputVisible = false;
      this.inputValue = '';
    }
  }
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }

  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }

  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans",
  "Helvetica Neue",
  Helvetica,
  Arial,
  sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>
