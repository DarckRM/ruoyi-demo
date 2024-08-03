import { createApp } from "vue";
import { createBootstrap } from "bootstrap-vue-next";
import router from "./router/index.js";

// Add the necessary CSS
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue-next/dist/bootstrap-vue-next.css";
import App from "./App.vue";
// 添加基础 CSS 文件
import "./assets/css/animate.min.css";
import "./assets/css/bootstrap.min.css";
import "./assets/css/boxicons.min.css";
import "./assets/css/flaticon.css";
import "./assets/css/magnific-popup.min.css";
import "./assets/css/meanmenu.min.css";
import "./assets/css/nice-select.min.css";
import "./assets/css/odometer.min.css";
import "./assets/css/owl.carousel.min.css";
import "./assets/css/responsive.css";
import "./assets/css/style.css";
// import "./assets/css/timeline.css";
// 添加基础 JS 文件
import "./assets/js/jquery.min.js";
// import './assets/js/popper.min.js'
import "./assets/js/meanmenu.min.js";
// import './assets/js/wow.min.js'
import "./assets/js/ajaxchimp.min.js";
import "./assets/js/owl.carousel.min.js";
import "./assets/js/nice-select.min.js";
import "./assets/js/magnific-popup.min.js";
import "./assets/js/parallax.min.js";
import "./assets/js/appear.min.js";
import "./assets/js/odometer.min.js";
import "./assets/js/smoothscroll.min.js";
import "./assets/js/form-validator.min.js";
import "./assets/js/contact-form-script.js";
import "./assets/js/custom.js";

createApp(App).use(router).use(createBootstrap()).mount("#app");
