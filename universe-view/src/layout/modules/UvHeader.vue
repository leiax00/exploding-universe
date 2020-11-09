<template>
  <div class="uv-header">
    <div class="uv-header-logo">logo</div>
    <div class="uv-header-nav">
      <template v-for="item of headers">
        <a :key="item.id" class="nav-item" :href="`/${item.id}`">{{ $t(item.name) }}</a>
      </template>
      <div />
    </div></div></template>

<script>
import setting from '@/prop/setting';

export default {
  name: 'UvHeader',
  data: function() {
    return {
      headers: setting.HEADER,
    };
  },
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
    box-sizing: inherit;
  }

  .nav-item {
    @include padding-horizontal;

    display: flex;
    /*align-items: center;*/
    cursor: pointer;
    flex-grow: 0;
  }
</style>
