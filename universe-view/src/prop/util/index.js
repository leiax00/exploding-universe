import moment from 'moment';
import Vue from 'vue';

const bus = new Vue();

export default bus;

bus.timeConst = {
  ONE_SECOND: 1000,
  ONE_MINUTE: 60 * 1000,
  ONE_HOUR: 60 * 60 * 1000,
  ONE_DAY: 60 * 60 * 24 * 1000,
};

bus.parseTime = function(times, pattern = 'YYYY-MM-DDTHH:mm:ss') {
  if (times === 0) {
    return '';
  }
  if (pattern) {
    return moment(times).format(pattern).toLocaleString();
  }
  return moment(times).format('YYYY-MM-DDTHH:mm:ss').toLocaleString();
};

bus.calcTimeDiff = function(startT, endT = new Date()) {
  let diff = moment(endT).diff(moment(startT), 'seconds') * this.timeConst.ONE_SECOND;
  const day = Math.floor(diff / this.timeConst.ONE_DAY);
  diff = diff - day * this.timeConst.ONE_DAY;
  const hour = Math.floor(diff / this.timeConst.ONE_HOUR);
  diff = diff - hour * this.timeConst.ONE_HOUR;
  const minute = Math.floor(diff / this.timeConst.ONE_MINUTE);
  diff = diff - minute * this.timeConst.ONE_MINUTE;
  const second = Math.floor(diff / this.timeConst.ONE_SECOND);
  return {
    day: day,
    hour: hour,
    minute: minute,
    second: second,
  };
};

bus.setInterval = function(func, timeRound) {
  func();
  return setInterval(func, timeRound);
};

bus.clearInterval = function(timer) {
  if (timer) {
    clearInterval(timer);
  }
};
