const state = {
  showSide: false,
};

const mutations = {
  CHANGE_SIDE_SHOW: (state) => {
    state.showSide = !state.showSide;
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
