<script setup>
import HelloWorld from './components/HelloWorld.vue'
import Index from './views/Index.vue'
import Footer from './components/footer/Footer.vue'
import TopHeader from './components/header/TopHeader.vue'
import NaviHeader from './components/header/NaviHeader.vue'

import { router } from "./router";
</script>

<template>
  <div class="preloader">
    <div class="lds-ripple">
      <div></div>
      <div></div>
    </div>
  </div>
  <header class="header-area">
    <TopHeader />
    <NaviHeader />
  </header>
  <div style="margin-top: 80px;">
    <router-view></router-view>
  </div>
  <Footer />
</template>

<style scoped></style>
