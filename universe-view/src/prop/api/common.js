import request from '@/prop/util/request';
import { Notification } from 'element-ui';

export default {
  get: (url) => {
    return request({
      url: url,
      method: 'get',
    });
  },

  post: (url, data) => {
    return request({
      url: url,
      method: 'post',
      data,
    });
  },

  put: (url, data) => {
    return request({
      url: url,
      method: 'put',
      data,
    });
  },

  delete: (url) => {
    return request({
      url: url,
      method: 'delete',
    });
  },

  notify: (title, type, message) => {
    if (message === undefined || message === '') {
      return;
    }
    Notification({
      title: title,
      message: message,
      type: type,
      duration: 5000,
    });
  },
};
