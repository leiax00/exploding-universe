<template>
  <el-container class="app-wrapper">
    <el-aside v-if="showSide">
      <side-menu />
    </el-aside>
    <el-container>
      <el-header :class="{'header-night': isNight}">
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
import UvHeader from '@/layout/modules/UvHeader';
import UvFooter from '@/layout/modules/UvFooter';
import SideMenu from '@/layout/modules/SideMenu';
import AppMain from '@/layout/modules/AppMain';

export default {
  name: 'UvLayout',
  components: {
    AppMain,
    UvHeader,
    UvFooter,
    SideMenu,
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
    background-color: $background-color-header;
  }
</style>
