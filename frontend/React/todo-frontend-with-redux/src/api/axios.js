import axios from 'axios';

const BASE_URL = 'http://localhost:8080'; // Spring Boot backend

const axiosInstance = axios.create({
  baseURL: BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

axiosInstance.interceptors.request.use(
    (config)=> {
        const token = localStorage.getItem('token') || sessionStorage.getItem('token');
        if(token){
            config.headers.Authorization = `Bearer ${token}`;
        }
        return config;
    },
    (error) => Promise.reject(error) 
);

export default axiosInstance;