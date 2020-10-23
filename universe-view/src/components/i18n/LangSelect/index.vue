<template>
  <el-dropdown trigger="click" class="international" @command="handleSetLanguage">
    <!--<el-tooltip class="item" effect="dark" content="select language" placement="left-start">-->
    <!--不能包裹el-tooltip,会报错-->
    <div>
      <!-- 语言选择图标 -->
      <svg-icon class-name="international-icon" icon-class="language" />
    </div>
    <!--</el-tooltip>-->
    <el-dropdown-menu slot="dropdown">
      <el-dropdown-item command="zh" :disabled="language==='zh'">中文</el-dropdown-item>
      <el-dropdown-item command="en" :disabled="language==='en'">English</el-dropdown-item>
    </el-dropdown-menu>
  </el-dropdown>
</template>

<script>
import SvgIcon from '@/components/SvgIcon';
export default {
  name: 'LangSelect',
  components: { SvgIcon },
  computed: {
    language() {
      return this.$store.getters.language;
    },
  },
  methods: {
    handleSetLanguage(lang) {
      // 选择语言
      this.$i18n.locale = lang;
      // 保存vuex
      this.$store.dispatch('setLanguage', lang);
      this.$message({
        message: 'switch language success',
        type: 'success',
      });
      // 触发重新加载事件
      this.$emit('handerevent');
    },
  },
};
</script>

<style scoped>
    .international-icon {
        font-size: 22px;
        cursor: pointer;
        vertical-align: -5px!important;
        color:#fff;
    }
    .el-dropdown{
        color:#5a5e66;
    }
</style>
