<template>
  <div id="user_card">
    <div id="avatar" class="level">
      <figure class="image size-128x128">
        <img class="is-rounded" src="@/assets/imgs/avatar.png">
      </figure>
      <p class="title is-middle compact">LEIAX00</p>
      <p class="preface is-middle compact">初心永不泯，剑指九重天</p>
      <p class="is-middle compact">
        <uv-icon icon-class="location" />
        <span>中国</span>
      </p>
    </div>
    <div id="stat_view" class="level">
      <template v-for="item of viewInfos">
        <div :key="item.name" class="view-item is-middle item-hover-background">
          <div class="">
            <p class="heading">{{ item.name }}</p>
            <a href="">
              <p class="title compact">{{ item.count }}</p>
            </a>
          </div>
        </div>
      </template>
    </div>
    <div class="level">
      <a
        class="view-item uv-button is-primary is-rounded"
        href="https://github.com/leiax00"
        target="_blank"
        rel="noopener"
      >
        <span>关注我</span>
      </a>
    </div>
    <div id="user_link" class="level is-flex">
      <template v-for="item of userLinks">
        <a
          :key="item.title"
          class="view-item uv-button is-flex is-middle no-background-color"
          target="_blank"
          rel="noopener"
          :title="item.title"
          :href="item.href"
        >
          <uv-icon :icon-class="item.icon" />
        </a>
      </template>
    </div>
    <hr class="compact">
    <div id="roll_motto" class="is-middle compact" @click="captureMotto">
      <strong>{{ motto.text }}</strong>
      <p>{{ `来源 《${motto.from}》` }}</p>
      <p>{{ `提供者-${motto.author}` }}</p>
    </div>
  </div>
</template>

<script>

import bus from '@/prop/util';

export default {
  name: 'UserCard',
  data: function() {
    // todo: mock数据需要更改为接口
    return {
      viewInfos: [{ name: '文章', count: 1 }, { name: '分类', count: 1 }, { name: '标签', count: 1 }],
      userLinks: [
        { title: 'GO TO GITHUB1', href: 'https://github.com/leiax00', icon: 'github' },
        { title: 'GO TO GITHUB2', href: 'https://github.com/leiax00', icon: 'github' },
        { title: 'GO TO GITHUB3', href: 'https://github.com/leiax00', icon: 'github' },
        { title: 'GO TO GITHUB4', href: 'https://github.com/leiax00', icon: 'github' },
        { title: 'GO TO GITHUB5', href: 'https://github.com/leiax00', icon: 'github' },
      ],
      motto: {},
    };
  },
  created() {
    bus.setInterval(this.captureMotto, 5 * bus.timeConst.ONE_MINUTE);
  },
  methods: {
    captureMotto: function() {
      this.$store.dispatch('third_api/captureMotto').then(resp => { this.motto = resp; });
    },
  },
};
</script>

<style lang="scss" scoped>
  @import "~@/styles/mixin.scss";
  @import "~@/styles/variables.scss";

  .level {
    align-items: center;
    justify-content: space-between;

    &:not(:last-child) {
      margin-bottom: 0.5rem;
    }
  }

  .image img {
    height: auto;
    width: 100%;
    filter: brightness(0.6);
  }

  #stat_view {
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

  .view-item {
    display: flex;
    flex-grow: 1;
    flex-basis: auto;
    flex-shrink: 0;

    &.item-hover-background:hover {
      background-color: lighten($background-color-font, 5);
      color: $hover-color;
    }
  }

  .heading {
    padding: 0;
    font-size: 11px;
    letter-spacing: 1px;
    margin: 0 0 5px;
    text-transform: uppercase;
  }

  #roll_motto {
    padding: 1rem;
    cursor: pointer;
    & p{
      @include compact;
    }
    & strong {
      color: $light-blue;
    }
  }
</style>
