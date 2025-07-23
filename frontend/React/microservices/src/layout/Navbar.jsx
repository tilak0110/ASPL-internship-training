import { AppBar, Toolbar, Typography, Box, useTheme, IconButton } from "@mui/material";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";

const Navbar = () => {
  const theme = useTheme();

  return (
    <AppBar
      position="fixed"
      elevation={3}
      sx={{
        zIndex: (t) => t.zIndex.drawer + 1,
        background: theme.palette.mode === "dark"
          ? "linear-gradient(90deg, #353541e6 50%, #294b36cc 100%)"
          : "linear-gradient(90deg, rgba(163,162,66,0.87), rgba(133,67,9,0.84), rgba(9,113,44,0.83), rgba(14,14,128,0.85))"
      }}
    >
      <Toolbar sx={{ justifyContent: "space-between", minHeight: { xs: 56, sm: 64 } }}>
        <Box sx={{ display: "flex", alignItems: "center", gap: 1.5 }}>
          <img
            src="https://media.licdn.com/dms/image/v2/D4E0BAQHqRaoz3KZkSA/company-logo_200_200/company-logo_200_200/0/1712411291281?e=1755734400&v=beta&t=rYOHn2kqVpaBrdVOlzDIBqVszVLSjVVgeRCTcVjTQxE"
            alt="ASPL Logo"
            style={{
              height: 40,
              width: 40,
              borderRadius: "50%",
              boxShadow: theme.palette.mode === "dark" ? "0 2px 10px #2229" : "0 2px 8px #e7e7cc99"
            }}
          />
          <Typography
            variant="h6"
            noWrap
            component="div"
            sx={{
              fontWeight: 700,
              letterSpacing: 1,
              color: theme.palette.common.white,
              textShadow: theme.palette.mode === "dark"
                ? "1px 2px 10px #2232"
                : "0 1px 8px #d8a8584a"
            }}
          >
            ASPL
          </Typography>
        </Box>
        <Box>
          <IconButton
            edge="end"
            color="inherit"
            sx={{
              p: 0.75,
              "&:hover": {
                background: theme.palette.action.hover,
              }
            }}
          >
            <AccountCircleIcon fontSize="large" />
          </IconButton>
        </Box>
      </Toolbar>
    </AppBar>
  );
};

export default Navbar;
