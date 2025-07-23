import { useKeycloak } from '@react-keycloak/web';
import { Box, Typography, Button, Paper } from '@mui/material';

const Dashboard = () => {
  const { keycloak } = useKeycloak();

  const fullName = keycloak?.tokenParsed?.name || "User";

  return (
    <Box
      display="flex"
      alignItems="center"
      justifyContent="center"
      minHeight="80vh"
    >
      <Paper
        elevation={4}
        sx={{
          p: { xs: 3, sm: 6 },
          borderRadius: 3,
          textAlign: "center",
          background: (theme) =>
            theme.palette.mode === "dark"
              ? "linear-gradient(90deg, #212237 70%, #232549 100%)"
              : "linear-gradient(90deg, #fafdff 70%, #e5ffee 100%)",
        }}
      >
        <Typography
          variant="h4"
          sx={{
            mb: 2,
            fontWeight: 700,
            color: "primary.main",
            letterSpacing: 0.3,
          }}
          gutterBottom
        >
          Welcome, {fullName}
        </Typography>
        <Button
          variant="contained"
          color="secondary"
          sx={{ fontWeight: 600, letterSpacing: 0.2, fontSize: 16, mt: 1 }}
          onClick={() => keycloak.logout()}
        >
          Logout
        </Button>
      </Paper>
    </Box>
  );
};

export default Dashboard;
