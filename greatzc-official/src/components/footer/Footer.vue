<template>
  <footer class="footer-area pt-100 pb-70">
    <div class="container">
      <div class="row">
        <div class="col-lg-3 col-md-6">
          <div class="single-footer-widget">
            <a href="index.html" class="logo">
              <img src="/assets/img/logo.png" alt="Image">
            </a>

            <p>Lorem ipsum dolor sit amet, consec tetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et
              dolore magna aliqua consec.</p>

            <ul class="social-icon">
              <li>
                <a href="#">
                  <i class="bx bxl-facebook"></i>
                </a>
              </li>
              <li>
                <a href="#">
                  <i class="bx bxl-instagram"></i>
                </a>
              </li>
              <li>
                <a href="#">
                  <i class="bx bxl-linkedin-square"></i>
                </a>
              </li>
              <li>
                <a href="#">
                  <i class="bx bxl-twitter"></i>
                </a>
              </li>
            </ul>
          </div>
        </div>

        <div class="col-lg-3 col-md-6">
          <div class="single-footer-widget">
            <h3>Services</h3>

            <ul class="import-link">
              <li>
                <a href="#">Sea Freight</a>
              </li>
              <li>
                <a href="#">Air Freight</a>
              </li>
              <li>
                <a href="#">Road Freight</a>
              </li>
              <li>
                <a href="#">Local Delivery</a>
              </li>
              <li>
                <a href="#">Bus Freight</a>
              </li>
              <li>
                <a href="#">Car Freight</a>
              </li>
            </ul>
          </div>
        </div>

        <div class="col-lg-3 col-md-6">
          <div class="single-footer-widget">
            <h3>Company</h3>

            <ul class="import-link">
              <li>
                <a href="about-us.html">About Us</a>
              </li>
              <li>
                <a href="team.html">Team</a>
              </li>
              <li>
                <a href="faq.html">FAQ</a>
              </li>
              <li>
                <a href="blog-column-one.html">Blog</a>
              </li>
              <li>
                <a href="privacy-policy.html">Privacy Policy</a>
              </li>
              <li>
                <a href="terms-conditions.html">Terms And Conditions</a>
              </li>
            </ul>
          </div>
        </div>

        <div class="col-lg-3 col-md-6">
          <div class="single-footer-widget">
            <h3>Address</h3>
            <ul class="address">
              <li class="location">
                <i class="bx">
                  <BiBuilding style="width: 25px;" />
                </i>
                {{ info.address }}
              </li>
              <li>
                <i class="bx">
                  <BiEnvelope style="width: 25px;" />
                </i>
                <a :href="info.mailto">{{ info.email }}</a>
              </li>
              <li>
                <i class="bx">
                  <BiTelephone style="width: 25px;" />
                </i>
                <a href="">{{ info.tel }}</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </footer>
  <div class="copy-right-area">
    <div class="container">
      <p>Copyright &copy; 2021.Company name All rights reserved.<a target="_blank" href=""></a></p>
    </div>
  </div>
</template>

<script setup>
import BiEnvelope from '~icons/bi/envelope';
import BiBuilding from '~icons/bi/building';
import BiTelephone from '~icons/bi/telephone';

const info = {
  address: '407-410,Building 3,Nanshan Yun Gu Innovation Industrial Park,\nNo.4093 Liuxian Avenue,Nanshan District,Shenzhen City,Zipcode 518051,China',
  tel: '+ (86) 17898469007',
  email: 'greatzc01@aliyun.com',
  mailto: 'mailto:greatzc01@aliyun.com'
}
</script>