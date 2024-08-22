<template>
  <div>
    <el-upload :action="uploadUrl" :before-upload="handleBeforeUpload" :on-success="handleUploadSuccess"
      :on-error="handleUploadError" name="file" :show-file-list="false" :headers="headers" style="display: none"
      ref="upload" v-if="this.type == 'url'">
    </el-upload>
    <div class="editor" ref="editor" :style="styles"></div>
  </div>

</template>

<script>
import Quill from 'quill'
import QuillBetterTable from "quill-better-table";

import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.bubble.css'
import "quill-better-table/dist/quill-better-table.css";

import { getToken } from "@/utils/auth";

Quill.register(
  {
    "modules/better-table": QuillBetterTable
  },
  true
);

const titleConfig = {
  'ql-bold': '加粗',
  'ql-color': '颜色',
  'ql-font': '字体',
  'ql-code': '插入代码',
  'ql-italic': '斜体',
  'ql-link': '添加链接',
  'ql-background': '颜色',
  'ql-size': '字体大小',
  'ql-strike': '删除线',
  'ql-script': '上标/下标',
  'ql-underline': '下划线',
  'ql-blockquote': '引用',
  'ql-header': '标题',
  'ql-indent': '缩进',
  'ql-list': '列表',
  'ql-align': '文本对齐',
  'ql-direction': '文本方向',
  'ql-code-block': '代码块',
  'ql-formula': '公式',
  'ql-image': '图片',
  'ql-video': '视频',
  'ql-clean': '清除字体样式',
  'ql-upload': '文件',
  'ql-table': '插入表格',
  'ql-table-insert-row': '插入行',
  'ql-table-insert-column': '插入列',
  'ql-table-delete-row': '删除行',
  'ql-table-delete-column': '删除列'
}
export default {
  name: 'Editor',
  props: {
    /* 编辑器的内容 */
    value: {
      type: String,
      default: "",
    },
    /* 高度 */
    height: {
      type: Number,
      default: null,
    },
    /* 最小高度 */
    minHeight: {
      type: Number,
      default: null,
    },
    /* 只读 */
    readOnly: {
      type: Boolean,
      default: false,
    },
    /* 上传文件大小限制(MB) */
    fileSize: {
      type: Number,
      default: 5,
    },
    /* 类型（base64格式、url格式） */
    type: {
      type: String,
      default: "url",
    }
  },
  data() {
    return {
      uploadUrl: process.env.VUE_APP_BASE_API + "/common/upload", // 上传的图片服务器地址
      headers: {
        Authorization: "Bearer " + getToken()
      },
      quill: null,
      currentValue: "",
      options: {
        theme: 'snow',
        // bounds: document.body,
        modules: {
          toolbar: {
            container: [
              ["bold", "italic", "underline", "strike"], // 加粗 斜体 下划线 删除线
              ["blockquote", "code-block"], // 引用  代码块
              //   [{ header: 1 }, { header: 2 }], // 1、2 级标题
              [{ list: "ordered" }, { list: "bullet" }], // 有序、无序列表
              [{ script: "sub" }, { script: "super" }], // 上标/下标
              [{ indent: "-1" }, { indent: "+1" }], // 缩进
              // [{'direction': 'rtl'}],                         // 文本方向
              ["blockquote", "code-block"],                    // 引用  代码块
              [{ size: ["small", false, "large", "huge"] }], // 字体大小
              [{ header: [1, 2, 3, 4, 5, 6, false] }], // 标题
              [{ color: [] }, { background: [] }], // 字体颜色、字体背景颜色
              [{ font: [] }], // 字体种类
              [{ align: [] }], // 对齐方式
              ["clean"], // 清除文本格式
              // ["link","image"], // 链接、图片、视频
              ["link", "image", "video"],                      // 链接、图片、视频
              [
                { table: 'TD' },
                // { 'table-insert-row': 'TIR' },
                // { 'table-insert-column': 'TIC' },
                // { 'table-delete-row': 'TDR' },
                // { 'table-delete-column': 'TDC' }
              ]
            ],
            handlers: {
              table: function (val) {
                this.quill.getModule('better-table').insertTable(3, 3)
              }
            }
          },
          table: false,
          'better-table': {
            operationMenu: {
              items: {
                insertColumnRight: { text: '右边插入一列' },
                insertColumnLeft: { text: '左边插入一列' },
                insertRowUp: { text: '上边插入一行' },
                insertRowDown: { text: '下边插入一行' },
                mergeCells: { text: '合并单元格' },
                unmergeCells: { text: '拆分单元格' },
                deleteColumn: { text: '删除列' },
                deleteRow: { text: '删除行' },
                deleteTable: { text: '删除表格' }
              },
              color: {
                colors: ['green', 'red', 'yellow', 'blue', 'white'],
                text: '背景色:'
              }
            }
          },
          keyboard: {
            bindings: QuillBetterTable.keyboardBindings
          }
        },
        placeholder: "请输入内容",
        readOnly: this.readOnly,
      }
    }
  },
  computed: {
    styles() {
      let style = {
        maxHeight: '500px',
        overflowY: 'scroll'
      };
      if (this.minHeight) {
        style.minHeight = `${this.minHeight}px`;
      }
      if (this.height) {
        style.height = `${this.height}px`;
      }
      return style;
    },
  },
  watch: {
    value: {
      handler(val) {
        if (val !== this.currentValue) {
          this.currentValue = val === null ? "" : val;
          if (this.quill) {
            let delta = this.quill.clipboard.convert({
              html: val
            })
            this.quill.setContents(delta)
          }
        }
      },
      immediate: true,
    },
  },
  methods: {
    // 上传前校检格式和大小
    handleBeforeUpload(file) {
      const type = ["image/jpeg", "image/jpg", "image/png", "image/svg"];
      const isJPG = type.includes(file.type);
      // 检验文件格式
      if (!isJPG) {
        this.$message.error(`图片格式错误!`);
        return false;
      }
      // 校检文件大小
      if (this.fileSize) {
        const isLt = file.size / 1024 / 1024 < this.fileSize;
        if (!isLt) {
          this.$message.error(`上传文件大小不能超过 ${this.fileSize} MB!`);
          return false;
        }
      }
      return true;
    },
    handleUploadSuccess(res, file) {
      // 如果上传成功
      if (res.code == 200) {
        // 获取富文本组件实例
        let quill = this.quill;
        // 获取光标所在位置
        let length = quill.getSelection().index;
        // 插入图片  res.url为服务器返回的图片地址
        quill.insertEmbed(length, "image", process.env.VUE_APP_BASE_API + res.fileName);
        // 调整光标到最后
        quill.setSelection(length + 1);
      } else {
        this.$message.error("图片插入失败");
      }
    },
    handleUploadError() {
      this.$message.error("图片插入失败");
    },
    addQuillTitle() {
      const oToolBar = document.querySelector('.ql-toolbar')
      const aButton = oToolBar.querySelectorAll('button')
      const aSelect = oToolBar.querySelectorAll('select')
      aButton.forEach(function (item) {
        if (item.className === 'ql-script') {
          item.value === 'sub' ? (item.title = '下标') : (item.title = '上标')
        } else if (item.className === 'ql-indent') {
          item.value === '+1' ? (item.title = '向右缩进') : (item.title = '向左缩进')
        } else {
          item.title = titleConfig[item.classList[0]]
        }
      })
      aSelect.forEach(function (item) {
        item.parentNode.title = titleConfig[item.classList[0]]
      })
    },
    getContentData() {
      return this.quill.getContents()
    }
  },
  mounted() {
    const dom = this.$el.querySelector('.editor')
    this.quill = new Quill(dom, this.options)
    // 如果设置了上传地址则自定义图片上传事件
    if (this.type == 'url') {
      let toolbar = this.quill.getModule("toolbar");
      toolbar.addHandler("image", (value) => {
        if (value) {
          this.$refs.upload.$children[0].$refs.input.click();
        } else {
          this.quill.format("image", false);
        }
      });
    }
    this.quill.clipboard.dangerouslyPasteHTML(0, this.value)  // html格式数据

    this.quill.on("text-change", (delta, oldDelta, source) => {
      const html = this.$refs.editor.children[0].innerHTML;
      const text = this.quill.getText();
      const quill = this.quill;
      this.currentValue = html;
      this.$emit("input", html);
      this.$emit("on-change", { html, text, quill });
    });
    this.quill.on("text-change", (delta, oldDelta, source) => {
      this.$emit("on-text-change", delta, oldDelta, source);
    });
    this.quill.on('text-change', () => {
      this.$emit('contentData', this.quill.root.innerHTML)
    })
    this.quill.on("selection-change", (range, oldRange, source) => {
      this.$emit("on-selection-change", range, oldRange, source);
    });
    this.quill.on("editor-change", (eventName, ...args) => {
      this.$emit("on-editor-change", eventName, ...args);
    });

    this.addQuillTitle()
  },
  activated() {
    this.quill.setContents({})
  },
  beforeDestroy() {
    this.Quill = null;
  }
}
</script>

