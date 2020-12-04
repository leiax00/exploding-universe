<template>
  <div id="blog_content">
    <uv-blog-detail v-if="showDetail" />
    <uv-blog-list v-else />
  </div>
</template>

<script>
import UvBlogDetail from '@/views/blog/modules/UvBlogDetail';
import UvBlogList from '@/views/blog/modules/UvBlogList';
import { mapState } from 'vuex';

export default {
  name: 'UvBlog',
  components: {
    UvBlogDetail,
    UvBlogList,
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

<style scoped>

</style>
