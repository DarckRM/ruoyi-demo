<template>
  <div class="row">
    <div class="single-blog-post" v-for="newsInfo in news">
      <div class="post-image">
        <carousel :autoplay="randomSlideTime(newsInfo.banner.split(',').length)" :wrap-around="true" :transition="500">
          <slide style="height: 400px;" v-for="banner in newsInfo.banner.split(',')" class="single-choose-us-box">
            <a>
              <img style="object-fit: cover" :src="getImgUrl(banner)" alt="Image">
            </a>
          </slide>
        </carousel>
      </div>

      <div class="blog-content">
        <div class="date">
          <i class="bx bx-calendar"></i>
          <span>{{ newsInfo.createTime }}</span>
        </div>

        <h3>
          <router-link :to="newsInfo.title + '/' + newsInfo.id">
            {{ newsInfo.title }}
          </router-link>
        </h3>

        <p style="height: 140px; overflow: hidden;" v-html="newsInfo.content"></p>

        <router-link :to="newsInfo.title + '/' + newsInfo.id" class="default-btn">
          <span>Read More</span>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import { Carousel, Slide } from 'vue3-carousel'
import { getImgUrl, randomSlideTime } from '@/utils/getImgUrl';

export default {
  components: {
    Slide,
    Carousel
  },
  data() {
    return {
      randomSlideTime,
      getImgUrl
    }

  },
  props: [
    'news',
    'types'
  ]
}
</script>