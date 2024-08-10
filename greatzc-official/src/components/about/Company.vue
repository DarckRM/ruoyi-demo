<template>
  <div class="container">
    <div class="row">
      <div class="col-lg-3">
        <div >
          <img src="/assets/img/about-img.jpg" alt="Image">
          <img src="/assets/img/about-img-2.jpg" alt="Image">
          <div class="experience">
            <div>
              <h2>20 Years Of Experience</h2>
            </div>
          </div>
        </div>
        <ul>
          <li>
            <BiCheck2Circle />
            24/7 Business Support
          </li>
          <li>
            <BiCheck2Circle />
            Secure Transportation
          </li>
          <li>
            <BiCheck2Circle />
            World Wide Most Effective Business
          </li>
          <li>
            <BiCheck2Circle />
            Easy And Quick Problem Analysis
          </li>
        </ul>

        <a href="about-us.html" class="default-btn">
          <span>About Us</span>
        </a>
      </div>

      <div class="col-lg-9">
        <div class="about-content">
          <span class="top-title">About Us</span>
          <h2>{{ aboutInfo.title }}</h2>
          <h4>{{ aboutInfo.subTitle }}</h4>
          <div v-html="aboutInfo.content">
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getAbout } from '@/api/baseInfo';
import BiCheck2Circle from '~icons/bi/check2-circle';

export default {
  data() {
    return {
      aboutInfo: {}
    }
  },
  components: {
    BiCheck2Circle
  },
  mounted() {
    getAbout(1).then(res => {
      this.aboutInfo = res.data
    })
  }
}
</script>