import { Box, Typography, useTheme } from "@mui/material";

const Footer = () => {
  const theme = useTheme();
  return (
    <Box
      component="footer"
      sx={{
        py: { xs: 2, sm: 2.5 },
        px: 2,
        mt: "auto",
        background: theme.palette.mode === "dark" ? "#212237" : "linear-gradient(90deg, #f9f9fa 60%, #e6eef8 100%)",
        boxShadow:
          theme.palette.mode === "dark"
            ? "0 -1px 10px 0 #161622"
            : "0 -1px 8px 0 #eaeaea",
        textAlign: "center",
        color: theme.palette.text.secondary,
        fontSize: 15,
        letterSpacing: 0.02,
      }}
    >
      <Typography variant="body2" sx={{ opacity: 0.84 }}>
        © {new Date().getFullYear()} TezBank. All rights reserved.
      </Typography>
    </Box>
  );
};

export default Footer;
