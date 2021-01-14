<template>
  <div class="side_menu">
    <el-drawer
      title="工具栏"
      :visible.sync="showSide"
      direction="ltr"
      size="16%"
      :before-close="handleClose"
    >
      <div class="operate_group">
        <el-button type="primary" icon="el-icon-edit" circle @click="handleOperate('/md')" />
        <el-button type="primary" icon="el-icon-edit" circle />
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
    handleOperate: function(url) {
      this.$router.push(url);
      this.handleClose();
    },
  },
};
</script>

<style scoped>

</style>