<style>
.editor,
.ql-toolbar {
  white-space: pre-wrap !important;
  line-height: normal !important;
}

.quill-img {
  display: none;
}

.ql-snow .ql-tooltip[data-mode="link"]::before {
  content: "请输入链接地址:";
}

.ql-snow .ql-tooltip.ql-editing a.ql-action::after {
  border-right: 0px;
  content: "保存";
  padding-right: 0px;
}

.ql-snow .ql-tooltip[data-mode="video"]::before {
  content: "请输入视频地址:";
}

.ql-snow .ql-picker.ql-size .ql-picker-label::before,
.ql-snow .ql-picker.ql-size .ql-picker-item::before {
  content: "14px";
}

.ql-snow .ql-picker.ql-size .ql-picker-label[data-value="small"]::before,
.ql-snow .ql-picker.ql-size .ql-picker-item[data-value="small"]::before {
  content: "10px";
}

.ql-snow .ql-picker.ql-size .ql-picker-label[data-value="large"]::before,
.ql-snow .ql-picker.ql-size .ql-picker-item[data-value="large"]::before {
  content: "18px";
}

.ql-snow .ql-picker.ql-size .ql-picker-label[data-value="huge"]::before,
.ql-snow .ql-picker.ql-size .ql-picker-item[data-value="huge"]::before {
  content: "32px";
}

