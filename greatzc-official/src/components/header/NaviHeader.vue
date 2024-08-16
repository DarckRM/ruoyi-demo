<template>
  <div class="navbar-area">
    <div class="mobile-nav">
      <div class="container">
        <div class="mobile-menu">
          <div class="logo">
            <a href="index.html">
              <img src="/assets/img/logo.png" alt="logo">
            </a>
          </div>
        </div>
      </div>
    </div>

    <div class="desktop-nav">
      <div class="container">
        <nav class="navbar navbar-expand-md navbar-light">
          <a class="navbar-brand" href="index.html">
            <img style="width: 150px;" src="/assets/img/logo.png" alt="logo">
          </a>
          <div class="collapse navbar-collapse mean-menu">
            <ul class="navbar-nav m-auto">
              <li class="nav-item">
                <router-link to="/index" @click="menuClick(0)" :class="menuActicve[0]">Home</router-link>
              </li>

              <li class="nav-item">
                <router-link to="/products" @click="menuClick(1)" :class="menuActicve[1]">Products</router-link>
              </li>

              <li class="nav-item">
                <router-link to="/news" @click="menuClick(2)" :class="menuActicve[2]">News</router-link>
              </li>

              <li class="nav-item">
                <router-link to="/contact" @click="menuClick(3)" :class="menuActicve[3]">Contact</router-link>
              </li>

              <li class="nav-item">
                <router-link to="/about" @click="menuClick(4)" :class="menuActicve[4]">About Us</router-link>
              </li>
            </ul>

            <div class="others-option">
              <div class="get-quote">
                <a href="contact" class="default-btn">
                  <span>Get A Quote</span>
                </a>
              </div>
            </div>
          </div>
        </nav>
      </div>
    </div>

    <div class="others-option-for-responsive">
      <div class="container">
        <div class="dot-menu">
          <div class="inner">
            <div class="circle circle-one"></div>
            <div class="circle circle-two"></div>
            <div class="circle circle-three"></div>
          </div>
        </div>

        <div class="container">
          <div class="option-inner">
            <div class="others-option justify-content-center d-flex align-items-center">
              <div class="get-quote">
                <a href="pricing-style-two.html" class="default-btn">
                  <span>Get A Quote</span>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- End Navbar Area -->
</template>

<script>
import BiCaretDown from '~icons/bi/caret-down';
import { defineComponent, watch } from 'vue'
import { useRouter } from 'vue-router'

export default defineComponent({
  components: {
    BiCaretDown
  },
  data() {
    return {
      pathMapIndex: {
        index: 0,
        products: 1,
        news: 2,
        contact: 3,
        about: 4
      },
      router: useRouter(),
      menuActicve: [
        "nav-link",
        "nav-link",
        "nav-link",
        "nav-link",
        "nav-link"
      ]
    }
  },
  created() {
    this.$watch(
      () => this.$route.path,
      (newId, oldId) => {
        this.menuClick(this.pathMapIndex[newId.split('/')[1]])
      }
    )
  },
  methods: {
    menuClick(item) {
      this.menuActicve = [
        "nav-link",
        "nav-link",
        "nav-link",
        "nav-link",
        "nav-link"
      ]
      this.menuActicve[item] = "nav-link active"
    }
  }
})
</script>