import { useContext } from "react";
import { useKeycloak } from "@react-keycloak/web";
import { ColorModeContext } from "../context/ThemeContext";
import {
  useTheme,
  Typography,
  Button,
  Box,
  Stack,
  Divider,
  Paper,
} from "@mui/material";
import SettingsSuggestIcon from '@mui/icons-material/SettingsSuggest';

const Settings = () => {
  const theme = useTheme();
  const colorMode = useContext(ColorModeContext);
  const { keycloak } = useKeycloak();

  const realm = keycloak.realm || "aspl-realm";
  const baseUrl = keycloak.authServerUrl?.replace(/\/$/, "") || "http://localhost:8080";
  const referrer = "React-app";
  const referrerUri = encodeURIComponent(window.location.origin + "/settings");

  const accountUrl = `${baseUrl}/realms/${realm}/account?referrer=${referrer}&referrer_uri=${referrerUri}`;
  const passwordResetUrl = `${baseUrl}/realms/${realm}/account/account-security/signing-in?referrer=${referrer}&referrer_uri=${referrerUri}`;

  const handleEditProfile = () => {
    window.location.href = accountUrl;
  };

  const handleForgotPassword = () => {
    window.location.href = passwordResetUrl;
  };

  return (
    <Box maxWidth="540px" mx="auto" mt={{ xs: 4, md: 8 }}>
      <Paper
        elevation={5}
        sx={{
          p: { xs: 3, sm: 4 },
          borderRadius: 3,
          background: theme.palette.mode === "dark"
            ? "linear-gradient(90deg, #262d47 70%, #181e2a 100%)"
            : "linear-gradient(90deg, #fafcff 80%, #f0f5fa 100%)",
        }}
      >
        <Stack direction="row" alignItems="center" spacing={1} mb={1}>
          <SettingsSuggestIcon color="primary" sx={{ fontSize: 32 }} />
          <Typography
            variant="h5"
            fontWeight={800}
            letterSpacing={0.7}
            color="primary"
            gutterBottom
          >
            Settings
          </Typography>
        </Stack>
        <Typography variant="subtitle1" sx={{ mb: 2, color: "text.secondary" }}>
          Current Theme:
          <strong style={{ marginLeft: 8 }}>
            {theme.palette.mode.toUpperCase()}
          </strong>
        </Typography>

        <Divider sx={{ my: 3 }} />

        <Stack
          spacing={2}
          direction={{ xs: "column", sm: "row" }}
          flexWrap="wrap"
          justifyContent="center"
        >
          <Button
            variant="contained"
            color="primary"
            onClick={colorMode.toggleColorMode}
            sx={{ fontWeight: 600, minWidth: 140 }}
          >
            Toggle Theme
          </Button>

          <Button
            variant="outlined"
            color="info"
            onClick={handleEditProfile}
            sx={{ fontWeight: 600, minWidth: 144 }}
          >
            Edit Profile
          </Button>

          <Button
            variant="outlined"
            color="secondary"
            onClick={handleForgotPassword}
            sx={{ fontWeight: 600, minWidth: 170 }}
          >
            Forgot Password
          </Button>
        </Stack>
      </Paper>
    </Box>
  );
};

export default Settings;
