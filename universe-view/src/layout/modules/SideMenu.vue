<template>
  <div class="side_menu">
    <el-drawer
      title="工具栏"
      :visible.sync="showSide"
      direction="ltr"
      size="300px"
      :before-close="handleClose"
    >
      <div class="operate_group">
        <el-button class="nav-md-edit" icon="el-icon-edit" circle @click="handleOperate({name:'md-editor', params: {to: 'home'}})" />
        <el-button icon="el-icon-edit" circle />
        <el-button icon="el-icon-edit" circle />
        <el-button icon="el-icon-edit" circle />
        <el-button icon="el-icon-edit" circle />
        <el-button icon="el-icon-edit" circle />
        <el-button icon="el-icon-edit" circle />
        <el-button icon="el-icon-edit" circle />
        <el-button icon="el-icon-edit" circle />
        <el-button icon="el-icon-edit" circle />
        <el-button icon="el-icon-edit" circle />
        <el-button icon="el-icon-edit" circle />
        <el-button icon="el-icon-edit" circle />
      </div>
    </el-drawer>
  </div>
</template>

<script>
import moment from 'moment';

export default {
  name: 'SideMenu',
  props: {
  },
  data: function() {
    return {
      hotKey: {
        dstKey: 'Alt1',
        srcKey: '',
        prevPressTime: '',
        step: 1000,
      },
    };
  },
  computed: {
    showSide: function() {
      return this.$store.getters.showSide;
    },
  },
  mounted() {
    const that = this;
    document.onkeydown = function(e) {
      console.log(e.key);
      const curTime = moment().valueOf();
      if (curTime - that.hotKey.prevPressTime > that.hotKey.step) {
        that.hotKey.prevPressTime = curTime;
        that.hotKey.srcKey = e.key;
        return;
      }
      that.hotKey.srcKey += e.key;
      if (that.hotKey.srcKey === that.hotKey.dstKey) {
        that.$store.commit('ui_ctl/SET_SIDE_SHOW', true);
      }
    };
  },
  methods: {
    handleClose: function() {
      this.$store.commit('ui_ctl/SET_SIDE_SHOW', false);
    },
    handleOperate: function(route) {
      this.$router.push(route);
      this.handleClose();
    },
  },
};
</script>

<style lang="scss" scoped>
  @import "~@/styles/variables.scss";
  @import "~@/styles/mixin.scss";
  ::v-deep .el-drawer {
    background-color: $background-color-font;
  }
  .operate_group {
    @include margin-2-common(0, 1rem);
    ::v-deep & button {
      @include margin-2-common($horizontal:0.5rem);
      font-size: 24px;
    }

    /*::v-deep & button:nth-child(4n + 1) {*/
    /*  margin-left: 0 !important;*/
    /*}*/

    .nav-md-edit {
      color: #ff6589;
      background-color: #d4c8ff;
    }
  }

  ::v-deep .el-drawer__header span:focus, ::v-deep .el-drawer:focus {
    outline: 0;
  }
</style>
