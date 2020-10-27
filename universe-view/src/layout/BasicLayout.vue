<template>
  <div>
    <uv-header/>
    <sider-menu/>
    <router-view/>
    <uv-footer/>
  </div>
</template>

<script>
import UvHeader from '@/layout/UvHeader';
import UvFooter from '@/layout/UvFooter';
import SiderMenu from '@/layout/SiderMenu';

export default {
  name: 'BasicLayout',
  components: {
    UvHeader,
    UvFooter,
    SiderMenu,
  },
  data() {
    return {
      collapsed: true,
    };
  },
};
</script>

<style>
</style>
