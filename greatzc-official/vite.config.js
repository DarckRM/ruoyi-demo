import { defineConfig, loadEnv } from "vite";
import vue from "@vitejs/plugin-vue";
import Components from "unplugin-vue-components/vite";
import { BootstrapVueNextResolver } from "bootstrap-vue-next";
import Icons from "unplugin-icons/vite";
import IconsResolve from "unplugin-icons/resolver";
import path from "path";

// const BASE_URL = import.meta.env.BASE_URL;

// https://vitejs.dev/config/
export default ({ mode }) => {
  const env = loadEnv(mode, process.cwd());
  const port = env.VITE_PORT
  console.log(env)
  return defineConfig({
    devServer: {
      host: "0.0.0.0",
      port: port,
      open: true,
      proxy: {
        ['http://locahost:5173/dev-api']: {
          name: "GreatZC Official Website",
          target: `http://localhost:8080`,
          changeOrigin: true,
          pathRewrite: {
            ['http://locahost:5173/dev-api']: "",
          },
        },
      },
      disableHostCheck: true,
    },
    resolve: {
      alias: {
        "@": path.resolve(__dirname, "src"),
      },
    },
    plugins: [
      vue(),
      Components({
        resolvers: [BootstrapVueNextResolver(), IconsResolve()],
        dts: true,
      }),
      Icons({
        compiler: "vue3",
        autoInstall: true,
      }),
    ],
  });
};
