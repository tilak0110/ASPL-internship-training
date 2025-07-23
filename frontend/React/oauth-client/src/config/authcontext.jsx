import { createContext, useContext, useState, useEffect } from "react";
import keycloak from "./KeyCloak";
import toast from "react-hot-toast";

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [keycloakInstance, setKeycloakInstance] = useState(null);
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        keycloak.init({
            onLoad: 'check-sso',
            pkceMethod: 'S256'
        })
        .then((authenticated) => {
            setIsAuthenticated(authenticated);
            setKeycloakInstance(keycloak);
            if (authenticated) {
                toast.success("Login Success");
            }
            setIsLoading(false);
            console.log(keycloak);
        })
        .catch((error) => {
            toast.error("Login Failed");
            console.error("Keycloak init error:", error);
            setIsLoading(false);
        });
    }, []);

    const login = () => keycloak.login();
    const logout = () => keycloak.logout();

    return (
        <AuthContext.Provider
            value={{
                isAuthenticated,
                isLoading,
                keycloakInstance,
                login,
                logout
            }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => useContext(AuthContext);