import Vue from 'vue';
import VueI18n from 'vue-i18n';
import enLocale from '@/components/i18n/res/en';
import zhLocale from '@/components/i18n/res/zh';
import ElementLocale from 'element-ui/lib/locale';

Vue.use(VueI18n);

const messages = {
  en: {
    ...enLocale,
  },
  zh: {
    ...zhLocale,
  },
};
const i18n = new VueI18n({
  locale: 'zh', // set locale
  messages, // set locale messages
});

ElementLocale.i18n((key, value) => i18n.t(key, value));

export default i18n;
