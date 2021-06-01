const path = require("path");

module.exports = {
  chainWebpack: config => {
    config.module
      .rule("pdf")
      .test(/\.pdf$/)
      .use("file-loader")
      .loader("file-loader");
  },
  outputDir: path.resolve("__dirname", "../../main/resources/static"),
  devServer: {
    proxy: {
      "/": {
        target: "http://localhost:8080",
        ws: true,
        changeOrigin: true
      }
    },
    port: 4000
  },
  transpileDependencies: ["vuetify"],
};


