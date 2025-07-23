import axios from "axios";
import keycloak from "../auth/keycloak";

const api = axios.create({
  baseURL: import.meta.env.VITE_BASE_URL,
});

api.interceptors.request.use(
  async (config) => {
    if (keycloak?.token) {
      console.log("Token", keycloak.token);
      try {
        const refreshed = await keycloak.updateToken(30);
        if (refreshed) {
          console.log(" Token refreshed");
        }

        config.headers.Authorization = `Bearer ${keycloak.token}`;
      } catch (error) {
        console.error(" Token refresh failed:", error);
        keycloak.logout();
      }
    }
    return config;
  },
  (error) => {
    console.error("Request error:", error);
    return Promise.reject(error);
  }
);

api.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response?.status === 401) {
      console.warn("401 Unauthorized – logging out...");
      keycloak.logout();
    }
    return Promise.reject(error);
  }
);

export default api;
