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
                <router-link to="/index" @click="menuClick(1)" :class="menuActicve[1]">Products</router-link>
              </li>

              <li class="nav-item">
                <router-link to="/index" @click="menuClick(2)" :class="menuActicve[2]">News</router-link>
              </li>

              <li class="nav-item">
                <router-link to="/about" @click="menuClick(3)" :class="menuActicve[3]">Contact</router-link>
              </li>

              <li class="nav-item">
                <router-link to="/about" @click="menuClick(4)" :class="menuActicve[4]">About Us</router-link>
              </li>
            </ul>

            <div class="others-option">
              <div class="get-quote">
                <a href="pricing-style-two.html" class="default-btn">
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
import { defineComponent } from 'vue'

export default defineComponent({
  components: {
    BiCaretDown
  },
  data() {
    return {
      menuActicve: [
        "nav-link",
        "nav-link",
        "nav-link",
        "nav-link",
        "nav-link"
      ]
    }
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