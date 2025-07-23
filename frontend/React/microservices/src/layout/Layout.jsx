import { Box, CssBaseline, Toolbar, useTheme } from "@mui/material";
import Navbar from "./Navbar";
import Sidebar from "./Sidebar";
import Footer from "./Footer";
import Header from "./Header";
import { Outlet } from "react-router-dom";

const Layout = () => {
  const theme = useTheme();

  return (
    <Box
      sx={{
        display: "flex",
        minHeight: "100vh",
        flexDirection: "column",
        background: theme.palette.mode === "dark"
          ? "linear-gradient(90deg, rgba(48,49,67,0.98) 60%, rgba(9,113,44,0.10) 100%)"
          : "linear-gradient(90deg, rgba(163,162,66,0.11) 10%, rgba(133,67,9,0.09) 35%, rgba(9,113,44,0.08) 55%, rgba(14,14,128,0.07) 85%, #f5f7fa 100%)",
      }}
    >
      <CssBaseline />
      <Navbar />

      <Box sx={{ display: "flex", flex: 1, minHeight: 0 }}>
        <Sidebar />

        <Box
          component="main"
          sx={{
            flexGrow: 1,
            px: { xs: 1, sm: 2, md: 3 },
            py: 3,
            minWidth: 0,
            display: "flex",
            flexDirection: "column",
          }}
        >
          <Toolbar /> {/* Adds vertical space if AppBar/NavBar is fixed */}
          <Header />
          <Box sx={{ flex: 1, minHeight: 0 }}>
            <Outlet />
          </Box>
        </Box>
      </Box>

      <Footer />
    </Box>
  );
};

export default Layout;
