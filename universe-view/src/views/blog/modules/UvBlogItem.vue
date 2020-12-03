<template>
  <div id="blog-item">
    <!--    <div>{{ JSON.stringify(model) }}</div>-->
    <h4>{{ model.title }}</h4>
    <div class="blog-summary">
      {{ model.summary }}
    </div>
    <div class="blog-footer">
      <div>{{ model.lastModify }}</div>
      <div>
        <uv-icon icon-class="eye" class-name="uv-separator" />
        <span>{{ model.count }}</span>
      </div>
    </div>
  </div>
</template>

<script>
import UvIcon from '@/components/icon/index';

export default {
  name: 'UvBlogItem',
  components: { UvIcon },
  props: {
    model: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style lang="scss" scoped>
  @import "~@/styles/mixin.scss";
  @import "~@/styles/variables.scss";
  #blog-item {
    @include padding-2-common($vertical: 0);
    &:not(:first-child) {
      padding-top: 1rem;
    }

    &:not(:last-child) {
      padding-bottom: 0.75rem;
      border-bottom: #7b8c9d solid 1px;
    }
    &:hover {
      background-color: lighten($background-color-font, 2);
      & h4 {
        color: #ff727e;
      }
    }
  }

  h4 {
    margin: 0;
    padding: 0;
    cursor: pointer;
  }

  .blog-summary {
    margin-bottom: 0.25rem;
  }

  .blog-footer {
    display: flex;
    justify-content: flex-start;
    align-items: center;
    & div {
      &:not(:first-child) {
        margin-left: 0.5rem;
      }
      &:not(:last-child) {
        margin-right: 0.5rem;
      }
    }
  }
  .uv-separator {
    margin-right: 0.25rem;
  }
</style>
