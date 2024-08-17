<template>
  <section class="blog-column-one-area ptb-100">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-8" style="min-height: 400px;">
          <BOverlay :show="loading">
            <router-view v-slot="{ Component }">
              <transition name="fade">
                <component :is="Component" :news="news">
                </component>
              </transition>
            </router-view>
          </BOverlay>
          <div :style="$route.path != '/news/all' ? {display: 'none'} : {display: 'block'}" class="pagination-area">
            <BPagination align="center" @page-click="changePagination" v-model="params.pageNum" :total-rows="total"
              :per-page="params.pageSize" first-text="First" prev-text="Prev" next-text="Next" last-text="Last" />
          </div>
        </div>

        <div class="col-lg-4 col-md-4">
          <Side :news="news" :archives="archives" :tags="tags" :types="types"></Side>
        </div>
      </div>
    </div>
  </section>
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

<script>
import BiEye from '~icons/bi/eye';
import BiSuitHeart from '~icons/bi/suit-heart';
import { listNews, listType } from "@/api/news";
import { getImgUrl, randomSlideTime } from '@/utils/getImgUrl';
import { BListGroup, BListGroupItem, BBadge, BCard, BOverlay } from 'bootstrap-vue-next';
import { sleep } from '@/utils/tools';

import Main from '@/components/news/Main.vue'
import Side from '@/components/news/Side.vue'

export default {
  data() {
    return {
      randomSlideTime,
      getImgUrl,
      total: 0,
      type: -1,
      params: {
        typeIndex: [],
        pageNum: 1,
        pageSize: 2
      },
      loading: false,
      news: [],
      archives: {},
      types: [],
      tags: []
    }
  },
  components: {
    BiEye,
    BiSuitHeart,
    BListGroup,
    BListGroupItem,
    BBadge,
    BOverlay,
    Side,
    Main
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
            // 内容过滤
            var content = v.content
            const regex = /<img[^>]*>/gi;
            content.replace(regex, '')
            if (content.length > 460) {
              content = content.slice(0, 460) + "..."
            }
            v.content = content

            var dateString = v.createTime.split('-')
            this.archives[dateString[0] + ' ' + this.numberToStringMonth(dateString[1])] = 0
            v.tags.split(',').forEach((tag) => {
              this.tags.push(tag)
            })
          })
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
      document.documentElement.scrollTop = 0;
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