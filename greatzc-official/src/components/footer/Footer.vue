<template>
  <footer class="footer-area pt-100 pb-70">
    <div class="container">
      <div class="row">
        <div class="col-lg-3 col-md-6">
          <div class="single-footer-widget">
            <a href="index.html" class="logo">
              <img style="width: 160px; filter: brightness(100);" src="/assets/img/logo.png" alt="Image">
            </a>

            <p> Professional Supplier of Embedded Motherboards,Embedded Computers,Mini PCs,OPS PCs,Mini Itx
              Motherboards,Fanless Motherboardss,Firewall Products</p>

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

        <div class="col-lg-4 col-md-6">
          <div class="single-footer-widget">
            <h3>Company</h3>
            <ul class="import-link">
              <li>
                <a href="index">Home</a>
              </li>
              <li>
                <a href="products">Products</a>
              </li>
              <li>
                <a href="news">News</a>
              </li>
              <li>
                <a href="contact">Contact Us</a>
              </li>
            </ul>
          </div>
        </div>

        <div class="col-lg-4 col-md-6">
          <div class="single-footer-widget">
            <h3>Address</h3>
            <ul class="address">
              <li class="location">
                <i class="bx bxs-location-plus"></i>
                {{ info.address }}
              </li>
              <li>
                <i class="bx bxs-envelope"></i>
                <a :href="'mailto:' + info.majorEmail">{{ info.majorEmail }}</a>
                <a :href="'mailto:' + info.majorEmail">{{ info.subEmail }}</a>
              </li>
              <li>
                <i class="bx bxs-phone-call"></i>
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
      <p>Copyright &copy; 2024.GreatZc All rights reserved.<a target="_blank" href=""></a></p>
    </div>
  </div>
</template>

<script>
import BiEnvelope from '~icons/bi/envelope';
import BiBuilding from '~icons/bi/building';
import BiTelephone from '~icons/bi/telephone';
import BiFaceBook from '~icons/bi/facebook'

export default {
  props: {
    info: Object
  },
  mounted() {
  },
  components: {
    BiEnvelope,
    BiBuilding,
    BiTelephone,
    BiFaceBook,
  }
}

</script>