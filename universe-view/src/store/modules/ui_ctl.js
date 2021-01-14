const state = {
  showSide: false,
};

const mutations = {
  SET_SIDE_SHOW: (state, isShow) => {
    state.showSide = isShow;
  },
};

const actions = {

};

export default {
  namespaced: true,
  state,
  mutations,
  actions,
};
