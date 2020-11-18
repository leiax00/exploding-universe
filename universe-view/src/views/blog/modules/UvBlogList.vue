<template>
  <div id="blog_list">
    <div>BLOG INTRODUCE</div>
    <template v-for="(item, index) in blogList">
      <uv-blog-item :key="item.id" :model.sync="blogList[index]" />
    </template>
  </div>

</template>

<script>
import UvBlogItem from '@/views/blog/modules/UvBlogItem';
export default {
  name: 'UvBlogIntro',
  components: {
    UvBlogItem,
  },
  data: function() {
    return {
      blogList: [
        {
          id: 1,
          title: 'Hello World',
          lastModify: 'xxxxxxx',
          count: 50,
          summary: 'hello world! i am a very good man...',
        },
        { id: 2 },
        { id: 3 },
        { id: 4 },
      ],
    };
  },
};
</script>

<style scoped>

</style>
