import { useAuth } from './config/authcontext';
import { Toaster } from 'react-hot-toast';
import ProductList from './components/ProductList';
import {
  AppBar,
  Toolbar,
  Typography,
  Button,
  Box,
  Avatar,
  Container,
  Grid,
  Card,
  CardContent,
  CircularProgress,
} from '@mui/material';

function App() {
  const { isAuthenticated, isLoading, login, logout, keycloakInstance } = useAuth();

  if (isLoading) {
    return (
      <Box
        display="flex"
        height="100vh"
        alignItems="center"
        justifyContent="center"
        flexDirection="column"
      >
        <CircularProgress />
        <Typography variant="h6" mt={2}>
          Authenticating...
        </Typography>
      </Box>
    );
  }

  return (
    <Box>
      <Toaster position="top-right" />

      {isAuthenticated ? (
        <>
          {/* App Bar */}
          <AppBar position="static">
            <Toolbar>
              <Typography variant="h6" sx={{ flexGrow: 1 }}>
                OAuth2 Client
              </Typography>
              <Button color="inherit" onClick={logout}>
                Logout
              </Button>
            </Toolbar>
          </AppBar>

          <Container sx={{ mt: 4 }}>
            {/* User Info */}
            <Card sx={{ mb: 3 }}>
              <CardContent>
                <Grid container spacing={2} alignItems="center">
                  <Grid item>
                    {keycloakInstance.tokenParsed?.picture && (
                      <Avatar
                        src={keycloakInstance.tokenParsed.picture}
                        alt="User profile"
                        sx={{ width: 60, height: 60 }}
                      />
                    )}
                  </Grid>
                  <Grid item>
                    <Typography variant="h6">
                      {keycloakInstance.tokenParsed?.name || 'User'}
                    </Typography>
                    <Typography variant="body2">
                      {keycloakInstance.tokenParsed?.email}
                    </Typography>
                    <Typography variant="caption">
                      Username: {keycloakInstance.tokenParsed?.preferred_username}
                    </Typography>
                  </Grid>
                </Grid>
              </CardContent>
            </Card>

            {/* Account Information */}
            <Card sx={{ mb: 3 }}>
              <CardContent>
                <Typography variant="h6" gutterBottom>
                  Account Information
                </Typography>
                <Grid container spacing={2}>
                  <Grid item xs={6}>
                    <Typography variant="subtitle2">Email Verified</Typography>
                    <Typography>
                      {keycloakInstance.tokenParsed?.email_verified ? 'Yes' : 'No'}
                    </Typography>
                  </Grid>
                  <Grid item xs={6}>
                    <Typography variant="subtitle2">Account Created</Typography>
                    <Typography>
                      {new Date(keycloakInstance.tokenParsed?.iat * 1000).toLocaleString()}
                    </Typography>
                  </Grid>
                </Grid>
              </CardContent>
            </Card>

            {/* Token Info */}
            <Card sx={{ mb: 3 }}>
              <CardContent>
                <Typography variant="h6" gutterBottom>
                  Token Details
                </Typography>
                <Grid container spacing={2}>
                  <Grid item xs={6}>
                    <Typography variant="subtitle2">Token Expires</Typography>
                    <Typography>
                      {new Date(keycloakInstance.tokenParsed?.exp * 1000).toLocaleString()}
                    </Typography>
                  </Grid>
                  <Grid item xs={6}>
                    <Typography variant="subtitle2">Issuer</Typography>
                    <Typography>{keycloakInstance.tokenParsed?.iss}</Typography>
                  </Grid>
                </Grid>
              </CardContent>
            </Card>

            {/* Product List Section */}
            <ProductList />
          </Container>
        </>
      ) : (
        // Login UI
        <Box
          display="flex"
          height="100vh"
          alignItems="center"
          justifyContent="center"
          flexDirection="column"
        >
          <Card sx={{ p: 4, minWidth: 300 }}>
            <CardContent>
              <Typography variant="h5" gutterBottom>
                Welcome Back
              </Typography>
              <Typography variant="body1" mb={2}>
                Please login to access your dashboard
              </Typography>
              <Button variant="contained" color="primary" onClick={login}>
                Login with Keycloak
              </Button>
            </CardContent>
          </Card>
        </Box>
      )}
    </Box>
  );
}

export default App;
