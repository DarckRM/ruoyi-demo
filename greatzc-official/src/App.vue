<script>
import HelloWorld from './components/HelloWorld.vue'
import Index from './views/Index.vue'
import Footer from './components/footer/Footer.vue'
import TopHeader from './components/header/TopHeader.vue'
import NaviHeader from './components/header/NaviHeader.vue'
import BackToTop from './components/tools/BackToTop.vue'

import { router } from "./router";
import { getAbout } from '@/api/baseInfo';
import { useHead } from '@unhead/vue';

export default {
  components: {
    HelloWorld,
    Index,
    Footer,
    TopHeader,
    NaviHeader,
    BackToTop
  },
  data() {
    return {
      info: {}
    }
  },
  mounted() {
    getAbout(1).then(res => {
      this.info = res.data
      useHead({
        meta: [
          { name: 'keywords', content: this.info.keywords },
          { name: 'description', content: this.info.title }
        ]
      })
    })
  }
}

</script>

<template>
  <BackToTop />
  <div class="preloader">
    <div class="lds-ripple">
      <div></div>
      <div></div>
    </div>
  </div>
  <header class="header-area">
    <TopHeader :info="info" mode="out-in" />
    <NaviHeader />
  </header>
  <div style="margin-top: 80px;">
    <router-view v-slot="{ Component }">
      <transition name="fade">
        <component :is="Component"></component>
      </transition>
    </router-view>
  </div>
  <Footer :info="info" />
</template>

<style scoped>
.fade-enter-active {
  transition: opacity 2s ease;
}

.fade-leave-active {
  transition: opacity 0.5s ease;
}

.fade-enter-from {

  opacity: 0;
}

.fade-leave-to {
  opacity: 0;
}
</style>
