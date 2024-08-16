<template>
  <div class="top-header">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-lg-12 col-md-12">
          <ul class="header-left-content">
            <li>
              <i class="bx bx-phone-call">
              </i>
              <a href="">{{ info.tel }}</a>
            </li>
            <li>
              <i class="bx bx-envelope">
              </i>
              <a href="mailto:hello@greatzc.com">{{ info.majorEmail }}</a>
            </li>
            <li>
              Supplier of Embedded IPCs, Embedded Motherboards, OPS PCs, Firewall Products
            </li>

          </ul>
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