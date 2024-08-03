<template>
  <!-- Start Banner Area -->
  <section style="background-attachment: scroll;" class="banner-area bg-1 jarallax" data-jarallax='{"speed": 0.3}'>
    <div class="d-table">
      <div class="d-table-cell">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-lg-9">
              <div class="banner-content">
                <span class="top-title wow fadeInDown" data-wow-delay="1s">Welcome to GreatZc</span>
                <h1 style="color: white;" class="wow fadeInDown" data-wow-delay="1s">Get The Best Hardware And
                  Industrail Device Support</h1>
                <p style="color: white;" class="wow fadeInLeft" data-wow-delay="1s">
                  With hiht quality products, advanced technology, affordable price and best AFTER-SALES service
                </p>
                <div class="banner-btn wow fadeInUp" data-wow-delay="1s">
                  <a href="pricing-style-one.html" class="default-btn">
                    <span>Read More</span>
                  </a>
                  <a href="contact-us.html" class="default-btn active">
                    <span style="color: white;">Contact Us</span>
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
    <BCarousel fade :interval="3000" controls indicators ride="carousel">
      <BCarouselSlide>
        <template #img>
          <img src="/assets/img/banner/1.jpg" alt="image slot" />
        </template>
      </BCarouselSlide>

      <BCarouselSlide>
        <template #img>
          <img src="/assets/img/banner/2.jpg" alt="image slot" />
        </template>
      </BCarouselSlide>

      <BCarouselSlide>
        <template #img>
          <img src="/assets/img/banner/3.jpg" alt="image slot" />
        </template>
      </BCarouselSlide>
    </BCarousel>

  </section>
  <!-- End About Us Area -->

  <!-- Start Services Area -->
  <section class="services-area bg-color pt-100 pb-70">
    <div class="container">
      <div class="section-title">
        <span>Our Services</span>
        <h2>We Are Trusted For Our Services</h2>
        <p> With hiht quality products, advanced technology, affordable price and best AFTER-SALES service </p>
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
            <p>With advanced development equipments and comprehensive test facilities, experienced and skilled workers,
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
  <section class="counter-area bg-color pt-100 pb-70">
    <div class="container">
      <div class="row">
        <div class="col-lg-3 col-md-6 col-sm-6">
          <div class="single-counter">
            <i class="flaticon-package"></i>

            <h2>
              <span class="odometer" data-count="950">00</span>
              <span class="target">+</span>
            </h2>

            <p>Delivered Packages</p>
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
  <!-- End Counter Area -->

  <!-- Start Track Area -->
  <section class="track-area ptb-100 jarallax" data-jarallax='{"speed": 0.3}'>
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="tab quote-list-tab">
            <ul class="tabs">
              <li>
                <a href="#">
                  <i class="flaticon-truck"></i>
                  Track & Trace
                </a>
              </li>
              <li>
                <a href="#">
                  Request A Quote
                  <i class="flaticon-location"></i>
                </a>
              </li>
            </ul>

            <div class="tab_content">
              <div class="tabs_item">
                <form>
                  <div class="row">
                    <div class="col-12">
                      <h3>Personal Data</h3>
                    </div>

                    <div class="col-lg-4 col-sm-6">
                      <div class="form-group">
                        <input type="text" class="form-control" placeholder="Your Name">
                      </div>
                    </div>

                    <div class="col-lg-4 col-sm-6">
                      <div class="form-group">
                        <input type="email" class="form-control" placeholder="Your Email">
                      </div>
                    </div>

                    <div class="col-lg-4">
                      <div class="form-group">
                        <input type="text" class="form-control" placeholder="Your Phone">
                      </div>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-12">
                      <h3>Shipment Data</h3>
                    </div>

                    <div class="col-lg-4 col-sm-6">
                      <div class="form-group">
                        <select>
                          <option value="1">Type of flight One</option>
                          <option value="2">Type of flight Two</option>
                          <option value="0">Type of flight Three</option>
                          <option value="3">Type of flight Four</option>
                          <option value="4">Type of flight Five</option>
                          <option value="5">Type of flight Six</option>
                          <option value="6">Type of flight Seven</option>
                        </select>
                      </div>
                    </div>

                    <div class="col-lg-4 col-sm-6">
                      <div class="form-group">
                        <input type="text" class="form-control" placeholder="City of Departure">
                      </div>
                    </div>

                    <div class="col-lg-4">
                      <div class="form-group">
                        <input type="text" class="form-control" placeholder="Which City">
                      </div>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-lg-4 col-sm-6">
                      <div class="form-group">
                        <select>
                          <option value="1">Incomers One</option>
                          <option value="2">Incomers Two</option>
                          <option value="0">Incomers Three</option>
                          <option value="3">Incomers Four</option>
                          <option value="4">Travel Insurance Five</option>
                          <option value="5">Incomers Six</option>
                          <option value="6">Incomers Seven</option>
                        </select>
                      </div>
                    </div>

                    <div class="col-lg-2 col-sm-6">
                      <div class="form-group">
                        <input type="text" class="form-control" placeholder="Width ">
                      </div>
                    </div>

                    <div class="col-lg-2 col-sm-6">
                      <div class="form-group">
                        <input type="text" class="form-control" placeholder="Height">
                      </div>
                    </div>

                    <div class="col-lg-2 col-sm-6">
                      <div class="form-group">
                        <input type="text" class="form-control" placeholder="weight">
                      </div>
                    </div>

                    <div class="col-lg-2">
                      <div class="form-group">
                        <input type="text" class="form-control" placeholder="Length">
                      </div>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-sm-6 col-md-3">
                      <label class="single-check">
                        Express Delivery
                        <input type="radio" checked="checked" name="radio">
                        <span class="checkmark"></span>
                      </label>
                    </div>

                    <div class="col-lg-3 col-sm-6 col-md-3">
                      <label class="single-check">
                        Ocean Freight
                        <input type="radio" name="radio">
                        <span class="checkmark"></span>
                      </label>
                    </div>

                    <div class="col-lg-3 col-sm-6 col-md-3">
                      <label class="single-check">
                        Road Freight
                        <input type="radio" name="radio">
                        <span class="checkmark"></span>
                      </label>
                    </div>

                    <div class="col-lg-3 col-sm-6 col-md-3">
                      <label class="single-check">
                        Air Freight
                        <input type="radio" name="radio">
                        <span class="checkmark"></span>
                      </label>
                    </div>

                    <div class="col-12">
                      <button type="submit" class="default-btn">
                        Request A Quote
                      </button>
                    </div>
                  </div>
                </form>
              </div>

              <div class="tabs_item">
                <form>
                  <div class="row">
                    <div class="col-12">
                      <h3>Shipment Type</h3>
                      <div class="form-group">
                        <select>
                          <option value="1">Property Used For</option>
                          <option value="2">Home Insurance</option>
                          <option value="0">Business Insurance</option>
                          <option value="3">Health Insurance</option>
                          <option value="4">Travel Insurance</option>
                          <option value="5">Car Insurance</option>
                          <option value="6">Life Insurance</option>
                        </select>
                      </div>
                    </div>

                    <div class="col-12 mt-30">
                      <h3>Tracking Number</h3>
                    </div>

                    <div class="col-12">
                      <div class="form-group">
                        <textarea class="form-control"
                          placeholder="You can enter up to a maximum of 10 airway bill numbers for tracking."></textarea>
                      </div>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-sm-6 col-md-3">
                      <label class="single-check">
                        Express Delivery
                        <input type="radio" checked="checked" name="radio">
                        <span class="checkmark"></span>
                      </label>
                    </div>

                    <div class="col-lg-3 col-sm-6 col-md-3">
                      <label class="single-check">
                        Ocean Freight
                        <input type="radio" name="radio">
                        <span class="checkmark"></span>
                      </label>
                    </div>

                    <div class="col-lg-3 col-sm-6 col-md-3">
                      <label class="single-check">
                        Road Freight
                        <input type="radio" name="radio">
                        <span class="checkmark"></span>
                      </label>
                    </div>

                    <div class="col-lg-3 col-sm-6 col-md-3">
                      <label class="single-check">
                        Air Freight
                        <input type="radio" name="radio">
                        <span class="checkmark"></span>
                      </label>
                    </div>

                    <div class="col-12">
                      <button type="submit" class="default-btn">
                        Request A Quote
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
  </section>
  <!-- End Track Area -->

  <!-- Start Pricing Area -->
  <section class="pricing-area pt-100 pb-70">
    <div class="container">
      <div class="section-title">
        <span>Our Pricing</span>
        <h2>Our Pricing Plan And All Other Details At A Glance</h2>
        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Fugit porro, aliquid reprehenderit iusto inventore
          sint beatae ipsum impedit in sit numquam illum distinctio sequi quisquam et hic tempore</p>
      </div>

      <div class="row">
        <div class="col-lg-4 col-md-6">
          <div class="single-pricing-box">
            <h3>Starter</h3>
            <h2>$20 <sub>Monthly</sub></h2>

            <ul>
              <li>
                <i class="bx bx-check"></i>
                All-time access on all transports
              </li>
              <li>
                <i class="bx bx-check"></i>
                Have a good premium on member
              </li>
              <li>
                <i class="bx bx-check"></i>
                60% Discount for the basic users
              </li>
              <li>
                <i class="bx bx-x"></i>
                All the time vat and tax-free
              </li>
              <li>
                <i class="bx bx-x"></i>
                Auto contact to our service point
              </li>
            </ul>

            <a href="#" class="default-btn">
              <span>Start This Plan</span>
            </a>

            <span class="quality">Good</span>
          </div>
        </div>

        <div class="col-lg-4 col-md-6">
          <div class="single-pricing-box">
            <h3>Premium</h3>
            <h2>$40 <sub>Monthly</sub></h2>

            <ul>
              <li>
                <i class="bx bx-check"></i>
                All-time access on all transports
              </li>
              <li>
                <i class="bx bx-check"></i>
                Have a good premium on member
              </li>
              <li>
                <i class="bx bx-check"></i>
                60% Discount for the basic users
              </li>
              <li>
                <i class="bx bx-check"></i>
                All the time vat and tax-free
              </li>
              <li>
                <i class="bx bx-x"></i>
                Auto contact to our service point
              </li>
            </ul>

            <a href="#" class="default-btn">
              <span>Start This Plan</span>
            </a>

            <span class="quality">Better</span>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 offset-md-3 offset-lg-0">
          <div class="single-pricing-box">
            <h3>Platinum</h3>
            <h2>$60 <sub>Monthly</sub></h2>

            <ul>
              <li>
                <i class="bx bx-check"></i>
                All-time access on all transports
              </li>
              <li>
                <i class="bx bx-check"></i>
                Have a good premium on member
              </li>
              <li>
                <i class="bx bx-check"></i>
                60% Discount for the basic users
              </li>
              <li>
                <i class="bx bx-check"></i>
                All the time vat and tax-free
              </li>
              <li>
                <i class="bx bx-check"></i>
                Auto contact to our service point
              </li>
            </ul>

            <a href="#" class="default-btn">
              <span>Start This Plan</span>
            </a>

            <span class="quality">Best</span>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- End Pricing Area -->

  <!-- Start Shipment Area -->
  <section class="shipment-area ptb-100 jarallax" data-jarallax='{"speed": 0.3}'>
    <div class="container">
      <div class="shipment-content">
        <span class="top-title">Shipment</span>
        <h2>Are You A Shipper? Please Knock Us On The Below Button</h2>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quam iste facere, unde nesciunt ratione amet
          voluptatibus aut, iure magnam accusantium consequatur voluptatum nam ipsum in soluta consectetur temporibus
          nobis itaque!</p>

        <div class="shipment-btn">
          <a href="#" class="default-btn">
            <span>Make A Shipment</span>
          </a>
          <a href="contact-us.html" class="default-btn active">
            <span>Contact Us</span>
          </a>
        </div>
      </div>
    </div>
  </section>
  <!-- End Shipment Area -->

  <!-- Start Testimonials Area -->
  <section class="testimonials-area ptb-100">
    <div class="container-fluid p-0">
      <div class="section-title">
        <span>Our Testimonials</span>
        <h2>Let's Know About All Of Our Client Says</h2>
        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Fugit porro, aliquid reprehenderit iusto inventore
          sint beatae ipsum impedit in sit numquam illum distinctio sequi quisquam et hic tempore</p>
      </div>

      <div class="testimonials-slider owl-carousel owl-theme">
        <div class="single-testimonials">
          <img src="/assets/img/testimonials/testimonials-1.jpg" alt="Image">
          <h3>Awesome Quality Service</h3>
          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque animi voluptatum repudiandae
            exercitationem, deserunt, perferendis a sequi maiores reprehenderit quaerat et assumenda dolores dolorem</p>
          <h4>Lopizan Astino</h4>
          <span>Founder Autocar inc</span>
        </div>

        <div class="single-testimonials">
          <img src="/assets/img/testimonials/testimonials-2.jpg" alt="Image">
          <h3>Awesome Quality Team</h3>
          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque animi voluptatum repudiandae
            exercitationem, deserunt, perferendis a sequi maiores reprehenderit quaerat et assumenda dolores dolorem</p>
          <h4>Walino Arinton</h4>
          <span>Coex Founder</span>
        </div>

        <div class="single-testimonials">
          <img src="/assets/img/testimonials/testimonials-3.jpg" alt="Image">
          <h3>Awesome Quality Roll</h3>
          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque animi voluptatum repudiandae
            exercitationem, deserunt, perferendis a sequi maiores reprehenderit quaerat et assumenda dolores dolorem</p>
          <h4>Rontin Ariston</h4>
          <span>Exton Extention Author</span>
        </div>

        <div class="single-testimonials">
          <img src="/assets/img/testimonials/testimonials-4.jpg" alt="Image">
          <h3>Awesome Quality Preview</h3>
          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque animi voluptatum repudiandae
            exercitationem, deserunt, perferendis a sequi maiores reprehenderit quaerat et assumenda dolores dolorem</p>
          <h4>Lopizan Juhon</h4>
          <span>Founder CEO</span>
        </div>
      </div>
    </div>
  </section>
  <!-- End Testimonials Area -->

  <!-- Start Partner Area -->
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

  <!-- Start Blog Area -->
  <section class="blog-area ptb-100">
    <div class="container">
      <div class="section-title">
        <span>Our Blog</span>
        <h2>Make A Relation With Our Blog Article And Meet With Our Blogs</h2>
        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Fugit porro, aliquid reprehenderit iusto inventore
          sint beatae ipsum impedit in sit numquam illum distinctio sequi quisquam et hic tempore</p>
      </div>

      <div class="row">
        <div class="blog-slider owl-carousel owl-theme">
          <div class="single-blog-post">
            <div class="post-image">
              <a href="#">
                <img src="/assets/img/blog/blog-1.jpg" alt="image">
              </a>
            </div>

            <div class="blog-content">
              <div class="date">
                <i class="bx bx-calendar"></i>
                <span>06 October 2019</span>
              </div>

              <h3>
                <a href="#">New Cargo Shipment Is Open On The Global Market</a>
              </h3>

              <p>Luis ipsum suspendisse ultrices. Risus commodo viverra maecenas accumsan lacus vel facilisis ultrices
                Risus ipsum.</p>

              <a href="blog-details.html" class="default-btn">
                <span>Read More</span>
              </a>
            </div>
          </div>

          <div class="single-blog-post">
            <div class="post-image">
              <a href="#">
                <img src="/assets/img/blog/blog-2.jpg" alt="image">
              </a>
            </div>

            <div class="blog-content">
              <div class="date">
                <i class="bx bx-calendar"></i>
                <span>07 October 2019</span>
              </div>

              <h3>
                <a href="#">Transportation Charged Has Removed Form This Months</a>
              </h3>

              <p>Luis ipsum suspendisse ultrices. Risus commodo viverra maecenas accumsan lacus vel facilisis ultrices
                Risus ipsum.</p>

              <a href="blog-details.html" class="default-btn">
                <span>Read More</span>
              </a>
            </div>
          </div>

          <div class="single-blog-post">
            <div class="post-image">
              <a href="#">
                <img src="/assets/img/blog/blog-3.jpg" alt="image">
              </a>
            </div>

            <div class="blog-content">
              <div class="date">
                <i class="bx bx-calendar"></i>
                <span>08 October 2019</span>
              </div>

              <h3>
                <a href="#">Marketing Policy Added Into The Logistic Service</a>
              </h3>

              <p>Luis ipsum suspendisse ultrices. Risus commodo viverra maecenas accumsan lacus vel facilisis ultrices
                Risus ipsum.</p>

              <a href="blog-details.html" class="default-btn">
                <span>Read More</span>
              </a>
            </div>
          </div>

          <div class="single-blog-post">
            <div class="post-image">
              <a href="#">
                <img src="/assets/img/blog/blog-4.jpg" alt="image">
              </a>
            </div>

            <div class="blog-content">
              <div class="date">
                <i class="bx bx-calendar"></i>
                <span>09 October 2019</span>
              </div>

              <h3>
                <a href="#">Transportation Charged Has Removed Form This Months</a>
              </h3>

              <p>Luis ipsum suspendisse ultrices. risus commodo viverra maecenas accumsan lacus vel facilisis ultrices
                risus ipsum.</p>

              <a href="blog-details.html" class="default-btn">
                <span>Read More</span>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

  <div class="go-top">
    <i class="bx bx-chevrons-up"></i>
    <i class="bx bx-chevrons-up"></i>
  </div>
  <!-- End Go Top Area -->
</template>

<script setup>
import Company from '../components/about/Company.vue'
</script>