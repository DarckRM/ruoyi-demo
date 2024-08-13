<template>
  <section class="product-details-area ptb-100">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-lg-6 col-md-12">
          <div class="product-details-image">
            <carousel :autoplay="5000" :wrap-around="true" :transition="500">
              <slide v-for="banner in product.banner.split(',')" class="single-choose-us-box bg-color-1">
                <img style="max-height: 400px;" :src="getImgUrl(banner)" alt="Image">
              </slide>
              <template #addons>
                <Navigation />
                <Pagination />
              </template>
            </carousel>
          </div>
        </div>

        <div class="col-lg-6 col-md-12">
          <div class="product-details-desc">
            <h3>{{ $route.params.name }}</h3>
            <p class="category">{{ product.name }}</p>
            <div class="product-review">
              <div class="rating">
                <i v-for="i in 5" class='bx'>
                  <BiStarFill />
                </i>
              </div>
              <a href="#" class="rating-count">(3 Customer reviews)</a>
            </div>

            <div class="price">
              <!-- <span class="new-price"> <del>$00.00</del> $190.00</span> -->
            </div>

            <div class="product-add-to-cart">
              <h3>Quantities:</h3>
              <div class="input-counter">
                <span class="minus-btn">
                  <i class="bx">
                    -
                  </i>
                </span>

                <input type="text" min="1" value="1">

                <span class="plus-btn">
                  <i class="bx">
                    +
                  </i>
                </span>
              </div>
            </div>

            <button type="submit" class="default-btn">
              <span>Add To Cart</span>
            </button>

            <ul class="social-wrap">
              <li>
                <span>Share:</span>
              </li>
              <li>
                <a href="#" target="_blank">
                  <i class="bx bxl-twitter">
                  </i>
                </a>
              </li>
              <li>
                <a href="#" target="_blank">
                  <i class="bx bxl-instagram">
                  </i>
                </a>
              </li>
              <li>
                <a href="#" target="_blank">
                  <i class="bx bxl-facebook">
                  </i>
                </a>
              </li>
            </ul>

            <p class="category">Category: <span v-for="cate in product.categories">
                {{ cate.name }}&ensp;
              </span></p>
          </div>
        </div>

        <div class="col-lg-12 col-md-12">
          <div class="tab products-details-tab">
            <div class="row">
              <div class="col-lg-12 col-md-12">
                <ul class="tabs">
                </ul>
              </div>
              <div class="col-lg-12 col-md-12">
                <div class="tab_content">
                  <div class="tabs_item">
                    <div class="products-details-tab-content">
                      <h3 class="mb-2">Description</h3>
                      <!-- <iframe style="width: 100%; min-height: 2000px"
                        :src="'/products/' + $route.params.id + '.html'"></iframe> -->
                      <div class="preview" v-html="product.content"></div>
                    </div>
                  </div>

                  <div class="tabs_item">
                    <div class="products-details-tab-content">
                      <ul class="additional-information">
                        <li><span>Brand:</span> ThemeForest</li>
                        <li><span>Color:</span> Brown</li>
                        <li><span>Size:</span> Large, Medium</li>
                        <li><span>Weight:</span> 27 kg</li>
                        <li><span>Dimensions:</span> 16 x 22 x 123 cm</li>
                      </ul>
                    </div>
                  </div>

                  <div class="tabs_item">
                    <div class="products-details-tab-content">
                      <div class="product-review-form">
                        <h3>Customer Reviews</h3>

                        <div class="review-title">
                          <div class="rating">
                            <i class="bx bxs-star"></i>
                            <i class="bx bxs-star"></i>
                            <i class="bx bxs-star"></i>
                            <i class="bx bxs-star"></i>
                            <i class="bx bxs-star"></i>
                          </div>
                          <p>Based on 2 reviews</p>
                        </div>

                        <div class="review-comments">
                          <div class="review-item">
                            <div class="rating">
                              <i class="bx bxs-star"></i>
                              <i class="bx bxs-star"></i>
                              <i class="bx bxs-star"></i>
                              <i class="bx bxs-star"></i>
                              <i class="bx bxs-star"></i>
                            </div>

                            <h3>Good</h3>
                            <span><strong>Admin</strong> on <strong>July 21, 2021</strong></span>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
                              ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>

                            <a href="#" class="review-report-link">Reply</a>
                          </div>

                          <div class="review-item">
                            <div class="rating">
                              <i class="bx bxs-star"></i>
                              <i class="bx bxs-star"></i>
                              <i class="bx bxs-star"></i>
                              <i class="bx bxs-star"></i>
                              <i class="bx bxs-star"></i>
                            </div>

                            <h3>Good</h3>
                            <span><strong>Admin</strong> on <strong>July 21, 2021</strong></span>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
                              ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>

                            <a href="#" class="review-report-link">Reply</a>
                          </div>
                        </div>

                        <div class="review-form">
                          <h3>Write A Review</h3>

                          <form>
                            <div class="row">
                              <div class="col-lg-6 col-md-6">
                                <div class="form-group">
                                  <label>Name</label>
                                  <input type="text" id="name" name="name" class="form-control">
                                </div>
                              </div>

                              <div class="col-lg-6 col-md-6">
                                <div class="form-group">
                                  <label>Email</label>
                                  <input type="email" id="email" name="email" class="form-control">
                                </div>
                              </div>

                              <div class="col-lg-12 col-md-12">
                                <div class="form-group">
                                  <label>Review title</label>
                                  <input type="text" id="review-title" name="review-title" class="form-control">
                                </div>
                              </div>

                              <div class="col-lg-12 col-md-12">
                                <div class="form-group">
                                  <label>Body of review (1500)</label>
                                  <textarea name="review-body" id="review-body" cols="30" rows="8"
                                    class="form-control"></textarea>
                                </div>
                              </div>

                              <div class="col-lg-12 col-md-12">
                                <button type="submit" class="btn default-btn two">Submit Review</button>
                              </div>
                            </div>
                          </form>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import BiStarFill from '~icons/bi/star-fill';
import BiTwitter from '~icons/bi/twitter';
import BiInstagram from '~icons/bi/instagram';
import BiFacebook from '~icons/bi/facebook';

import { Carousel, Slide, Pagination, Navigation } from 'vue3-carousel'
import { getImgUrl } from '@/utils/getImgUrl';
import { getProduct } from '@/api/product';
import { useRoute } from 'vue-router';
import { useHead } from '@unhead/vue';

export default {
  setup() {
    const route = useRoute()
    return {
      route
    }
  },

  components: {
    BiStarFill,
    BiTwitter,
    BiFacebook,
    BiInstagram,
    Carousel,
    Slide,
    Pagination,
    Navigation
  },
  data() {
    return {
      getImgUrl,
      product: {
        banner: ''
      }
    }
  },
  mounted() {
    const id = this.route.params.id
    getProduct(id).then(res => {
      this.product = res.data
      useHead({
        title: this.product.title,
        meta: [
          { name: 'keywords', content: this.product.keywords },
          { name: 'description', content: this.product.title }
        ]
      })
    })

  }
}
</script>

<style scoped>
.preview>>>table {
  padding: 10px;
}

.preview>>>td {
  border: 1px solid #ccc;
  padding: 10px;
}

/* 鼠标悬停样式 */
tr:hover {
  background-color: #29ec8b;
  /* 鼠标悬停时背景色 */
}
</style>