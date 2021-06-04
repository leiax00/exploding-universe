<template>
  <div class="uv-footer">
    <div class="uv-footer-logo">
      <a href="/"><img src="@/assets/imgs/simple_zero.png" alt="Simple Zero" height="28"></a>
    </div>
    <div id="footer-content">
      <div id="uv-copyright">
        <div>
          <uv-icon icon-class="copyright" />
          <span class="footer-text">{{ `${new Date().getFullYear()} ${copyright}` }}</span>
        </div>
        <div>
          <uv-icon icon-class="copyright" />
          <span class="footer-text">{{ self_copyright }}</span>
        </div>
      </div>
      <div id="uv-web-info">
        <div v-if="run_info !== ''">
          <uv-icon icon-class="aixin-left" />
          <span class="footer-text">{{ run_info }}</span>
          <uv-icon icon-class="aixin-right" />
        </div>
        <div>
          <uv-icon icon-class="aixin-left" />
          <span class="footer-text">{{ thanks }}</span>
          <uv-icon icon-class="aixin-right" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import setting from '@/settings';
import bus from '@/prop/util';

export default {
  name: 'UvFooter',
  data: function() {
    return {
      copyright: 'Lei.AoX Powered by JcTec',
      self_copyright: '版权说明：[本网站所有内容均收集于互联网或自己创作,方便于网友与自己学习交流，如有侵权，请留言，立即处理]',
      run_info: '',
      thanks: '感谢小伙伴的光临!',
    };
  },
  created() {
    this.refreshRunInfo();
  },
  methods: {
    refreshRunInfo: function() {
      const self = this;
      bus.setInterval(function target() {
        const diff = bus.calcTimeDiff(setting.first_run);
        self.run_info = `本站自 ${setting.first_run.split(/[\vt]/ig)[0]} 已运行 ${diff.day} 天 ${diff.hour}  小时 ${diff.minute}  分 ${diff.second}  秒!`;
      }, bus.timeConst.ONE_SECOND);
    },
  },
};
</script>
<style lang="scss" scoped>
  @import "~@/styles/mixin.scss";

  .uv-footer {
    @include container;
    display: block;
    font-size: 12px;
  }

  .uv-footer-logo {
    width: 120px;
    & a {
      display: flex;
      align-items: center;
      height: 1.75rem;
    }
  }

  .footer-text {
    @include margin-2-common(0, 0.25rem);
  }

</style>
