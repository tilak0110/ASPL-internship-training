import { useKeycloak } from "@react-keycloak/web";
import { Box, Typography, Paper, Avatar, useTheme, Divider, Stack } from "@mui/material";

const Profile = () => {
  const { keycloak } = useKeycloak();
  const userInfo = keycloak?.tokenParsed;
  const theme = useTheme();

  return (
    <Box
      sx={{
        background: theme.palette.mode === "dark"
          ? "linear-gradient(90deg, #232549 60%, #21223a 100%)"
          : "linear-gradient(90deg, #fafdff 60%, #eef2f9 100%)",
        minHeight: "100vh",
        py: { xs: 2, md: 6 },
        px: 2,
      }}
      display="flex"
      alignItems="center"
      justifyContent="center"
    >
      <Paper
        elevation={4}
        sx={{
          p: { xs: 3, sm: 5 },
          borderRadius: 3,
          minWidth: 320,
          maxWidth: 440,
          width: "100%",
          mx: "auto",
          textAlign: "center"
        }}
      >
        <Typography
          variant="h5"
          gutterBottom
          color="primary"
          fontWeight={800}
          sx={{ letterSpacing: 0.4 }}
        >
          User Profile
        </Typography>
        <Divider sx={{ mb: 3, mt: 1 }} />

        {userInfo ? (
          <Box>
            <Stack alignItems="center" spacing={1.5} mb={2}>
              <Avatar sx={{
                bgcolor: "primary.main",
                width: 64,
                height: 64,
                fontSize: 32,
                boxShadow: theme.palette.mode === "dark"
                  ? "0 2px 16px #1e223478"
                  : "0 2px 16px #eadfbc68"
              }}>
                {userInfo?.preferred_username?.charAt(0)?.toUpperCase() ||
                 userInfo?.name?.charAt(0)?.toUpperCase() ||
                 "U"}
              </Avatar>
              <Typography variant="h6" fontWeight={700}>
                {userInfo?.preferred_username || userInfo?.name}
              </Typography>
              <Typography variant="subtitle1" color="text.secondary">
                {userInfo?.email}
              </Typography>
            </Stack>
            <Stack spacing={1.1} textAlign="left">
              <Typography variant="body1"><strong>Name:</strong> {userInfo.name}</Typography>
              <Typography variant="body1"><strong>Email:</strong> {userInfo.email}</Typography>
              <Typography variant="body1"><strong>Username:</strong> {userInfo.preferred_username}</Typography>
              <Typography variant="body1"><strong>Realm:</strong> {userInfo.iss}</Typography>
              <Typography variant="body1">
                <strong>Roles:</strong>{" "}
                {userInfo.realm_access?.roles?.join(", ") || "-"}
              </Typography>
            </Stack>
          </Box>
        ) : (
          <Typography variant="body1" color="text.secondary" sx={{ my: 3 }}>
            User info not available.
          </Typography>
        )}
      </Paper>
    </Box>
  );
};

export default Profile;
