<template>
  <el-container class="app-wrapper">
    <!--    <el-aside class="sidebar-container">-->
    <!--      <sider-menu />-->
    <!--    </el-aside>-->
    <el-container class="main-container">
      <el-header>
        <uv-header />
      </el-header>
      <el-main>
        <app-main />
      </el-main>
      <el-footer>
        <uv-footer />
      </el-footer>
    </el-container>
  </el-container>
</template>

<script>
import UvHeader from '@/layout/UvHeader';
import UvFooter from '@/layout/UvFooter';
// import SiderMenu from '@/layout/SiderMenu';
import AppMain from '@/layout/AppMain';

export default {
  name: 'Layout',
  components: {
    AppMain,
    UvHeader,
    UvFooter,
    // SiderMenu,
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

  .drawer-bg {
    background: #000;
    opacity: 0.3;
    width: 100%;
    top: 0;
    height: 100%;
    position: absolute;
    z-index: 999;
  }

  .fixed-header {
    position: fixed;
    top: 0;
    right: 0;
    z-index: 9;
    width: calc(100% - #{$sideBarWidth});
    transition: width 0.28s;
  }

  .hideSidebar .fixed-header {
    width: calc(100% - 54px)
  }

  .mobile .fixed-header {
    width: 100%;
  }
</style>
