<template>
  <section class="choose-us-area pt-100 pb-70">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 col-md-6">
          <div class="choose-us-content">
            <span class="top-title">OUR COMPANY CULTURE</span>
            <h2>We Are The Best And That's Why You Can Choose Us Easily</h2>
            <p>
              Our company culture fosters innovation and teamwork, driving us toward our objective of global
              sustainability. Our mission is to empower communities through technology. Vision: a world where tech
              bridges divides. Values: integrity, passion, inclusivity, excellence, and respect guide every decision.
            </p>

            <carousel :autoplay="2000" :wrap-around="true" :transition="500">
              <slide v-for="item in cultureData" :class="item.icon">
                <div style="text-align: left; margin: 0 30px; width: 100%;">
                  <div>
                    <i class="bx">
                      <BiListTask />
                      <h5>{{ item.title }}</h5>
                    </i>
                  </div>
                  <span>
                    <br />{{ item.content }}
                  </span>
                </div>
              </slide>
              <template #addons>
                <Navigation />
              </template>
            </carousel>

          </div>
        </div>

        <div class="col-lg-6 col-md-6">
          <div class="choose-us-img">
            <img src="/assets/img/choose-us-img.jpg" alt="Image">
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
import { Carousel, Slide, Pagination, Navigation } from 'vue3-carousel'
import BiListTask from '~icons/bi/list-task';

const cultureData = [
  {
    icon: 'single-choose-us-box bg-color-1',
    title: 'Our Objective',
    content: 'Achieve our customers value Provide our empolyeers happy development platform Build great team with social responsibility'
  },
  {
    icon: 'single-choose-us-box bg-color-2',
    title: 'Our Vision',
    content: 'To be world famous computer specialist'
  },
  {
    icon: 'single-choose-us-box bg-color-3',
    title: 'Our Misson',
    content: 'Provide high quality products and best after-sales services, Establish joyfull platform for our employees'
  },
  {
    icon: 'single-choose-us-box bg-color-4',
    title: 'Our Values',
    content: 'Quality, Services, Integrity, Efficiency'
  },
]
</script>