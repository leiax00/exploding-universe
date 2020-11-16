<template>
  <div id="user_card">
    <div id="avatar">
      <figure class="image size-128x128">
        <img class="is-rounded" src="@/assets/imgs/avatar.png">
      </figure>
      <p class="title is-middle compact">HERO</p>
      <p class="preface compact">我的光辉时刻即是开大招的时候</p>
      <p class="is-middle compact">
        <uv-icon icon-class="location" />
        <span>中国</span>
      </p>
    </div>
  </div>
</template>

<script>
import UvIcon from '@/components/icon';
export default {
  name: 'UserCard',
  components: {
    UvIcon,
  },
};
</script>

<style lang="scss" scoped>
  .image img {
    height: auto;
    width: 100%;
    filter: brightness(0.6);
  }
</style>
