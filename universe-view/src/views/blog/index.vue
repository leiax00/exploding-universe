<template>
  <div class="blog_content">
    <div class="info_show">
      <user-card />
    </div>
    <div class="main_show">
      <transition name="el-zoom-in-center">
        <uv-blog-detail v-if="showDetail" />
        <uv-blog-list v-else />
      </transition>
    </div>
    <div class="other_show">
      其他信息
    </div>
  </div>
</template>

<script>
import UvBlogDetail from '@/views/blog/modules/UvBlogDetail';
import UvBlogList from '@/views/blog/modules/UvBlogList';
import UserCard from '@/views/userCard';
import { mapState } from 'vuex';

export default {
  name: 'UvBlog',
  components: {
    UvBlogDetail,
    UvBlogList,
    UserCard,
  },
  data: function() {
    return {};
  },
  computed: {
    ...mapState('blog', [
      'showDetail',
    ]),
  },
};
</script>

<style lang="scss" scoped>
  @import "~@/styles/mixin.scss";
  @import "~@/styles/variables.scss";

  @mixin common_css {
    @include margin-4-common($top: 0);
    background-color: $background-color-font;
  }

  .blog_content {
    @include container;
    align-items: flex-start;

    & .info_show {
      @include common_css;
      width: 450px;
      min-height: 400px;
    }

    & .main_show {
      @include common_css;
      @include margin-4-common($top: 0);
      width: 100%;
      min-height: 400px;
    }

    & .other_show {
      @include common_css;
      width: 300px;
      min-height: 400px;
      justify-content: flex-end;
    }
  }
</style>
