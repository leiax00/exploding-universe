<template>
  <div class="uv-header">
    <div class="uv-header-logo">logo</div>
    <div class="uv-header-nav">nav bar</div>
  </div>
</template>

<script>
export default {
  name: 'UvHeader',
};
</script>

<style lang="scss" scoped>
  @import "~@/styles/mixin.scss";
  .uv-header {
    @include container;
    min-height: 3.25rem;
    height: 100%;

  }

  .uv-header-logo {
    @include padding-horizontal;
  }

  .uv-header-nav {
    @include padding-horizontal;
  }
</style>
