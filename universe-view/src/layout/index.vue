<template>
  <div id="layout">
    <section id="base_layout" class="app-wrapper">
      <div v-if="showSide" id="layout_sider">
        <side-menu />
      </div>
      <div id="layout_header" :class="{'header-night': isNight}">
        <uv-header />
      </div>
      <section id="layout_content" class="layout_content">
        <div id="layout_main" class="layout_main">
          <app-main />
        </div>
        <div id="layout_footer" class="layout_footer">
          <uv-footer />
        </div>
        <div id="little_cute" class="uv_little_cute">
          <little-cute />
        </div>
      </section>
    </section>
  </div>
</template>

<script>
import UvHeader from '@/layout/modules/UvHeader';
import UvFooter from '@/layout/modules/UvFooter';
import SideMenu from '@/layout/modules/SideMenu';
import AppMain from '@/layout/modules/AppMain';
import LittleCute from '@/components/littleCute';

export default {
  name: 'UvLayout',
  components: {
    AppMain,
    UvHeader,
    UvFooter,
    SideMenu,
    LittleCute,
  },
  data() {
    return {
      showSide: false,
      isNight: true,
    };
  },
};
</script>

<style lang="scss" scoped>
  @import "~@/styles/mixin.scss";
  @import "~@/styles/variables.scss";

  .app-wrapper {
      position: relative;
      height: 100%;
      width: 100%;

      &.mobile.openSidebar {
          position: fixed;
          top: 0;
      }
  }

  .header-night {
      background-color: $background-color-font;
  }

  .layout_content {
      padding: 1.25rem 0.75rem;
  }

  .layout_main {
      height: 800px;
  }

  .layout_footer {
      margin-top: 1.25rem;
  }

  .uv_little_cute {
      position: fixed;
      width: 250px;
      height: 300px;
      bottom: 0;
      z-index: 1;
      right: 0.75rem;
      transition: all 0.3s ease-in-out 0s;
  }
</style>
