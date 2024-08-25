// vite.config.js
import { defineConfig, loadEnv } from "file:///E:/CodingLife/ruoyi-demo/greatzc-official/node_modules/vite/dist/node/index.js";
import vue from "file:///E:/CodingLife/ruoyi-demo/greatzc-official/node_modules/@vitejs/plugin-vue/dist/index.mjs";
import Components from "file:///E:/CodingLife/ruoyi-demo/greatzc-official/node_modules/unplugin-vue-components/dist/vite.js";
import { BootstrapVueNextResolver } from "file:///E:/CodingLife/ruoyi-demo/greatzc-official/node_modules/bootstrap-vue-next/dist/bootstrap-vue-next.mjs";
import Icons from "file:///E:/CodingLife/ruoyi-demo/greatzc-official/node_modules/unplugin-icons/dist/vite.js";
import IconsResolve from "file:///E:/CodingLife/ruoyi-demo/greatzc-official/node_modules/unplugin-icons/dist/resolver.js";
import path from "path";
var __vite_injected_original_dirname = "E:\\CodingLife\\ruoyi-demo\\greatzc-official";
var vite_config_default = ({ mode }) => {
  const env = loadEnv(mode, process.cwd());
  const port = env.VITE_PORT;
  console.log(env);
  return defineConfig({
    devServer: {
      host: "0.0.0.0",
      port,
      open: true,
      proxy: {
        ["http://locahost:" + port + "/dev-api"]: {
          name: "GreatZC Official Website",
          target: `http://localhost:8080`,
          changeOrigin: true,
          pathRewrite: {
            ["http://locahost:" + port + "/dev-api"]: ""
          }
        }
      },
      disableHostCheck: true
    },
    resolve: {
      alias: {
        "@": path.resolve(__vite_injected_original_dirname, "src")
      }
    },
    plugins: [
      vue(),
      Components({
        resolvers: [BootstrapVueNextResolver(), IconsResolve()],
        dts: true
      }),
      Icons({
        compiler: "vue3",
        autoInstall: true
      })
    ]
  });
};
export {
  vite_config_default as default
};
//# sourceMappingURL=data:application/json;base64,ewogICJ2ZXJzaW9uIjogMywKICAic291cmNlcyI6IFsidml0ZS5jb25maWcuanMiXSwKICAic291cmNlc0NvbnRlbnQiOiBbImNvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9kaXJuYW1lID0gXCJFOlxcXFxDb2RpbmdMaWZlXFxcXHJ1b3lpLWRlbW9cXFxcZ3JlYXR6Yy1vZmZpY2lhbFwiO2NvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9maWxlbmFtZSA9IFwiRTpcXFxcQ29kaW5nTGlmZVxcXFxydW95aS1kZW1vXFxcXGdyZWF0emMtb2ZmaWNpYWxcXFxcdml0ZS5jb25maWcuanNcIjtjb25zdCBfX3ZpdGVfaW5qZWN0ZWRfb3JpZ2luYWxfaW1wb3J0X21ldGFfdXJsID0gXCJmaWxlOi8vL0U6L0NvZGluZ0xpZmUvcnVveWktZGVtby9ncmVhdHpjLW9mZmljaWFsL3ZpdGUuY29uZmlnLmpzXCI7aW1wb3J0IHsgZGVmaW5lQ29uZmlnLCBsb2FkRW52IH0gZnJvbSBcInZpdGVcIjtcclxuaW1wb3J0IHZ1ZSBmcm9tIFwiQHZpdGVqcy9wbHVnaW4tdnVlXCI7XHJcbmltcG9ydCBDb21wb25lbnRzIGZyb20gXCJ1bnBsdWdpbi12dWUtY29tcG9uZW50cy92aXRlXCI7XHJcbmltcG9ydCB7IEJvb3RzdHJhcFZ1ZU5leHRSZXNvbHZlciB9IGZyb20gXCJib290c3RyYXAtdnVlLW5leHRcIjtcclxuaW1wb3J0IEljb25zIGZyb20gXCJ1bnBsdWdpbi1pY29ucy92aXRlXCI7XHJcbmltcG9ydCBJY29uc1Jlc29sdmUgZnJvbSBcInVucGx1Z2luLWljb25zL3Jlc29sdmVyXCI7XHJcbmltcG9ydCBwYXRoIGZyb20gXCJwYXRoXCI7XHJcblxyXG4vLyBjb25zdCBCQVNFX1VSTCA9IGltcG9ydC5tZXRhLmVudi5CQVNFX1VSTDtcclxuXHJcbi8vIGh0dHBzOi8vdml0ZWpzLmRldi9jb25maWcvXHJcbmV4cG9ydCBkZWZhdWx0ICh7IG1vZGUgfSkgPT4ge1xyXG4gIGNvbnN0IGVudiA9IGxvYWRFbnYobW9kZSwgcHJvY2Vzcy5jd2QoKSk7XHJcbiAgY29uc3QgcG9ydCA9IGVudi5WSVRFX1BPUlQ7XHJcbiAgY29uc29sZS5sb2coZW52KTtcclxuICByZXR1cm4gZGVmaW5lQ29uZmlnKHtcclxuICAgIGRldlNlcnZlcjoge1xyXG4gICAgICBob3N0OiBcIjAuMC4wLjBcIixcclxuICAgICAgcG9ydDogcG9ydCxcclxuICAgICAgb3BlbjogdHJ1ZSxcclxuICAgICAgcHJveHk6IHtcclxuICAgICAgICBbXCJodHRwOi8vbG9jYWhvc3Q6XCIgKyBwb3J0ICsgXCIvZGV2LWFwaVwiXToge1xyXG4gICAgICAgICAgbmFtZTogXCJHcmVhdFpDIE9mZmljaWFsIFdlYnNpdGVcIixcclxuICAgICAgICAgIHRhcmdldDogYGh0dHA6Ly9sb2NhbGhvc3Q6ODA4MGAsXHJcbiAgICAgICAgICBjaGFuZ2VPcmlnaW46IHRydWUsXHJcbiAgICAgICAgICBwYXRoUmV3cml0ZToge1xyXG4gICAgICAgICAgICBbXCJodHRwOi8vbG9jYWhvc3Q6XCIgKyBwb3J0ICsgXCIvZGV2LWFwaVwiXTogXCJcIixcclxuICAgICAgICAgIH0sXHJcbiAgICAgICAgfSxcclxuICAgICAgfSxcclxuICAgICAgZGlzYWJsZUhvc3RDaGVjazogdHJ1ZSxcclxuICAgIH0sXHJcbiAgICByZXNvbHZlOiB7XHJcbiAgICAgIGFsaWFzOiB7XHJcbiAgICAgICAgXCJAXCI6IHBhdGgucmVzb2x2ZShfX2Rpcm5hbWUsIFwic3JjXCIpLFxyXG4gICAgICB9LFxyXG4gICAgfSxcclxuICAgIHBsdWdpbnM6IFtcclxuICAgICAgdnVlKCksXHJcbiAgICAgIENvbXBvbmVudHMoe1xyXG4gICAgICAgIHJlc29sdmVyczogW0Jvb3RzdHJhcFZ1ZU5leHRSZXNvbHZlcigpLCBJY29uc1Jlc29sdmUoKV0sXHJcbiAgICAgICAgZHRzOiB0cnVlLFxyXG4gICAgICB9KSxcclxuICAgICAgSWNvbnMoe1xyXG4gICAgICAgIGNvbXBpbGVyOiBcInZ1ZTNcIixcclxuICAgICAgICBhdXRvSW5zdGFsbDogdHJ1ZSxcclxuICAgICAgfSksXHJcbiAgICBdLFxyXG4gIH0pO1xyXG59O1xyXG4iXSwKICAibWFwcGluZ3MiOiAiO0FBQXFULFNBQVMsY0FBYyxlQUFlO0FBQzNWLE9BQU8sU0FBUztBQUNoQixPQUFPLGdCQUFnQjtBQUN2QixTQUFTLGdDQUFnQztBQUN6QyxPQUFPLFdBQVc7QUFDbEIsT0FBTyxrQkFBa0I7QUFDekIsT0FBTyxVQUFVO0FBTmpCLElBQU0sbUNBQW1DO0FBV3pDLElBQU8sc0JBQVEsQ0FBQyxFQUFFLEtBQUssTUFBTTtBQUMzQixRQUFNLE1BQU0sUUFBUSxNQUFNLFFBQVEsSUFBSSxDQUFDO0FBQ3ZDLFFBQU0sT0FBTyxJQUFJO0FBQ2pCLFVBQVEsSUFBSSxHQUFHO0FBQ2YsU0FBTyxhQUFhO0FBQUEsSUFDbEIsV0FBVztBQUFBLE1BQ1QsTUFBTTtBQUFBLE1BQ047QUFBQSxNQUNBLE1BQU07QUFBQSxNQUNOLE9BQU87QUFBQSxRQUNMLENBQUMscUJBQXFCLE9BQU8sVUFBVSxHQUFHO0FBQUEsVUFDeEMsTUFBTTtBQUFBLFVBQ04sUUFBUTtBQUFBLFVBQ1IsY0FBYztBQUFBLFVBQ2QsYUFBYTtBQUFBLFlBQ1gsQ0FBQyxxQkFBcUIsT0FBTyxVQUFVLEdBQUc7QUFBQSxVQUM1QztBQUFBLFFBQ0Y7QUFBQSxNQUNGO0FBQUEsTUFDQSxrQkFBa0I7QUFBQSxJQUNwQjtBQUFBLElBQ0EsU0FBUztBQUFBLE1BQ1AsT0FBTztBQUFBLFFBQ0wsS0FBSyxLQUFLLFFBQVEsa0NBQVcsS0FBSztBQUFBLE1BQ3BDO0FBQUEsSUFDRjtBQUFBLElBQ0EsU0FBUztBQUFBLE1BQ1AsSUFBSTtBQUFBLE1BQ0osV0FBVztBQUFBLFFBQ1QsV0FBVyxDQUFDLHlCQUF5QixHQUFHLGFBQWEsQ0FBQztBQUFBLFFBQ3RELEtBQUs7QUFBQSxNQUNQLENBQUM7QUFBQSxNQUNELE1BQU07QUFBQSxRQUNKLFVBQVU7QUFBQSxRQUNWLGFBQWE7QUFBQSxNQUNmLENBQUM7QUFBQSxJQUNIO0FBQUEsRUFDRixDQUFDO0FBQ0g7IiwKICAibmFtZXMiOiBbXQp9Cg==
