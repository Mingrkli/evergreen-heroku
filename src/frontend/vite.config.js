import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  // Makes it so that whenever we put "/api" anywhere it would turn into what we put in the target
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:5174/',
        ws: true,
        changeOrigin: true
      }
    }
  }
})
