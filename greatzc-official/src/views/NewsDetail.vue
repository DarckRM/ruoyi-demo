<template>
  <div class="blog-details-area">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="blog-details-content">
            <div class="blog-details-img">
              <carousel :autoplay="5000" :wrap-around="true" :transition="500">
                <slide v-for="banner in newsInfo.banner.split(',')" class="single-choose-us-box bg-color-1">
                  <img style="max-height: 400px;" :src="getImgUrl(banner)" alt="Image">
                </slide>
              </carousel>
            </div>

            <div class="blog-top-content">
              <div class="news-content">
                <ul class="admin">
                  <li>
                    <a href="#">
                      <i class="bx bx-user-circle"></i>
                      Posted by: {{ newsInfo.author }}
                    </a>
                  </li>

                  <li>
                    <a href="#">
                      <i class="bx bx-comment"></i>
                      No comments
                    </a>
                  </li>

                  <li class="float">
                    <i class="bx bx-calendar-alt"></i>
                    {{ newsInfo.createTime }}
                  </li>
                </ul>

                <h3>{{ newsInfo.title }}</h3>

                <div v-html="newsInfo.content">

                </div>
              </div>

              <blockquote>
                <p>"Supplier of Embedded IPCs, Embedded Motherboards, OPS PCs, Firewall Products"</p>
                <i class="bx bxs-quote-alt-left"></i>
              </blockquote>
            </div>

            <div style="display: none;" class="comments">
              <h3>Comments (2)</h3>

              <ul>
                <li>
                  <img src="/assets/img/blog-details/comments-1.jpg" alt="Image">
                  <h3>Juanita Jones</h3>
                  <span>Monday, October 20, 2021</span>

                  <p>Lorem ipsum dolora sit amet, consectetur adipiscing elit sed do eiusmod tempor incdidunt labore
                    et
                    dolore magna aliqua. Veniam quis nostrud exercitation ullaco</p>

                  <a href="#">
                    Reply
                  </a>
                </li>

                <li>
                  <img src="/assets/img/blog-details/comments-2.jpg" alt="Image">
                  <h3>Ward F. Nelson</h3>
                  <span>Monday, October 20, 2021</span>

                  <p>Lorem ipsum dolora sit amet, consectetur adipiscing elit sed do eiusmod tempor incdidunt labore
                    et
                    dolore magna aliqua. Veniam quis nostrud exercitation ullaco</p>

                  <a href="#">
                    Reply
                  </a>
                </li>
              </ul>
            </div>

            <div style="display: none;" class="leave-reply">
              <h3>Leave A Reply</h3>
              <p>Your email address will not be published. Required fields are marked<span class="star">*</span></p>

              <form>
                <div class="row">
                  <div class="col-lg-6 col-sm-6">
                    <div class="form-group">
                      <label>Name<span class="star">*</span></label>
                      <input type="text" name="name" id="name" class="form-control">
                    </div>
                  </div>

                  <div class="col-lg-6 col-sm-6">
                    <div class="form-group">
                      <label>Email address<span class="star">*</span></label>
                      <input type="email" name="email" id="email" class="form-control">
                    </div>
                  </div>

                  <div class="col-lg-12">
                    <div class="form-group">
                      <label>Your website</label>
                      <input type="text" name="your-website-link" id="your-website-link" class="form-control">
                    </div>
                  </div>

                  <div class="col-lg-12 col-md-12">
                    <div class="form-group">
                      <label>Comment</label>
                      <textarea name="message" class="form-control" id="message" rows="8"></textarea>
                    </div>
                  </div>

                  <div class="col-12">
                    <div class="form-group">
                      <input type="checkbox" id="chb2">
                      <span>
                        Save my name, email, and website in this browser for the next time I comment.
                      </span>
                    </div>
                  </div>

                  <div class="col-lg-12 col-md-12">
                    <button type="submit" class="default-btn page-btn">
                      <span>Post A Comment</span>
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
import { getNews } from '@/api/news';
import { useRoute } from 'vue-router';
import { Carousel, Slide, Pagination, Navigation } from 'vue3-carousel'
import { getImgUrl } from '@/utils/getImgUrl';
import { useHead } from '@unhead/vue';

export default {
  components: {
    Carousel,
    Slide,
    Pagination,
    Navigation
  },
  setup() {
    const route = useRoute()
    return {
      route
    }
  },
  data() {
    return {
      getNews,
      getImgUrl,
      useHead,
      newsInfo: {
        banner: ''
      }
    }
  },
  mounted() {
    const id = this.route.params.id
    getNews(id).then(res => {
      this.newsInfo = res.data
      useHead({
        title: this.newsInfo.title,
        meta: [
          { name: 'keywords', content: this.newsInfo.keywords },
          { name: 'description', content: this.newsInfo.title }
        ]
      })
    })
  }
}
</script>