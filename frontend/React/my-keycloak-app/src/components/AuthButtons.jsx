import { useKeycloak } from "@react-keycloak/web";

const AuthButtons = () => {
  const { keycloak } = useKeycloak();

  const handleLogin = () => {
    keycloak.login();
  };

  const handleLogout = () => {
    keycloak.logout({
      redirectUri: "http://localhost:5173/",
    });
  };

  return (
    <div>
      {keycloak?.authenticated ? (
        <button onClick={handleLogout}>Logout</button>
      ) : (
        <button onClick={handleLogin}>Login</button>
      )}
    </div>
  );
};

export default AuthButtons;
