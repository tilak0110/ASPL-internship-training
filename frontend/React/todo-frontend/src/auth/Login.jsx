import { useEffect, useState } from "react";
import { useAuth } from "./AuthContext";
import { Navigate, useNavigate } from "react-router-dom";
import axiosInstance from "../api/axios";

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const { login , user} = useAuth();
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const res = await axiosInstance.post('/user/login',{
        username,
        password,
      })
      const token = res.data;
      login(token);
      navigate('/dashboard') 
      
    } catch (error) {
      alert('Login Failed: ' + (error?.resposnse?.data || error.message))
      
    }
  }

  useEffect(() => {
  if (user) {
    navigate('/dashboard');
  }
}, [user, navigate]);

  return (
  <div>
    <h2>Login Page</h2>
    <form onSubmit={handleSubmit}>
      <input 
        type="text" 
        placeholder="username" 
        value={username}
        onChange={(e) => setUsername(e.target.value)}/>
      <br /><br />

      <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}/>
        <br /><br />

        <button type="submit"> Login</button>


    </form>
  </div>
  );
}
export default Login;