.ql-snow .ql-picker.ql-header .ql-picker-label::before,
.ql-snow .ql-picker.ql-header .ql-picker-item::before {
  content: "文本";
}

.ql-snow .ql-picker.ql-header .ql-picker-label[data-value="1"]::before,
.ql-snow .ql-picker.ql-header .ql-picker-item[data-value="1"]::before {
  content: "标题1";
}

.ql-snow .ql-picker.ql-header .ql-picker-label[data-value="2"]::before,
.ql-snow .ql-picker.ql-header .ql-picker-item[data-value="2"]::before {
  content: "标题2";
}

.ql-snow .ql-picker.ql-header .ql-picker-label[data-value="3"]::before,
.ql-snow .ql-picker.ql-header .ql-picker-item[data-value="3"]::before {
  content: "标题3";
}

.ql-snow .ql-picker.ql-header .ql-picker-label[data-value="4"]::before,
.ql-snow .ql-picker.ql-header .ql-picker-item[data-value="4"]::before {
  content: "标题4";
}

.ql-snow .ql-picker.ql-header .ql-picker-label[data-value="5"]::before,
.ql-snow .ql-picker.ql-header .ql-picker-item[data-value="5"]::before {
  content: "标题5";
}

.ql-snow .ql-picker.ql-header .ql-picker-label[data-value="6"]::before,
.ql-snow .ql-picker.ql-header .ql-picker-item[data-value="6"]::before {
  content: "标题6";
}

.ql-snow .ql-picker.ql-font .ql-picker-label::before,
.ql-snow .ql-picker.ql-font .ql-picker-item::before {
  content: "标准字体";
}

.ql-snow .ql-picker.ql-font .ql-picker-label[data-value="serif"]::before,
.ql-snow .ql-picker.ql-font .ql-picker-item[data-value="serif"]::before {
  content: "衬线字体";
}

.ql-snow .ql-picker.ql-font .ql-picker-label[data-value="monospace"]::before,
.ql-snow .ql-picker.ql-font .ql-picker-item[data-value="monospace"]::before {
  content: "等宽字体";
}

.ql-editor {
  min-height: 400px;
  height: auto !important;
  height: 400px;
}

.qlbt-operation-menu {
  z-index: 9999 !important;
}
</style>
