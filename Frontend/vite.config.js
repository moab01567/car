import {defineConfig} from "vite";
import react from "@vitejs/plugin-react"


export default defineConfig({
    plugins: [react()],
    server: {
        proxy: {
            //"/auth": REST_API_URL,
            //"/api": REST_API_URL,
        }
    }
})