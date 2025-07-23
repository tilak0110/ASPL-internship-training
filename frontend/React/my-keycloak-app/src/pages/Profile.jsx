import { useKeycloak } from "@react-keycloak/web";
import {
  Card,
  CardContent,
  Typography,
  Box,
  Avatar,
  Chip,
  Divider,
  Stack,
} from "@mui/material";
import { deepPurple } from "@mui/material/colors";

export default function Profile() {
  const { keycloak } = useKeycloak();
  const token = keycloak?.tokenParsed;

  if (!token) return <Typography>Loading profile...</Typography>;

  const {
    name,
    preferred_username,
    email,
    realm_access,
    given_name,
    family_name,
  } = token;

  return (
    <Box sx={{ display: "flex", justifyContent: "center", mt: 4 }}>
      <Card sx={{ width: 400, boxShadow: 4, borderRadius: 3 }}>
        <CardContent>
          <Box sx={{ display: "flex", justifyContent: "center", mb: 2 }}>
            <Avatar sx={{ bgcolor: deepPurple[500], width: 64, height: 64 }}>
              {name?.charAt(0)}
            </Avatar>
          </Box>

          <Typography variant="h5" align="center" gutterBottom>
            {name}
          </Typography>
          <Typography variant="body2" align="center" color="text.secondary">
            @{preferred_username}
          </Typography>

          <Divider sx={{ my: 2 }} />

          <Stack spacing={1}>
            <Typography variant="body2">
              <strong>Email:</strong> {email}
            </Typography>

            <Typography variant="body2">
              <strong>First Name:</strong> {given_name}
            </Typography>

            <Typography variant="body2">
              <strong>Last Name:</strong> {family_name}
            </Typography>

            <Box>
              <Typography variant="body2" sx={{ mb: 0.5 }}>
                <strong>Roles:</strong>
              </Typography>
              <Box sx={{ display: "flex", flexWrap: "wrap", gap: 1 }}>
                {realm_access?.roles?.map((role) => (
                  <Chip
                    key={role}
                    label={role}
                    color="primary"
                    size="small"
                  />
                ))}
              </Box>
            </Box>
          </Stack>
        </CardContent>
      </Card>
    </Box>
  );
}
