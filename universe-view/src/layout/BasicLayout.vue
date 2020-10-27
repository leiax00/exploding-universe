<template>
  <a-layout id="components-layout-demo-custom-trigger">
    <a-layout-sider v-model="collapsed" :trigger="null" collapsible>
      <div class="logo" />
      <sider-menu />
    </a-layout-sider>
    <a-layout>
      <a-layout-header style="background: #fff; padding: 0">
        <a-icon
          class="trigger"
          :type="collapsed ? 'menu-unfold' : 'menu-fold'"
          @click="() => (collapsed = !collapsed)"
        />
        <uv-header />
      </a-layout-header>
      <a-layout-content
        :style="{ margin: '24px 16px', padding: '24px', background: '#fff', minHeight: '280px' }"
      >
        <router-view />
      </a-layout-content>
      <a-layout-footer style="text-align: center">
        <uv-footer />
      </a-layout-footer>
    </a-layout>
  </a-layout>
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
      collapsed: false,
    };
  },
};
</script>

<style>
  #components-layout-demo-custom-trigger .trigger {
    font-size: 18px;
    line-height: 64px;
    padding: 0 24px;
    cursor: pointer;
    transition: color 0.3s;
  }

  #components-layout-demo-custom-trigger .trigger:hover {
    color: #1890ff;
  }

  #components-layout-demo-custom-trigger .logo {
    height: 32px;
    background: rgba(255, 255, 255, 0.2);
    margin: 16px;
  }
</style>
