import { Navigate, Route, Routes } from "react-router-dom"
import Register from "./auth/Register"
import Login from "./auth/Login"
import Dashboard from "./pages/Dashboard"
import routes from "./routes"
import Header from "./components/Header"
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {


  return (  
    <>
      <Header/>
      <div>
        <Routes>
        {routes.map(({path,element})=>(
          <Route key={path} path={path} element={element}/>
        ))}
        <Route path="*" element={<Navigate to="/" replace />} />
        </Routes>
      </div>
      <ToastContainer position="top-right" autoClose={2500} />
    </>
  )
}

export default App
