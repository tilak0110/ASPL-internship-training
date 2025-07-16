import { useAuth } from "../auth/AuthContext";
import { useNavigate, Link } from "react-router-dom";
import { useState } from "react";
import { useTheme } from "./ThemeContext";


const Header = () => {
  const { user, logout } = useAuth();
  const navigate = useNavigate();
  const { theme, toggleTheme } = useTheme(); // 👈 use theme context

  const [showModal, setShowModal] = useState(false);

  const handleLogout = () => {
    logout();
    setShowModal(false);
    navigate("/");
  };

  return (
    <>
      <header className={`navbar navbar-expand-lg ${theme === "dark" ? "navbar-dark bg-dark" : "navbar-light bg-light"} px-4 border-bottom shadow-sm mb-4`}>
        <div className="container-fluid justify-content-between">
          <div
            className="d-flex align-items-center"
            style={{ cursor: "pointer" }}
            onClick={() => navigate("/dashboard")}
          >
            <img
              src="/productivity.png"
              alt="Logo"
              style={{ height: "40px", marginRight: "10px" }}
            />
            <h2 className="navbar-brand m-0">Todo App</h2>
          </div>

          {user && (
            <div className="d-flex align-items-center gap-2">
              <span className="me-2">👋 Hello, <strong>{user.sub}</strong></span>

              {/* Theme Toggle Button */}
              <button
                className="btn btn-outline-secondary btn-sm"
                onClick={toggleTheme}
                title="Toggle Light/Dark"
              >
                {theme === "light" ? "🌙 Dark" : "☀️ Light"}
              </button>

              <Link to="/profile" className="btn btn-outline-primary btn-sm">
                👤 Profile
              </Link>

              <button
                className="btn btn-outline-danger btn-sm"
                onClick={() => setShowModal(true)}
              >
                🚪 Logout
              </button>
            </div>
          )}
        </div>
      </header>

      {/* Logout Confirmation Modal */}
      {showModal && (
        <div
          className="modal show fade d-block"
          tabIndex="-1"
          style={{ backgroundColor: "rgba(0,0,0,0.5)" }}
        >
          <div className="modal-dialog">
            <div className="modal-content">
              <div className="modal-header">
                <h5 className="modal-title">Confirm Logout</h5>
                <button
                  type="button"
                  className="btn-close"
                  onClick={() => setShowModal(false)}
                ></button>
              </div>
              <div className="modal-body">
                <p>Are you sure you want to logout?</p>
              </div>
              <div className="modal-footer">
                <button
                  type="button"
                  className="btn btn-secondary"
                  onClick={() => setShowModal(false)}
                >
                  Cancel
                </button>
                <button
                  type="button"
                  className="btn btn-danger"
                  onClick={handleLogout}
                >
                  Yes, Logout
                </button>
              </div>
            </div>
          </div>
        </div>
      )}
    </>
  );
};

export default Header;
