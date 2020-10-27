<template>
  <el-container>
    <el-aside width="200px">
      <sider-menu/>
    </el-aside>
    <el-container>
      <el-header>
        <uv-header/>
      </el-header>
      <el-main>
        <router-view/>
      </el-main>
      <el-footer>
        <uv-footer/>
      </el-footer>
    </el-container>
  </el-container>
</template>

<script>
import UvHeader from '@/layout/UvHeader';
import UvFooter from '@/layout/UvFooter';
import SiderMenu from '@/layout/SiderMenu';

export default {
  name: 'Layout',
  components: {
    UvHeader,
    UvFooter,
    SiderMenu,
  },
};
</script>

<style scoped>

</style>
