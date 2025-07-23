import { Typography, Box, useTheme } from "@mui/material";

const Home = () => {
  const theme = useTheme();

  return (
    <Box sx={{ maxWidth: 720, mx: "auto", py: 3 }}>
      <Typography
        variant="h4"
        gutterBottom
        sx={{
          fontWeight: 700,
          color: theme.palette.primary.main,
          letterSpacing: 0.4,
          mb: 2,
          textShadow: theme.palette.mode === "dark" ? "0 1px 8px #27396b" : "0 1px 10px #dae6f1",
        }}
      >
        Dashboard Overview
      </Typography>
      <Typography
        variant="body1"
        sx={{
          fontSize: 16,
          lineHeight: 1.6,
          color: theme.palette.text.primary,
          mb: 1,
        }}
      >
        This is the main dashboard. You can view your account summary, card details, and more here.
      </Typography>
    </Box>
  );
};

export default Home;
