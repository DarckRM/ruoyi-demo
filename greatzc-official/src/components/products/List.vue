<template>
  <div class="product-area ptb-100">
    <div class="container">
      <div class="showing-result">
        <div class="row align-items-center">
          <div class="col-lg-6 col-sm-6">
            <div class="showing-result-count">
              <p>Showing 1 - {{ products.length }} of {{ total }} results</p>
            </div>
          </div>

          <div class="col-lg-6 col-sm-6">
            <div class="showing-top-bar-ordering">
              <BFormSelect :onchange="changeCategory" v-model="category" :options="categories">
              </BFormSelect>
            </div>
          </div>
        </div>
      </div>

      <div class="row">
        <div v-for="product in products" class="col-lg-4 col-sm-6">
          <div class="single-product">
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
          <div class="pagination-area">
            <span class="page-numbers current" aria-current="page">1</span>
            <a href="#" class="page-numbers">2</a>
            <a href="#" class="page-numbers">3</a>

            <a href="#" class="next page-numbers">
              <i class="bx bx-chevron-right"></i>
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- End Product Area -->

  <!-- Start Product View One Area -->
  <div class="modal fade product-view-one" id="product-view-one">
    <div class="modal-dialog">
      <div class="modal-content">
        <button type="button" class="close" data-dismiss="modal">
          <span aria-hidden="true">
            <i class="bx bx-x"></i>
          </span>
        </button>

        <div class="row align-items-center">
          <div class="col-lg-6 col-md-6">
            <div class="product-view-one-image">
              <div id="big" class="owl-carousel owl-theme">
                <div class="item">
                  <img src="/assets/img/product/product-1.jpg" alt="Image">
                </div>

                <div class="item">
                  <img src="/assets/img/product/product-2.jpg" alt="Image">
                </div>

                <div class="item">
                  <img src="/assets/img/product/product-3.jpg" alt="Image">
                </div>

                <div class="item">
                  <img src="/assets/img/product/product-4.jpg" alt="Image">
                </div>

                <div class="item">
                  <img src="/assets/img/product/product-5.jpg" alt="Image">
                </div>

                <div class="item">
                  <img src="/assets/img/product/product-6.jpg" alt="Image">
                </div>
              </div>

              <div id="thumbs" class="owl-carousel owl-theme">
                <div class="item">
                  <img src="/assets/img/product/product-1.jpg" alt="Image">
                </div>

                <div class="item">
                  <img src="/assets/img/product/product-2.jpg" alt="Image">
                </div>

                <div class="item">
                  <img src="/assets/img/product/product-3.jpg" alt="Image">
                </div>

                <div class="item">
                  <img src="/assets/img/product/product-4.jpg" alt="Image">
                </div>

                <div class="item">
                  <img src="/assets/img/product/product-5.jpg" alt="Image">
                </div>

                <div class="item">
                  <img src="/assets/img/product/product-6.jpg" alt="Image">
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-6 col-md-6">
            <div class="product-content">
              <h3>
                <a href="#">Delivery Box</a>
              </h3>

              <div class="price">
                <span class="new-price">$190.00</span>
              </div>

              <div class="product-review">
                <div class="rating">
                  <i class="bx bxs-star"></i>
                  <i class="bx bxs-star"></i>
                  <i class="bx bxs-star"></i>
                  <i class="bx bxs-star"></i>
                  <i class="bx bxs-star"></i>
                </div>
                <a href="#" class="rating-count">3 reviews</a>
              </div>

              <ul class="product-info">
                <li>
                  <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. At magnam ad reprehenderit fuga nam, non
                    odit necessitatibus facilis beatae temporibus</p>
                </li>
                <li>
                  <span>Availability:</span> <a href="#">In stock (7 items)</a>
                </li>
                <li>
                  <span>Product Type:</span> <a href="#">Box</a>
                </li>
              </ul>

              <div class="product-color-switch">
                <h4>Color:</h4>

                <ul>
                  <li>
                    <a href="#" title="Black" class="color-black"></a>
                  </li>
                  <li>
                    <a href="#" title="White" class="color-white"></a>
                  </li>
                  <li class="active">
                    <a href="#" title="Green" class="color-green"></a>
                  </li>
                  <li>
                    <a href="#" title="Yellow Green" class="color-yellowgreen"></a>
                  </li>
                  <li>
                    <a href="#" title="Teal" class="color-teal"></a>
                  </li>
                </ul>
              </div>

              <div class="product-add-to-cart">
                <div class="input-counter">
                  <span class="minus-btn">
                    <i class="bx bx-minus"></i>
                  </span>

                  <input type="text" min="1" value="1">

                  <span class="plus-btn">
                    <i class="bx bx-plus"></i>
                  </span>
                </div>

                <button type="submit" class="default-btn">
                  Add to Cart
                  <i class="flaticon-right"></i>
                </button>
              </div>

              <div class="share-this-product">
                <h3>Share This Product</h3>

                <ul>
                  <li>
                    <a href="#">
                      <i class="bx bxl-facebook"></i>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="bx bxl-twitter"></i>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="bx bxl-instagram"></i>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="bx bxl-linkedin"></i>
                    </a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import BiEye from '~icons/bi/eye';
import BiSuitHeart from '~icons/bi/suit-heart';
import { listProduct, listCategory } from "@/api/product";
import { getImgUrl } from '@/utils/getImgUrl';
import { onUpdated } from 'vue';

const categories = [

]

const products = []


export default {
  data() {
    return {
      getImgUrl,
      total: 0,
      category: 0,
      products: [],
      categories: [],
      params: {
        categoryIndex: []
      }
    }
  },
  components: {
    BiEye,
    BiSuitHeart
  },
  mounted() {
    listProduct(this.params).then(res => {
      this.products = res.rows
      this.total = res.total
    })
    listCategory().then(res => {
      this.categories = [{
        key: null,
        text: 'All',
        value: null 
      }]
      res.rows.forEach(e => {
        this.categories.push({
          key: e.id,
          text: e.name,
          value: e.id
        })
      });
    })
  },
  methods: {
    changeCategory() {
      this.params = {
        categoryIndex: []
      }
      this.params.categoryIndex.push(this.category)
      listProduct(this.params).then(res => {
        this.products = [{
          key: -1,
          text: 'All',
          value: -1 
        }]
        this.products = res.rows
        this.total = res.total
      })
    }
  }
}
</script>