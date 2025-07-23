import { createSlice } from "@reduxjs/toolkit";
import { jwtDecode } from "jwt-decode";

function getInitialAuthState() {
  const tokenFromLocal = localStorage.getItem("token");
  const tokenFromSession = sessionStorage.getItem("token");
  const token = tokenFromLocal || tokenFromSession;

  return {
    token: token || null,
    user: token ? jwtDecode(token) : null,
  };
}

const authSlice = createSlice({
  name: "auth",
  initialState: getInitialAuthState(), 
  reducers: {
    login: {
      reducer(state, action) {
        const { token } = action.payload;
        state.token = token;
        state.user = jwtDecode(token);
      },
      prepare({ token, rememberMe }) {
        if (rememberMe) {
          localStorage.setItem("token", token);
        } else {
          sessionStorage.setItem("token", token);
        }
        return { payload: { token } };
      },
    },
    logout(state) {
      localStorage.removeItem("token");
      sessionStorage.removeItem("token");
      state.token = null;
      state.user = null;
    },
  },
});

export const authActions = authSlice.actions;
export default authSlice;
