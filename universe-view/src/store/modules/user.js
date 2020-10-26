import { login, logout, getInfo } from '@/api/user';
import { getToken, setToken, removeToken } from '@/utils/auth';
import { resetRouter } from '@/router';
import ApiConst from '@/api/ApiConst';

const getDefaultState = () => {
  return {
    token: getToken(),
    name: '',
    avatar: '',
  };
};

const state = getDefaultState();

const mutations = {
  [ApiConst.USER.MUTATION.RESET_STATE]: (state) => {
    Object.assign(state, getDefaultState());
  },
  [ApiConst.USER.MUTATION.SET_TOKEN]: (state, token) => {
    state.token = token;
  },
  [ApiConst.USER.MUTATION.SET_NAME]: (state, name) => {
    state.name = name;
  },
  [ApiConst.USER.MUTATION.SET_AVATAR]: (state, avatar) => {
    state.avatar = avatar;
  },
};

const actions = {
  // user login
  [ApiConst.USER.ACTION.LOGIN]: ({ commit }, userInfo) => {
    const { username, password } = userInfo;
    console.log(JSON.stringify(userInfo));
    return new Promise((resolve, reject) => {
      login({ username: username.trim(), password: password }).then(response => {
        const { data } = response;
        commit(ApiConst.USER.MUTATION.SET_TOKEN, data.token);
        setToken(data.token);
        resolve();
      }).catch(error => {
        reject(error);
      });
    });
  },

  // get user info
  [ApiConst.USER.ACTION.GET_INFO]: ({ commit, state }) => {
    return new Promise((resolve, reject) => {
      getInfo(state.token).then(response => {
        const { data } = response;

        if (!data) {
          return reject('Verification failed, please Login again.');
        }

        const { name, avatar } = data;

        commit(ApiConst.USER.MUTATION.SET_NAME, name);
        commit(ApiConst.USER.MUTATION.SET_AVATAR, avatar);
        resolve(data);
      }).catch(error => {
        reject(error);
      });
    });
  },

  // user logout
  [ApiConst.USER.ACTION.LOGOUT]: ({ commit, state }) => {
    return new Promise((resolve, reject) => {
      logout(state.token).then(() => {
        removeToken(); // must remove  token  first
        resetRouter();
        commit(ApiConst.USER.MUTATION.RESET_STATE);
        resolve();
      }).catch(error => {
        reject(error);
      });
    });
  },

  // remove token
  [ApiConst.USER.ACTION.RESET_TOKEN]: ({ commit }) => {
    return new Promise(resolve => {
      removeToken(); // must remove  token  first
      commit(ApiConst.USER.MUTATION.RESET_STATE);
      resolve();
    });
  },
};

export default {
  namespaced: true,
  state,
  mutations,
  actions,
};

