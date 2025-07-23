// src/main.jsx
import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.jsx";
import "./index.css";

import keycloak from "./keycloak"; // ✅ same instance
import { ReactKeycloakProvider } from "@react-keycloak/web";

ReactDOM.createRoot(document.getElementById("root")).render(
  
    <ReactKeycloakProvider
      authClient={keycloak}
      initOptions={{ onLoad: "login-required" }} // or "check-sso"
    >
      <App />
    </ReactKeycloakProvider>
);
