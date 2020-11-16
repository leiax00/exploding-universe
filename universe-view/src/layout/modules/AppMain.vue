<template>
  <div class="uv-main">
    <div>App Main</div>
    <a>aaaaaaaaaaaaaaaaa</a>
    <router-view />
  </div>
</template>
<script>
export default {
  name: 'AppMain',
};
</script>

<style lang="scss" scoped>
  @import "~@/styles/mixin.scss";

  .uv-main {
    @include container;
  }
</style>
