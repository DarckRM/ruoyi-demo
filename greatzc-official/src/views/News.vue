<template>

  <!-- Start Page Title Area -->
  <div class="page-title-area bg-19">
    <div class="container">
      <div class="page-title-content">
        <h2>News</h2>
        <ul>
          <li>
            <a href="index.html">
              Home
            </a>
          </li>
          <li class="active">News</li>
        </ul>
      </div>
    </div>
  </div>
  <!-- End Page Title Area -->

  <!-- Start Blog Column One Area -->
  <div>
    <List></List>
  </div>
  <!-- End Blog Column One Area -->
</template>

<script>
import List from '@/components/news/List.vue';

export default {
  components: {
    List
  }
}
</script>