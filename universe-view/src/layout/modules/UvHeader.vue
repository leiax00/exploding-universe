<template>
  <div class="uv-header">
    <div class="uv-header-logo">
      <a class="nav-item" href="/"><img src="@/assets/imgs/simple_zero.png" alt="Simple Zero" height="28"></a>
    </div>
    <div class="uv-header-nav">
      <template v-for="item of headers">
        <a :key="item.id" class="nav-item" :href="`/${item.id}`">{{ $t(item.name) }}</a>
      </template>
      <div />
    </div>
    <div class="uv-header-func">
      <a
        class="nav-item"
        target="_blank"
        rel="noopener"
        title="Go To GitHub"
        href="https://github.com/leiax00"
      >
        <uv-icon icon-class="github" />
      </a>
      <a class="nav-item" title="search"><uv-icon icon-class="search" /></a>
    </div>
  </div>
</template>

<script>
import setting from '@/prop/setting';
import UvIcon from '@/components/icon';

export default {
  name: 'UvHeader',
  components: { UvIcon },
  data: function() {
    return {
      headers: setting.HEADER,
    };
  },
  mounted() {

  },
};
</script>

<style lang="scss" scoped>
  @import "~@/styles/mixin.scss";

  .uv-header {
    @include container;
    & .nav-item {
      @include padding-header;
      display: flex;
      align-items: center;
    }
  }

  .uv-header-logo {
  }

  .uv-header-nav {
    display: flex;
    flex-grow: 0;
  }

  .uv-header-func{
    display: flex;
    flex-grow: 0;
    justify-content: flex-end;
    margin-left: auto;
  }
</style>
