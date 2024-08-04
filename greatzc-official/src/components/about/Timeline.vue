<template>
  <div>
    <div class="row">
      <div v-for="column in timeLineData" class="col-lg-4 col-md-6 col-sm-6">
        <ul v-for="item in column" class="timeline">
          <div class="timeline-event">
            <label class="timeline-event-icon"></label>
            <div class="timeline-event-copy">
              <p class="timeline-event-thumbnail">{{ item.datetime }}</p>
              <h3>{{ item.title }}</h3>
              <h4>{{ item.subTitle }}</h4>
              <p>{{ item.content }}</p>
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
  padding-left: 1.5em;
  padding-top: 1em;
  padding-bottom: 0em;
  position: relative;
  top: -0.875em;
  left: 2em;
  width: 100%;

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

const timeLineDataOne = [
  {
    datetime: 'April 2004',
    title: 'Organization Establishe',
    subTitle: 'Shenzhen Zechuang Weiye Technology Co.,Lt',
    content: 'The early organization of Shenzhen Zechuang Weiye Technology Co., Ltd is established as the agent of selling a series of products such as computer sharing devices, thinclients, cloud terminals and mini PCs and so on'
  },
  {
    datetime: 'November 2006',
    title: 'Produce And Saleing',
    subTitle: 'Thinclients,cloud terminals,mini PCs',
    content: 'The early organization of Shenzhen Zechuang Weiye Technology Co.,Ltd is established as the agent of selling a series of products such as computer sharing devices,thinclients,cloud terminals and mini PCs and so on.<'
  },
  {
    datetime: 'July 2008',
    title: 'New Products',
    subTitle: 'IT-Consultant',
    content: 'The early organization of Shenzhen Zechuang Weiye Technology Co.,Ltd added some new products such as mini computers and computer terminals to its production lines and sale channels.With its exlusive characteristics, Mini computer-ZC-H520 totally embodys the integral capacibilities of Shenzhen Zechuang Weiye Technology Co.,Ltd.'
  },
  {
    datetime: 'February 2011',
    title: 'Registered Company',
    subTitle: 'Shenzhen Zechuang Weiye Technology Co.,Lt',
    content: 'Shenzhen Zechuang Weiye Technology Co.,Ltd,as a registered company,shared the market of industrial computers in public by producing and selling industrial computers and set up the department of foreign trading.Therefore, it placed high weight in enlarging the production line of industrial computers with high quality such as ZC-1037-6C and ZC-T4200DL.'
  },
]

const timeLineDataTwo = [
  {
    datetime: 'April 2013',
    title: 'Custom Designed Device',
    subTitle: 'Customize Industrail Computers',
    content: 'Shenzhen Zechuang Weiye Technology Co.,Ltd organized a group of research and development engineers who design and customize industrial computers and industrial motherboards for clients. With help of huge input- manpower, material resource and financial resource, the engineers developed a series of advanced mini industrial computers.'
  },
  {
    datetime: 'March 2015',
    title: 'Celeron J1900 ITX',
    subTitle: 'New Products',
    content: 'Shenzhen Zechuang Weiye Technology Co.,Ltd developed series of advanced mini itx motherboard onboard low power cpu like celeron j1900'
  },
  {
    datetime: 'May 2017',
    title: 'Single Board Computer',
    subTitle: 'Series of 3.5',
    content: 'Shenzhen Zechuang Weiye Technology Co.,Ltd developed series of 3.5 single board computer for industrial use.'
  },
  {
    datetime: 'August 2019',
    title: 'OPS PC With Graphic Card',
    subTitle: 'Nivida Graphics',
    content: 'Shenzhen Zechuang Weiye Technology Co.,Ltd developed series of OPS Computer with Nivida Graphics.'
  },
  {
    datetime: 'January 2020',
    title: 'New Generation OPS PC',
    subTitle: '8th Gen And 10th Gen',
    content: 'Shenzhen Zechuang Weiye Technology Co.,Ltd developed series of OPS Computer onboard 8th gen and 10th gen OPS PC.'
  },
]

const timeLineDataThree = [
  {
    datetime: 'September 2021',
    title: 'New Mini ITX Motherboard',
    subTitle: 'Gemini Lake And Comet Lake',
    content: 'Shenzhen Zechuang Weiye Technology Co.,Ltd developed series of industrial grade mini itx motherboard onboard Gemini Lake and 10th gen Comet Lake like i5-10210u.'
  },
  {
    datetime: 'December 2022',
    title: 'Industrial PC',
    subTitle: 'Core I3 I5 I7',
    content: 'Shenzhen Zechuang Weiye Technology Co.,Ltd developed series of industrial grade mini itx motherboard onboard 11th gen Core i3 i5 i7.'
  },
  {
    datetime: 'October 2023',
    title: 'Onboard 12th PC',
    subTitle: '11th Gen Core',
    content: 'Shenzhen Zechuang Weiye Technology Co.,Ltd developed series of mini itx motherboard onboard 12th gen Core i3 i5 i7;OPS PC which support 10th/11th Gen Core i3 i5 i7 CPU.'
  },
]

const timeLineData = [
  timeLineDataOne,
  timeLineDataTwo,
  timeLineDataThree
]

</script>