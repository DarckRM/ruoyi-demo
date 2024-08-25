<template>
  <div class="product-area ptb-100">
    <div class="container">
      <div class="showing-result">
        <div class="row align-items-center">
          <div class="col-lg-6 col-sm-6">
            <div class="showing-result-count">
              <p>Showing {{ (params.pageNum - 1) * params.pageSize <= 0 ? 1 : params.pageNum * params.pageSize }} - {{
                params.pageNum * (params.pageSize + 1) < total ? params.pageNum * (params.pageSize + 1) : total }} of
                  {{ total }} results</p>
            </div>
          </div>
          <div class="col-lg-6 col-sm-6">
            <div class="showing-top-bar-ordering">
              <BFormSelect :onchange="changeCategory" v-model="category" :options="categories"></BFormSelect>
            </div>
          </div>
        </div>
      </div>
      <div class="categories col-lg-3">
        <BListGroup>
          <BListGroupItem @click="clickCategory(cate)" button :active="cate.value == category"
            v-for="cate in categories">
            {{ cate.text }}
            <BBadge style="float: right;" variant="primary">{{ cate.count }}</BBadge>
          </BListGroupItem>
        </BListGroup>
      </div>
      <div class="row">
        <BOverlay :show="loading">
          <div style="min-height: 800px;" class="row">
            <div v-for="product in products" class="col-lg-4 col-sm-6">
              <div class="single-product" style="margin-bottom: 20px; height: 360px;">
                <div class="product-img">
                  <ImagePreview :imageStyle="'max-height: 180px; min-height: 120px'" :autoplay="randomSlideTime(product.banner)" :urls="product.banner" wrapAround>
                  </ImagePreview>
                  <ul>
                    <li>
                      <a href="#product-view-one" data-toggle="modal">
                        <i class="bx">
                          <BiEye />
                        </i>
                      </a>
                    </li>
                    <li>
                      <a href="#">
                        <i class="bx">
                          <BiSuitHeart />
                        </i>
                      </a>
                    </li>
                  </ul>
                </div>

                <router-link :to="'product/' + product.title + '/' + product.id">
                  <h3>{{ product.name }}</h3>
                </router-link>
                <div style="overflow-y: auto;">
                  <span v-for="cate in product.categories">{{ cate.name }}</span>
                </div>
              </div>
            </div>

            <div class="col-lg-12 col-md-12">
              <div class="pagination-area">
                <BPagination align="center" @page-click="changePagination" v-model="params.pageNum" :total-rows="total"
                  :per-page="params.pageSize" first-text="First" prev-text="Prev" next-text="Next" last-text="Last" />
              </div>
            </div>
          </div>
        </BOverlay>
      </div>

    </div>
  </div>
  <!-- End Product Area -->
</template>

<script>
import BiEye from '~icons/bi/eye';
import BiSuitHeart from '~icons/bi/suit-heart';
import { listProduct, listCategory } from "@/api/product";
import { getImgUrl, randomSlideTime } from '@/utils/getImgUrl';
import { BListGroup, BListGroupItem, BBadge, BOverlay } from 'bootstrap-vue-next';
import { sleep } from '@/utils/tools';
import { Carousel, Slide } from 'vue3-carousel'
import ImagePreview from '../tools/ImagePreview.vue';

const categories = [

]

const products = []


export default {
  data() {
    return {
      randomSlideTime,
      getImgUrl,
      total: 0,
      category: -1,
      products: [],
      categories: [],
      params: {
        categoryIndex: [],
        pageNum: 1,
        pageSize: 9
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
    Slide
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
      this.getProducts().then((a) => {
        this.getCategories()
      })
    },
    getProducts() {
      this.products = []
      this.loading = true
      return sleep(500).then(() => {
        return listProduct(this.params).then(res => {
          this.products = res.rows
          this.setTotal(res.total)
          this.ex1Rows = res.total
          this.loading = false
        })
      })

    },
    getCategories() {
      listCategory().then(res => {
        this.categories = [{
          key: -1,
          text: 'All',
          value: -1,
          count: this.total
        }]
        res.rows.forEach(e => {
          this.categories.push(e)
        });
      })
    },
    changePagination(ev, page) {
      this.params.pageNum = page
      this.changeCategory()
    },
    changeCategory() {
      this.params.categoryIndex = []
      this.params.categoryIndex.push(this.category)
      this.getProducts()
    },
    clickCategory(v) {
      this.category = v.value
      this.changeCategory()
    },
    setTotal(v) {
      this.total = v
    }
  }
}
</script>

<style scoped>
.categories {
  height: 100%;
  float: left;
}

@media screen and (max-width: 990px) {
  .categories {
    display: none;
  }
}
</style>