<template>
  <div class="md-edit-main">
    <div class="md-edit-title">
      <div class="md-edit-return">
        <el-button type="text" icon="el-icon-arrow-left" @click="returnPrev">返回博客</el-button>
      </div>
      <div class="md-edit-title-input">
        <el-input v-model="page.title" placeholder="请输入标题" />
      </div>
      <div class="md-edit-operate">
        <el-button-group>
          <el-button type="primary" icon="el-icon-folder-opened">保存草稿</el-button>
          <el-button type="primary">发布文章<i class="el-icon-reading el-icon--right" /></el-button>
        </el-button-group>
      </div>
    </div>
    <div class="md-edit-content">
      <mavon-editor v-model="page.content" style="height: 100%" />
    </div>
  </div>
</template>

<script>

import { mavonEditor } from 'mavon-editor';
import 'mavon-editor/dist/css/index.css';
export default {
  name: 'MdEdit',
  components: { mavonEditor },
  props: {
  },
  data: function() {
    return {
      page: {
        title: '',
        content: '',
      },
    };
  },
  methods: {
    returnPrev: function() {
      this.$router.push({ name: this.$route.params.to || 'home' });
    },
  },
};
</script>

<style lang="scss" scoped>
  @import "~@/styles/mixin.scss";
  .md-edit-main {
    margin: auto;
    width: 100%;
  }
  .md-edit-content {
    height: 580px;
  }
  .md-edit-title {
    display: flex;
    background-color: #bbb;
    border-top-left-radius: 4px;
    border-top-right-radius: 4px;
    @include padding-2-common(0.5rem, 0);
    & div {
      @include margin-2-common(0, 0.5rem)
    }
  }

  .md-edit-title-input {
    flex: 2;
    ::v-deep & .el-input__inner{
      border-radius: 16px;
      /*width: 1000px;*/
    }
  }

  .md-edit-content .markdown-body {
    border-top-left-radius: 0;
    border-top-right-radius: 0;
  }
</style>
