<template>
  <div class="uv-main">
    <div id="info_show">
      个人信息
    </div>
    <div id="main_show">
      <router-view />
    </div>
    <div id="other_show">
      其他信息
    </div>
  </div>
</template>
<script>
export default {
  name: 'AppMain',
};
</script>

<style lang="scss" scoped>
  @import "~@/styles/mixin.scss";
  @import "~@/styles/variables.scss";

  @mixin common_css {
    @include padding-2-common($horizontal: 1.25rem);
    @include margin-4-common($top: 0);
    background-color: $background-color-font;
  }

  .uv-main {
    @include container;

    & #info_show {
      @include common_css;
      width: 300px;
      min-height: 400px;

    }

    & #main_show {
      @include common_css;
      @include margin-4-common($top: 0);
      width: 100%;
      height: 400px;
    }

    & #other_show {
      @include common_css;
      width: 300px;
      height: 400px;
      justify-content: flex-end;
    }
  }
</style>
