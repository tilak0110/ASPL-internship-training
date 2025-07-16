import { createSlice } from "@reduxjs/toolkit";
import { jwtDecode } from 'jwt-decode';

const tokenFromStorage = localStorage.getItem("token");

const init = {
  token: tokenFromStorage || null,
  user: tokenFromStorage ? jwtDecode(tokenFromStorage) : null,
};

const authSlice = createSlice({
  name: "auth",
  initialState: init,
  reducers: {
    login(state, action) {
      const token = action.payload;
      localStorage.setItem("token", token);
      state.token = token;
      state.user = jwtDecode(token);
    },
    logout(state) {
      localStorage.removeItem("token");
      state.token = null;
      state.user = null;
    },
  },
});

export const authActions = authSlice.actions;
export default authSlice;