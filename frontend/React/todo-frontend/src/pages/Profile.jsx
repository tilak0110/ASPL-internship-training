import { useNavigate } from "react-router-dom";
import { useAuth } from "../auth/AuthContext";

const Profile = () => {
  const { user } = useAuth();
  const navigate = useNavigate();
  const getInitial = (name) => {
    if (!name) return "?";
    return name.charAt(0).toUpperCase();
  };

  return (
    <div className="container mt-5">
      <div className="card shadow p-4 mx-auto" style={{ maxWidth: "500px" }}>
        <h3 className="mb-4 text-center">👤 User Profile</h3>
        <div
            className="rounded-circle bg-primary text-white d-flex justify-content-center align-items-center mx-auto"
            style={{ width: "100px", height: "100px", fontSize: "36px" }}
          >
            {getInitial(user?.sub)}
          </div>

        <ul className="list-group list-group-flush">
          <li className="list-group-item">
            <strong>Username:</strong> {user?.sub}
          </li>
          <li className="list-group-item">
            <strong>User ID:</strong> {user?.id}
          </li>
          <li className="list-group-item">
            <strong>Email:</strong> {user?.Email || "Not available"}
          </li>
        </ul>

        <div className="mt-4 text-center">
          <button className="btn btn-secondary" onClick={() => navigate('/dashboard')} >
            Back to Dashboard
          </button>
        </div>
      </div>
    </div>
  );
};

export default Profile;
