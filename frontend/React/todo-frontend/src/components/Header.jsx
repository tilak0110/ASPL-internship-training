import { useAuth } from "../auth/AuthContext";
import { useNavigate } from "react-router-dom";

const Header = () => {
  const { user, logout } = useAuth();
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate("/"); 
  };

  return (
    <header style={{ display: "flex", justifyContent: "space-between", padding: "1rem", borderBottom: "1px solid gray" }}>
      <h2>Todo App</h2>
      {user && (
        <div>
          <span style={{ marginRight: "1rem" }}>👋 Hello, {user.sub}</span>
          <button onClick={handleLogout}>🚪 Logout</button>
        </div>
      )}
    </header>
  );
};

export default Header;
