<template>
  <div>
    <div class="page-title-area bg-1">
      <div class="container">
        <div class="page-title-content">
          <h2>About Us</h2>
          <ul>
            <li>
              <a href="index">
                Home
              </a>
            </li>
            <li class="active">About Us</li>
          </ul>
        </div>
      </div>
    </div>
    <section style="" class="about-us-area pt-100 pb-70">
      <Company />
    </section>
    <!-- End About Us Area -->

    <!-- Start Counter Area -->
    <div>
      <Timeline />
    </div>
    <!-- End Counter Area -->

    <!-- Start Choose Us Area -->
    <div>
      <Culture />
    </div>

    <!-- End Choose Us Area -->

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
                          <input type="text" class="form-control" placeholder="width">
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

    <!-- Start Testimonials Area -->
    <section class="testimonials-area ptb-100">
      <div class="container-fluid p-0">
        <div class="section-title">
          <span>Our Testimonials</span>
          <h2>Let's Know About All Of Our Client Says</h2>
          <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Fugit porro, aliquid reprehenderit iusto
            inventore
            sint beatae ipsum impedit in sit numquam illum distinctio sequi quisquam et hic tempore</p>
        </div>

        <div class="testimonials-slider owl-carousel owl-theme">
          <div class="single-testimonials">
            <img src="/assets/img/testimonials/testimonials-1.jpg" alt="Image">
            <h3>Awesome Quality Service</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque animi voluptatum repudiandae
              exercitationem, deserunt, perferendis a sequi maiores reprehenderit quaerat et assumenda dolores dolorem
            </p>
            <h4>Lopizan Astino</h4>
            <span>Founder Autocar inc</span>
          </div>

          <div class="single-testimonials">
            <img src="/assets/img/testimonials/testimonials-2.jpg" alt="Image">
            <h3>Awesome Quality Roll</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque animi voluptatum repudiandae
              exercitationem, deserunt, perferendis a sequi maiores reprehenderit quaerat et assumenda dolores dolorem
            </p>
            <h4>Walino Arinton</h4>
            <span>Coex Founder</span>
          </div>

          <div class="single-testimonials">
            <img src="/assets/img/testimonials/testimonials-3.jpg" alt="Image">
            <h3>Awesome Quality Transport</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque animi voluptatum repudiandae
              exercitationem, deserunt, perferendis a sequi maiores reprehenderit quaerat et assumenda dolores dolorem
            </p>
            <h4>Rontin Ariston</h4>
            <span>Exton Extention Author</span>
          </div>

          <div class="single-testimonials">
            <img src="/assets/img/testimonials/testimonials-4.jpg" alt="Image">
            <h3>Awesome Quality Logistics</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Cumque animi voluptatum repudiandae
              exercitationem, deserunt, perferendis a sequi maiores reprehenderit quaerat et assumenda dolores dolorem
            </p>
            <h4>Lopizan Juhon</h4>
            <span>Founder CEO</span>
          </div>
        </div>
      </div>
    </section>
    <!-- End Testimonials Area -->

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
    <!-- End Team Area -->

    <!-- Start Partner Area -->
    <div class="partner-area bg-color">
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
  </div>
</template>

<script setup>
import Timeline from '../components/about/Timeline.vue'
import Company from '../components/about/Company.vue'
import Culture from '../components/about/Culture.vue'

</script>