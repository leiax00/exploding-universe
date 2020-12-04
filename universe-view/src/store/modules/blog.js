const state = {
  showDetail: false,
  blogDetail: {},
};

const mutations = {
  CHANGE_BLOG_DETAIL_SHOW: (state) => {
    state.showDetail = !state.showDetail;
  },
  SET_BLOG_DETAIL: (state, blogDetail) => {
    state.blogDetail = blogDetail;
  },
};

const actions = {
  showBlogDetail: function({ commit }, blogDetail) {
    commit('CHANGE_BLOG_DETAIL_SHOW');
    // todo: get detail from server.
    commit('SET_BLOG_DETAIL', blogDetail);
  },
  showBlogList: function({ commit }) {
    commit('CHANGE_BLOG_DETAIL_SHOW');
    commit('SET_BLOG_DETAIL', {});
  },
};

export default {
  namespaced: true,
  state,
  mutations,
  actions,
};
