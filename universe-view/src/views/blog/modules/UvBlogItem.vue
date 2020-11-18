<template>
  <div>{{ JSON.stringify(model) }}</div>
</template>

<script>
export default {
  name: 'UvBlogItem',
  props: {
    model: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style scoped>

</style>
