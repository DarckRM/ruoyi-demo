<template>
  <section class="blog-column-one-area ptb-100">
    <div class="container">
      <div class="row">
        <div class="col-lg-8">
          <div class="row">
            <BOverlay :show="loading">
              <div class="col-lg-12 col-md-6" style="min-height: 500px;">
                <div class="single-blog-post" v-for="newsInfo in news">
                  <div class="post-image">
                    <carousel :autoplay="randomSlideTime(newsInfo.banner.split(',').length)" :wrap-around="true"
                      :transition="500">
                      <slide v-for="banner in newsInfo.banner.split(',')" class="single-choose-us-box">
                        <a>
                          <img style="height: 500px;" :src="getImgUrl(banner)" alt="Image">
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
                      <a href="#">{{ newsInfo.title }}</a>
                    </h3>

                    <p style="height: 140px; overflow: hidden;" v-html="newsInfo.content"></p>

                    <a href="blog-details.html" class="default-btn">
                      <span>Read More</span>
                    </a>
                  </div>
                </div>
              </div>
            </BOverlay>

            <div class="col-lg-12 col-md-12">
              <div class="pagination-area" style="width: 37%; margin: 0 auto">
                <BPagination @page-click="changePagination" v-model="params.pageNum" :total-rows="total"
                  :per-page="params.pageSize" first-text="First" prev-text="Prev" next-text="Next" last-text="Last" />
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4">
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
                  <a href="">
                    {{ newsInfo.title }}
                    <img style="max-height: 70px;" :src="getImgUrl(newsInfo.banner.split(',')[0])" alt="Image">
                  </a>
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
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import BiEye from '~icons/bi/eye';
import BiSuitHeart from '~icons/bi/suit-heart';
import { listNews, listType } from "@/api/news";
import { getImgUrl, randomSlideTime } from '@/utils/getImgUrl';
import { BListGroup, BListGroupItem, BBadge, BCard, BOverlay } from 'bootstrap-vue-next';
import { sleep } from '@/utils/tools';
import { Carousel, Slide } from 'vue3-carousel'

export default {
  data() {
    return {
      randomSlideTime,
      getImgUrl,
      total: 0,
      type: -1,
      news: [],
      types: [],
      tags: [],
      archives: {
      },
      params: {
        typeIndex: [],
        pageNum: 1,
        pageSize: 5
      },
      loading: false
    }
  },
  components: {
    BiEye,
    BiSuitHeart,
    BListGroup,
    BListGroupItem,
    BBadge,
    Carousel,
    Slide,
    BOverlay
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
      this.getNews().then(() => {
        this.getTypes()
      })
    },
    getNews() {
      this.loading = true
      this.news = []
      return sleep(500).then(() => {
        return listNews(this.params).then(res => {
          this.news = res.rows
          this.setTotal(res.total)
          this.ex1Rows = res.total

          this.tags = []
          this.news.forEach((v) => {
            var dateString = v.createTime.split('-')
            this.archives[dateString[0] + ' ' + this.numberToStringMonth(dateString[1])] = 0
            v.tags.split(',').forEach((tag) => {
              this.tags.push(tag)
            })
          })
          console.log(this.archives)
          this.loading = false
        })
      })

    },
    getTypes() {
      listType().then(res => {
        this.types = [{
          key: -1,
          text: 'All',
          value: -1,
          count: this.total
        }]
        res.rows.forEach(e => {
          this.types.push(e)
        });
      })
    },
    changePagination(ev, page) {
      this.params.pageNum = page
      this.changeType()
    },
    changeType() {
      this.params.typeIndex = []
      this.params.typeIndex.push(this.type)
      this.getNews()
    },
    clickType(v) {
      this.type = v.value
      this.changeType()
    },
    setTotal(v) {
      this.total = v
    },
    numberToStringMonth(num) {
      switch (num) {
        case '01': return 'January';
        case '02': return 'February';
        case '03': return 'March';
        case '04': return 'April';
        case '05': return 'May';
        case '06': return 'June';
        case '07': return 'July';
        case '08': return 'August';
        case '09': return 'September';
        case '10': return 'October';
        case '11': return 'November';
        case '12': return 'December';
      }
    }
  }
}
</script>

<style scoped></style>