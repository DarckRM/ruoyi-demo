<template>
  <section class="main-contact-area ptb-100">
    <div class="container">
      <div class="section-title">
        <h2 style="color: #0383ff;">Drop Us A Message For Any Query</h2>
      </div>

      <BOverlay :show="sending">
        <div id="contactForm">
          <div class="row">
            <div class="col-lg-6 col-sm-6">
              <div class="form-group">
                <input type="text" name="name" id="name" class="form-control" required
                  data-error="Please enter your name" placeholder="Your Name" v-model="message.nickname">
                <div class="help-block with-errors"></div>
              </div>
            </div>

            <div class="col-lg-6 col-sm-6">
              <div class="form-group">
                <input type="email" name="email" id="email" class="form-control" required
                  data-error="Please enter your email" placeholder="Your Email" v-model="message.email">
                <div class="help-block with-errors"></div>
              </div>
            </div>

            <div class="col-lg-6 col-sm-6">
              <div class="form-group">
                <input type="text" name="phone_number" id="phone_number" required data-error="Please enter your number"
                  class="form-control" placeholder="Your Phone" v-model="message.phone">
                <div class="help-block with-errors"></div>
              </div>
            </div>

            <div class="col-lg-6 col-sm-6">
              <div class="form-group">
                <input type="text" name="msg_subject" id="msg_subject" class="form-control" required
                  data-error="Please enter your subject" placeholder="Your Subject" v-model="message.subject">
                <div class="help-block with-errors"></div>
              </div>
            </div>

            <div class="col-lg-12 col-md-12">
              <div class="form-group">
                <textarea name="message" class="form-control" id="message" cols="30" rows="10" required
                  data-error="Write your message" placeholder="Your Message" v-model="message.content"></textarea>
                <div class="help-block with-errors"></div>
              </div>
            </div>

            <div class="col-12">
              <div class="form-group checkboxs">
                <input type="checkbox" id="chb2">
                <p>
                  Accept <a href="terms-conditions.html">Terms & Conditions</a> And <a
                    href="privacy-policy.html">Privacy
                    Policy.</a>
                </p>
              </div>
            </div>

            <div class="col-12">
              <BButton :disabled="sended" @click="sendMessage" class="default-btn btn-two">
                <span>Send Message</span>
              </BButton>
              <div id="msgSubmit" class="h3 text-center hidden"></div>
              <div class="clearfix"></div>
            </div>
          </div>
        </div>
      </BOverlay>
    </div>
  </section>

  <BModal v-model="show" centered :title="noticeTitle">
    {{ notice }}
  </BModal>
</template>

<script>
import { addMessage } from '@/api/message';
import { BOverlay, BButton, BModal } from 'bootstrap-vue-next';
import { sleep } from '@/utils/tools';

export default {
  data() {
    return {
      message: {
        nickname: '',
        subject: '',
        phone: '',
        email: '',
        content: ''
      },
      sending: false,
      sended: false,
      show: false,
      noticeTitle: 'Success',
      notice: 'Thanks for your submit!'
    }
  },
  methods: {
    sendMessage() {
      this.sending = true
      sleep(2000).then(() => {
        addMessage(this.message).then((res) => {
          if (res.code != 200) {
            this.noticeTitle = 'Failed to submit!'
            this.notice = 'Please try again later.'
          }

          this.sended = true
          this.sending = false
          this.show = true
        })
      })

    }
  }
}
</script>