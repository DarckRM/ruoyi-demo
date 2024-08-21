<template>
  <carousel style="background-color: white;" :autoplay="autoplay" :wrap-around="wrapAround" :transition="transition">
    <slide v-for="image in urls.split(',')" class="single-choose-us-box bg-color-1">
      <img :style="imageStyle" :src="getImgUrl(image)" alt="Image">
    </slide>
    <template #addons>
      <Navigation v-if="navigate" style="background-color: white;" />
      <Pagination v-if="page" style="margin-top: 0; background-color: white;" />
    </template>
  </carousel>
</template>

<script>
import { Carousel, Slide, Pagination, Navigation } from 'vue3-carousel'
import { getImgUrl } from '@/utils/getImgUrl';

export default {
  components: {
    Carousel,
    Slide,
    Pagination,
    Navigation
  },
  props: { 
    urls: {
      type: String,
      default: ""
    },
    navigate: {
      type: Boolean,
      default: false
    },
    page: {
      type: Boolean,
      default: false
    },
    autoplay: {
      type: Number,
      default: 0
    },
    transition: {
      type: Number,
      default: 500
    },
    imageStyle: {
      type: String,
      default: ''
    },
    wrapAround: Boolean
   },
  data() {
    return {
      getImgUrl,
      images: []
    }
  },
}
</script>