<template>
  <div class="uv-main">
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
