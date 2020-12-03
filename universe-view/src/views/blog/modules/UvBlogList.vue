<template>
  <div id="blog-list">
    <div>BLOG INTRODUCE</div>
    <div id="blog-items">
      <template v-for="(item, index) in blogList">
        <uv-blog-item :key="item.id" :model.sync="blogList[index]" />
      </template>
    </div>
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
          lastModify: '2020-12-03 15:11:00',
          count: 50,
          summary: 'hello world! i am a very good man...',
        },
        {
          id: 2,
          title: 'Hello World2',
          lastModify: '2020-12-03 15:11:02',
          count: 50,
          summary: 'hello world! i am a very good man1111...',
        },
        {
          id: 3,
          title: 'Hello World3',
          lastModify: '2020-12-03 15:11:03',
          count: 50,
          summary: 'hello world! i am a very good man3333...',
        },
      ],
    };
  },
};
</script>

<style scoped>

</style>
