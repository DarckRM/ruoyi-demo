<template>
  <div class="navbar-area">
    <div class="mobile-nav">
      <div class="container">
        <div class="mobile-menu navbar">
          <div style="width: 150px; float: left;" class="logo">
            <a href="index.html">
              <img src="/assets/img/logo.png" alt="logo">
            </a>
          </div>
          <div class="nav-item ">
            <BButton @click="mobileMenu" variant="outline-primary" class="bx bx-menu nav-link"
              style="font-weight: 600; font-size: 15px; ">
            </BButton>
          </div>
        </div>
      </div>
    </div>

    <BOffcanvas style="min-height: 340px; width: 75%; margin: 0 auto; border-radius: 2px;" no-header v-model="showMenu" placement="top">
      <BListGroup style="width: 100%; margin: 0 auto;">
        <router-link v-for="menu in menuItems" :to="menu.to" @click="menuClick(menu.id)">
          <BListGroupItem button :active="menu.id == current">
            {{ menu.name }}
          </BListGroupItem>
        </router-link>
      </BListGroup>
    </BOffcanvas>

    <div class="desktop-nav">
      <div class="container">
        <nav class="navbar navbar-expand-md navbar-light">
          <a class="navbar-brand" href="index.html">
            <img style="width: 150px;" src="/assets/img/logo.png" alt="logo">
          </a>
          <div class="collapse navbar-collapse mean-menu">
            <ul class="navbar-nav m-auto">
              <li class="nav-item" v-for="menu in menuItems">
                <router-link :to="menu.to" @click="menuClick(menu.id)" :class="menuActicve[menu.id]">{{ menu.name
                  }}</router-link>
              </li>
              <li class="nav-item">
                <a class="nav-link">
                  Languages
                  <i class="bx bx-chevron-down">
                  </i>
                </a>
              </li>
            </ul>
          </div>
        </nav>
      </div>
    </div>
  </div>
  <!-- End Navbar Area -->
</template>

<script>
import BiCaretDown from '~icons/bi/caret-down';
import { defineComponent, watch } from 'vue'
import { useRouter } from 'vue-router'
import { BButton, BListGroupItem } from 'bootstrap-vue-next';

export default defineComponent({
  components: {
    BiCaretDown
  },
  data() {
    return {
      showMenu: false,
      pathMapIndex: {
        index: 0,
        products: 1,
        news: 2,
        contact: 3,
        about: 4
      },
      current: 0,
      menuItems: [
        {
          id: 0,
          name: 'Home',
          to: '/index'
        },
        {
          id: 1,
          name: 'Products',
          to: '/products'
        },
        {
          id: 2,
          name: 'News',
          to: '/news'
        },
        {
          id: 3,
          name: 'Contact',
          to: '/contact'
        },
        {
          id: 4,
          name: 'About',
          to: '/about'
        },
      ],
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
      this.current = item
      this.menuActicve[item] = "nav-link active"
      this.showMenu = false
    },
    mobileMenu() {
      this.showMenu = true
    }
  }
})
</script>