<template>
  <div class="top-header">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-lg-8 col-md-10">
          <ul class="header-left-content">
            <li>
              <i class="bx">
                <BiHouse></BiHouse>
              </i>
              Home
            </li>
            <li>
              <i class="bx">
                <BiTelephone></BiTelephone>
              </i>
              <a href="">{{ info.tel }}</a>
            </li>
            <li>
              <i class="bx">
                <BiEnvelopeAt></BiEnvelopeAt>
              </i>
              <a href="mailto:hello@greatzc.com">{{ info.majorEmail }}</a>
            </li>
          </ul>
        </div>

        <div class="col-lg-4 col-md-2">
          <div class="header-right-content">
            <ul class="flag-area">
              <li class="flag-item-top">
                <a href="#" class="flag-bar">
                  <img src="/assets/img/flag/usa.png" alt="Image">
                  <span>USA</span>
                </a>

                <ul class="flag-item-bottom">
                  <li class="flag-item">
                    <a href="#" class="flag-link">
                      <img src="/assets/img/flag/canada.png" alt="Image">
                      Canada
                    </a>
                  </li>
                  <li class="flag-item">
                    <a href="#" class="flag-link">
                      <img src="/assets/img/flag/australia.png" alt="Image">
                      Australia
                    </a>
                  </li>
                  <li class="flag-item">
                    <a href="#" class="flag-link">
                      <img src="/assets/img/flag/germany.png" alt="Image">
                      Germany
                    </a>
                  </li>
                  <li class="flag-item">
                    <a href="#" class="flag-link">
                      <img src="/assets/img/flag/argentina.png" alt="Image">
                      Argentina
                    </a>
                  </li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import BiHouse from '~icons/bi/house';
import BiTelephone from '~icons/bi/telephone';
import BiEnvelopeAt from '~icons/bi/envelope-at';

export default {
  components: {
    BiHouse,
    BiEnvelopeAt,
    BiTelephone
  },
  props: {
    info: {}
  },
  data() {
    return {
      languages: []
    }
  }
}
</script>