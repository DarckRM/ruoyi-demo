<template>
  <div ref="totop" class="go-top" @click="scrollToTop">
    <i class="bx">
      <BiChevronDoubleUp />
    </i>
    <i class="bx">
      <BiChevronDoubleUp />
    </i>
  </div>
</template>

<script setup lang="ts">
import BiChevronDoubleUp from '~icons/bi/chevron-double-up';
import { ref, onMounted } from 'vue'

const totop = ref();

const scrollToTop = () => {
  window.scrollTo({
    // top: document.documentElement.offsetHeight, //回到底部
    top: 0, //回到顶部
    left: 0,
    behavior: "smooth", //smooth 平滑；auto:瞬间
  });
};
</script>