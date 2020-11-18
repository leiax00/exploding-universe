<template>
  <div id="blog">
    <div class="blog_ctl" @click="showDetail = !showDetail">←</div>
    <div id="blog_content">
      <uv-blog-detail v-if="showDetail" />
      <uv-blog-list v-else />

    </div>
  </div>
</template>

<script>
import UvBlogDetail from '@/views/blog/modules/UvBlogDetail';
import UvBlogList from '@/views/blog/modules/UvBlogList';

export default {
  name: 'UvBlog',
  components: {
    UvBlogDetail,
    UvBlogList,
  },
  data: function() {
    return {
      showDetail: false,
    };
  },
};
</script>

<style scoped>

</style>
