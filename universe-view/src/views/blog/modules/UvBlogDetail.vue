<template>
  <div id="blog-detail">
    <div class="blog_ctl" @click="showBlogList">←</div>
    <h1> {{ blogDetail.title }} </h1>
    <div> {{ blogDetail.summary }} </div>
  </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';

export default {
  name: 'UvBlogDetail',
  computed: {
    ...mapState('blog', [
      'blogDetail',
    ]),
  },
  methods: {
    ...mapActions('blog', [
      'showBlogList',
    ]),
  },
};
</script>

<style scoped>

</style>
