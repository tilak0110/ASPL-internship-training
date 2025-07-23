import { Typography, Box, useTheme } from "@mui/material";

const Header = () => {
  const theme = useTheme();
  return (
    <Box
      mb={3}
      py={3}
      px={2.5}
      sx={{
        borderRadius: 2,
        background: theme.palette.mode === 'dark'
          ? "linear-gradient(90deg, rgba(163, 162, 66, 0.18), rgba(133, 67, 9, 0.15), rgba(9, 113, 44, 0.14), rgba(14, 14, 128, 0.22))"
          : "linear-gradient(90deg, rgba(163, 162, 66, 0.19), rgba(133, 67, 9, 0.14), rgba(9, 113, 44, 0.14), rgba(14, 14, 128, 0.14))",
        boxShadow: theme.palette.mode === 'dark'
          ? "0 4px 16px 0 #2f365c36"
          : "0 4px 18px 0 #eecfa836",
        color: theme.palette.mode === 'dark'
          ? "#fff"
          : "#272712",
        textAlign: "center",
        letterSpacing: 0.8,
      }}
    >
      <Typography
        variant="h4"
        gutterBottom
        sx={{
          fontWeight: 700,
          textShadow:
            theme.palette.mode === 'dark'
              ? "1px 2px 8px #222e7c33"
              : "1px 2px 8px #f5efba63",
          fontFamily: "'Montserrat', 'Inter', 'Segoe UI', sans-serif",
        }}
      >
        Welcome to ASPL Dashboard
      </Typography>
    </Box>
  );
};

export default Header;
