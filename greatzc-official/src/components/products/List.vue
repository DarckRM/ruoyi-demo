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
          <BListGroupItem @click="clickCategory(cate)" button :active="cate.value == category" v-for="cate in categories">
            {{ cate.text }}
            <BBadge style="float: right;" variant="primary" >{{ cate.count }}</BBadge>
          </BListGroupItem>
        </BListGroup>
      </div>
      <div style="min-height: 800px;" class="row">
        <div v-for="product in products" class="col-lg-4 col-sm-6">
          <div class="single-product" style="margin-bottom: 0px; height: 330px;">
            <div class="product-img">
              <img :src="getImgUrl(product.banner)" alt="Image">
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
              <h3>{{ product.title }}</h3>
            </router-link>
            <span v-for="cate in product.categories">{{ cate.name }}</span>
          </div>
        </div>

        <div class="col-lg-12 col-md-12">
          <div class="pagination-area" style="width: 30%; margin: 0 auto;">
            <BPagination @page-click="changePagination" v-model="params.pageNum" :total-rows="total"
              :per-page="params.pageSize" first-text="First" prev-text="Prev" next-text="Next" last-text="Last" />
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- End Product Area -->
</template>

<script>
import BiEye from '~icons/bi/eye';
import BiSuitHeart from '~icons/bi/suit-heart';
import { listProduct, listCategory } from "@/api/product";
import { getImgUrl } from '@/utils/getImgUrl';
import { BListGroup, BListGroupItem, BBadge, BCard } from 'bootstrap-vue-next';

const categories = [

]

const products = []


export default {
  data() {
    return {
      getImgUrl,
      total: 0,
      category: -1,
      products: [],
      categories: [],
      params: {
        categoryIndex: [],
        pageNum: 1,
        pageSize: 10
      }
    }
  },
  components: {
    BiEye,
    BiSuitHeart,
    BListGroup,
    BListGroupItem,
    BBadge
  },
  mounted() {
    listProduct(this.params).then(res => {
      this.products = res.rows
      this.total = res.total
      this.ex1Rows = res.total
    })
    listCategory().then(res => {
      this.categories = [{
        key: -1,
        text: 'All',
        value: -1
      }]
      res.rows.forEach(e => {
        this.categories.push(e)
      });
    })
  },
  methods: {
    changePagination(ev, page) {
      this.params.pageNum = page
      this.params.categoryIndex = []
      this.params.categoryIndex.push(this.category)
      listProduct(this.params).then(res => {
        this.products = [{
          key: -1,
          text: 'All',
          value: -1
        }]
        this.products = res.rows
        this.total = res.total
        this.ex1Rows = res.total
      })
    },
    changeCategory() {
      this.params.categoryIndex = []
      this.params.categoryIndex.push(this.category)
      listProduct(this.params).then(res => {
        this.products = [{
          key: -1,
          text: 'All',
          value: -1
        }]
        this.products = res.rows
        this.total = res.total
        this.ex1Rows = res.total
      })
    },
    clickCategory(v) {
      this.category = v.value
      this.changeCategory()
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