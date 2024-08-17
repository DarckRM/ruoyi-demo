<template>
  <div class="widget-sidebar">
    <div class="sidebar-widget search">
      <form class="search-form">
        <input class="form-control" name="search" placeholder="Search here" type="text">
        <button class="search-button" type="submit">
          <i class="bx bx-search"></i>
        </button>
      </form>
    </div>

    <div class="sidebar-widget recent-post">
      <h3 class="widget-title">Recent Post</h3>

      <ul>
        <li style="height: 90px; overflow: hidden;" v-for="newsInfo in news">
          <router-link :to="'/news/' + newsInfo.title + '/' + newsInfo.id">
            {{ newsInfo.title }}
            <img style="max-height: 70px;" :src="getImgUrl(newsInfo.banner.split(',')[0])" alt="Image">
          </router-link>
          <span>{{ newsInfo.createTime }}</span>
        </li>
      </ul>
    </div>

    <div class="sidebar-widget categories">
      <h3>Categories</h3>
      <ul>
        <li v-for="type in types">
          <a href="#">{{ type.text }}<span>
              <BBadge variant="primary">{{ type.count }}</BBadge>
            </span></a>
        </li>
      </ul>
    </div>

    <div class="sidebar-widget categories">
      <h3>Archives</h3>
      <ul>
        <li v-for="archive in Object.keys(archives)">
          <a href="#">{{ archive.split(' ')[1] }}<span>{{ archive.split(' ')[0] }}</span></a>
        </li>
      </ul>
    </div>

    <div class="sidebar-widget tags mb-0">
      <h3>Tags</h3>
      <ul>
        <li v-for="tag in tags">
          <a href="#">{{ tag }}</a>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import { getImgUrl } from '@/utils/getImgUrl'

export default {
  props: [
    'news',
    'types',
    'archives',
    'tags',
  ],
  data() {
    return {
      getImgUrl
    }
  },
  mounted() {
  },
  methods: {

  }
}
</script>