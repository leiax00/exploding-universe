const path = require('path');
const defaultSettings = require('./src/settings.js');

function resolve(dir) {
  return path.join(__dirname, dir);
}

const name = defaultSettings.title || 'Universe-View'; // page title
const port = process.env.port || process.env.npm_config_port || 80; // dev port

module.exports = {
  publicPath: '/',
  outputDir: 'dist',
  assetsDir: 'static',
  lintOnSave: process.env.NODE_ENV === 'development',
  devServer: {
    port: port,
    open: false,
    disableHostCheck: true,
    overlay: {
      warnings: false,
      errors: true,
    },
  },
  // css: {
  //   loaderOptions: {
  //     less: {
  //       javascriptEnabled: true,
  //     },
  //   },
  // },
  configureWebpack: {
    // provide the app's title in webpack's name field, so that
    // it can be accessed in index.html to inject the correct title.
    name: name,
    resolve: {
      extensions: ['.js', '.vue', '.json'],
      alias: {
        '@': resolve('src'),
      },
    },
  },
  chainWebpack: config => {
    // config.resolve.alias
    //   .set('@', resolve('src'))
    // ;
  },
};
