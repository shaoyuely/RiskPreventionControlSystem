const { defineConfig } = require('@vue/cli-service');

module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false
});

// module.exports = {
//   devServer: {
//     host: 'localhost',
//     port: 8081
//   }
// };
