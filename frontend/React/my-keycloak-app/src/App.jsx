import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { CssBaseline, Container, Box } from '@mui/material';
import Navbar from './components/Navbar';
import Home from './pages/Home';
import Dashboard from './pages/Dashboard';
import Profile from './pages/Profile';

function App() {
const handleLogout = () => {
  const logoutUrl = `http://localhost:7080/realms/myrealm/protocol/openid-connect/logout?redirect_uri=http://localhost:5173/`;
  window.location.href = logoutUrl;
};

  return (
    <Router>
      <CssBaseline />
      <Box sx={{ display: 'flex', flexDirection: 'column', minHeight: '100vh' }}>
        {/* Full-width Fixed Header */}
        <Navbar onLogout={handleLogout} />

        {/* Main Content Area with margin to prevent overlap */}
        <Box component="main" sx={{ flexGrow: 1, mt: 8 }}>
          <Container>
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/dashboard" element={<Dashboard />} />
              <Route path="/profile" element={<Profile />} />
            </Routes>
          </Container>
        </Box>
      </Box>
    </Router>
  );
}

export default App;
