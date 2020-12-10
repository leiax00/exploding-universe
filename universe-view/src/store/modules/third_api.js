import common from '@/prop/api/common';
import apiConst from '@/prop/api/apiConst';

const state = {};

const mutations = {};

const actions = {
  captureMotto: function({ commit }) {
    const typeStr = 'abcdefghijkl';
    const param = `c=${typeStr.charAt(Math.floor(Math.random() * typeStr.length))}&encode=json&charset=utf-8&min_length=0&max_length=1000`;
    return new Promise((resolve, reject) => {
      common.get(`${apiConst.thrid.GET_MOTTO}?${param}`).then(resp => {
        const motto = { text: resp.hitokoto, from: resp.from, author: resp.creator };
        resolve(motto);
      });
    });
  },
};

export default {
  namespaced: true,
  state,
  mutations,
  actions,
};
