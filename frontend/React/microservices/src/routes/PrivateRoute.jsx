import { useKeycloak } from "@react-keycloak/web";
import { Navigate, useLocation } from "react-router-dom";

const PrivateRoute = ({ children }) => {
  const { keycloak, initialized } = useKeycloak();
  const location = useLocation();


  if (!initialized) {
    return <div>Loading authentication...</div>;
  }

 
  if (!keycloak.authenticated) {
    keycloak.login({ redirectUri: window.location.origin + location.pathname });
    return <div>Redirecting to login...</div>;
  }


  return children;
};

export default PrivateRoute;
