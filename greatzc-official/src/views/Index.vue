<template>
  <div>
    <!-- Start Banner Area -->
    <section class="banner-area bg-1 jarallax" data-jarallax='{"speed": 0.3}'>
      <div class="d-table">
        <div class="d-table-cell">
          <div class="container">
            <div class="row align-items-center">
              <div class="col-lg-9">
                <div class="banner-content">
                  <span class="top-title wow fadeInDown" data-wow-delay="1s">Welcome to GreatZc</span>
                  <h1 class="wow fadeInDown" data-wow-delay="1s">Get The Best Hardware And
                    Industrail Device Support</h1>
                  <p class="wow fadeInLeft" data-wow-delay="1s">
                    With high quality products, advanced technology, affordable price and best after-sales service
                  </p>
                  <div class="banner-btn wow fadeInUp" data-wow-delay="1s">
                    <a href="pricing-style-one.html" class="default-btn">
                      <span>Read More</span>
                    </a>
                    <a href="contact-us.html" class="default-btn active">
                      <span>Contact Us</span>
                    </a>
                  </div>
                </div>
              </div>

              <div class="col-lg-3">
                <div class="video-btn-2 wow zoomIn" data-wow-delay="1s">
                  <a href="" class="popup-youtube">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <i class="flaticon-play-button"></i>
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- End Banner Area -->

    <!-- Start About Us Area -->
    <section class="about-us-area pt-100 pb-70">
      <carousel :autoplay="5000" :wrap-around="true" :transition="500">
        <slide class="single-choose-us-box bg-color-1">
          <img src="/assets/img/banner/1.jpg" />
        </slide>
        <slide class="single-choose-us-box bg-color-1">
          <img src="/assets/img/banner/2.jpg" />
        </slide>
        <slide class="single-choose-us-box bg-color-1">
          <img src="/assets/img/banner/3.jpg" />
        </slide>
        <template #addons>
          <Navigation />
          <Pagination />
        </template>
      </carousel>
    </section>
    <!-- End About Us Area -->

    <!-- Start Services Area -->
    <section class="services-area bg-color pt-100 pb-70">
      <div class="container">
        <div class="section-title">
          <span>Our Services</span>
          <h2>We Are Trusted For Our Services</h2>
          <p> With high quality products, advanced technology, affordable price and best after-sales service </p>
          <p> We Have Gained Trust </p>
        </div>

        <div class="row">
          <div class="col-lg-3 col-sm-6">
            <div class="single-services-box">
              <i class="flaticon-user"></i>
              <h3>Our Team</h3>
              <p>We have an experienced R&D team, ensure technological and innovative products!</p>
              <a href="" class="read-more">
                Read More
              </a>
            </div>
          </div>

          <div class="col-lg-3 col-sm-6">
            <div class="single-services-box">
              <i class="flaticon-warehouse"></i>
              <h3>Our Equipment</h3>
              <p>With advanced development equipments and comprehensive test facilities, experienced and skilled
                workers,
                product quality and safety are highly guaranteed!</p>

              <a href="services-details.html" class="read-more">
                Read More
              </a>
            </div>
          </div>

          <div class="col-lg-3 col-sm-6 offset-sm-3 offset-lg-0">
            <div class="single-services-box">
              <i class="flaticon-done"></i>
              <h3>Quality Inspection</h3>
              <p>We have comprehensive test facilities and we will carefully test products to ensure the quality before
                each
                delivery!</p>

              <a href="services-details.html" class="read-more">
                Read More
              </a>
            </div>
          </div>

          <div class="col-lg-3 col-sm-6 offset-sm-3 offset-lg-0">
            <div class="single-services-box">
              <i class="flaticon-support"></i>
              <h3>After Sales</h3>
              <p>Our working team and sales team can guarantee a comprehensive and efficient after-sales service for our
                products sold to everywhere of the world.</p>

              <a href="services-details.html" class="read-more">
                Read More
              </a>
            </div>
          </div>

        </div>
      </div>
    </section>
    <!-- End Services Area -->

    <!-- Start Choose Us Area -->
    <section class="counter-area bg-color">
      <Company />
    </section>
    <!-- End Choose Us Area -->

    <!-- Start Counter Area -->
    <section style="display: none;" class="counter-area bg-color pt-100 pb-70">
      <div class="container">
        <div class="row">
          <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="single-counter">
              <i class="flaticon-package"></i>

              <h2>
                <span class="odometer" data-count="950">00</span>
                <span class="target">+</span>
              </h2>

              <p>Delivered Devices</p>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="single-counter">
              <i class="flaticon-worldwide"></i>

              <h2>
                <span class="odometer" data-count="850">00</span>
                <span class="target">+</span>
              </h2>

              <p>Countries Covered</p>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="single-counter">
              <i class="flaticon-user"></i>

              <h2>
                <span class="odometer" data-count="550">00</span>
                <span class="traget">+</span>
              </h2>

              <p>Happy Clients</p>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="single-counter">
              <i class="flaticon-location-1"></i>

              <h2>
                <span class="odometer" data-count="440">00</span>
                <span class="target">+</span>
              </h2>

              <p>Tons Of Goods</p>
            </div>
          </div>
        </div>
      </div>
    </section>
    <div class="track-area jarallax">
      <Feedback />
    </div>
    <div class="partner-area bg-color ptb-70">
      <div class="container">
        <div class="row">
          <div class="partner-slider owl-carousel owl-theme">
            <div class="partner-item">
              <a href="#">
                <img src="/assets/img/partner/partner-1.png" alt="Image">
              </a>
            </div>
            <div class="partner-item">
              <a href="#">
                <img src="/assets/img/partner/partner-2.png" alt="Image">
              </a>
            </div>
            <div class="partner-item">
              <a href="#">
                <img src="/assets/img/partner/partner-3.png" alt="Image">
              </a>
            </div>
            <div class="partner-item">
              <a href="#">
                <img src="/assets/img/partner/partner-4.png" alt="Image">
              </a>
            </div>
            <div class="partner-item">
              <a href="#">
                <img src="/assets/img/partner/partner-5.png" alt="Image">
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- End Partner Area -->
  </div>
</template>

<script setup>
import { Carousel, Slide, Pagination, Navigation } from 'vue3-carousel'
import Company from '../components/about/Company.vue'
import Feedback from '../components/contact/Message.vue'
</script>