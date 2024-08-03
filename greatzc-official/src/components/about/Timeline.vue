<template>
  <div>
    <div class="row">
      <div class="col-lg-6 col-md-6 col-sm-6">
        <ul class="timeline">
          <div class="timeline-event">
            <label class="timeline-event-icon"></label>
            <div class="timeline-event-copy">
              <p class="timeline-event-thumbnail">April 2004</p>
              <h3>Organization Established</h3>
              <h4>Shenzhen Zechuang Weiye Technology Co.,Ltd</h4>
              <p><strong>Org Established</strong><br>The early organization of Shenzhen Zechuang Weiye Technology
                Co.,Ltd is established as the agent of selling a series of products such as computer sharing
                devices,thinclients,cloud terminals and mini PCs and so on.</p>
            </div>
          </div>
          <div class="timeline-event">
            <label class="timeline-event-icon"></label>
            <div class="timeline-event-copy">
              <p class="timeline-event-thumbnail">November 2006</p>
              <h3>Produce And Saleing</h3>
              <h4>Thinclients,cloud terminals,mini PCs</h4>
              <p>The early organization of Shenzhen Zechuang Weiye Technology Co.,Ltd is established as the agent of
                selling a series of products such as computer sharing devices,thinclients,cloud terminals and mini PCs
                and so on.</p>
            </div>
          </div>
          <div class="timeline-event">
            <label class="timeline-event-icon"></label>
            <div class="timeline-event-copy">
              <p class="timeline-event-thumbnail">April 2008</p>
              <h3>konplan gmbh</h3>
              <h4>IT-Consultant</h4>
              <p><strong>Systemarchitektur, Consulting</strong><br>Konzeption und Modellierung von Systemen und APIs
                für Digital Publishing und Entitlement nach SOA</p>
            </div>
          </div>
        </ul>
      </div>
      <div class="col-lg-6 col-md-6 col-sm-6">
        <ul class="timeline">
          <div class="timeline-event">
            <label class="timeline-event-icon"></label>
            <div class="timeline-event-copy">
              <p class="timeline-event-thumbnail">April 2004</p>
              <h3>Organization Established</h3>
              <h4>Shenzhen Zechuang Weiye Technology Co.,Ltd</h4>
              <p><strong>Org Established</strong><br>The early organization of Shenzhen Zechuang Weiye Technology
                Co.,Ltd is established as the agent of selling a series of products such as computer sharing
                devices,thinclients,cloud terminals and mini PCs and so on.</p>
            </div>
          </div>
          <div class="timeline-event">
            <label class="timeline-event-icon"></label>
            <div class="timeline-event-copy">
              <p class="timeline-event-thumbnail">November 2006</p>
              <h3>Produce And Saleing</h3>
              <h4>Thinclients,cloud terminals,mini PCs</h4>
              <p>The early organization of Shenzhen Zechuang Weiye Technology Co.,Ltd is established as the agent of
                selling a series of products such as computer sharing devices,thinclients,cloud terminals and mini PCs
                and so on.</p>
            </div>
          </div>
          <div class="timeline-event">
            <label class="timeline-event-icon"></label>
            <div class="timeline-event-copy">
              <p class="timeline-event-thumbnail">April 2011 - heute</p>
              <h3>konplan gmbh</h3>
              <h4>IT-Consultant</h4>
              <p><strong>Systemarchitektur, Consulting</strong><br>Konzeption und Modellierung von Systemen und APIs
                für Digital Publishing und Entitlement nach SOA</p>
            </div>
          </div>
        </ul>
      </div>
    </div>
  </div>
</template>

<style scoped>
/* Fonts */

body {
  font-family: 'Open Sans', 'Helvetica Neue', Helvetica, Arial, sans-serif;
  font-size: 1em;
  font-weight: 300;
  line-height: 1.5;
  letter-spacing: 0.05em;
}

/* Layout */
* {
  box-sizing: border-box;
}

/* Styling */
.timeline {
  margin: 4em auto;
  position: relative;
  max-width: 46em;

  &:before {
    background-color: 'black';
    content: '';
    margin-left: 0px;
    position: absolute;
    top: 0;
    left: 2em;
    width: 20px;
    height: 100%;
  }
}

.timeline-event {
  position: relative;

  &::before {
    content: '';
    font-size: 1.2em;
    position: absolute;
    top: 0;
    left: 31px;
    width: 2px;
    color: black;
    height: 100%;
    background-color: black;
  }

  &:hover {

    .timeline-event-icon {
      rotate: -45deg;
      background-color: #0383ff;
    }

    .timeline-event-thumbnail {
      box-shadow: inset 40em 0 0 0 #0383ff;
    }
  }
}

.timeline-event-copy {
  padding: 2em;
  position: relative;
  top: -1.875em;
  left: 2em;
  width: 80%;

  h3 {
    font-size: 1.75em;
  }

  h4 {
    font-size: 1.2em;
    margin-bottom: 1.2em;
  }

  strong {
    font-weight: 700;
  }

  p:not(.timeline-event-thumbnail) {
    padding-bottom: 1.2em;
  }
}

.timeline-event-icon {
  transition: transform 0.2s ease-in;
  transition: rotate 0.2s ease-in;
  rotate: 45deg;

  background-color: black;
  outline: 10px solid rgb(249, 250, 251);
  display: block;
  margin: 0.5em 0.5em 0.5em -0.5em;
  position: absolute;
  top: 0;
  left: 2em;
  width: 1em;
  height: 1em;
}

.timeline-event-thumbnail {
  transition: box-shadow 0.5s ease-in 0.1s;
  color: white;
  font-size: 0.75em;

  background-color: black;
  box-shadow: inset 0 0 0 0em #101349;
  display: inline-block;
  margin-bottom: 1.2em;
  padding: 0.25em 1em 0.2em 1em;
}
</style>

<script setup>
</script>