// src/components/Sidebar.jsx
import {
  Drawer,
  List,
  ListItemButton,
  ListItemIcon,
  ListItemText,
  Toolbar,
  Box,
  useTheme,
} from "@mui/material";
import DashboardIcon from "@mui/icons-material/Dashboard";
import AccountBalanceIcon from "@mui/icons-material/AccountBalance";
import CreditCardIcon from "@mui/icons-material/CreditCard";
import SettingsIcon from "@mui/icons-material/Settings";
import PersonIcon from "@mui/icons-material/Person";
import { NavLink } from "react-router-dom";

const drawerWidth = 240;

const Sidebar = () => {
  const theme = useTheme();

  const menuItems = [
    { text: "Dashboard", icon: <DashboardIcon />, path: "/dashboard" },
    { text: "Accounts", icon: <AccountBalanceIcon />, path: "/accounts" },
    { text: "Cards", icon: <CreditCardIcon />, path: "/cards" },
    { text: "Profile", icon: <PersonIcon />, path: "/profile" },
    { text: "Settings", icon: <SettingsIcon />, path: "/settings" },
  ];

  return (
    <Drawer
      variant="permanent"
      sx={{
        width: drawerWidth,
        flexShrink: 0,
        [`& .MuiDrawer-paper`]: {
          width: drawerWidth,
          boxSizing: "border-box",
          borderRight: theme.palette.mode === "dark" ? "1.5px solid #232448" : "1.5px solid #e4e6ef",
          background: theme.palette.mode === "dark"
            ? "linear-gradient(120deg, #232549 25%, #252d3a 100%)"
            : "linear-gradient(90deg, #f8f8fc 70%, #e6eef8 100%)",
          boxShadow: "3px 0 16px -3px #1113a028"
        },
      }}
    >
      <Toolbar />
      <Box sx={{ pt: 2 }}>
        <List>
          {menuItems.map((item) => (
            <ListItemButton
              key={item.text}
              component={NavLink}
              to={item.path}
              sx={{
                my: 0.5,
                mx: 1,
                borderRadius: 2,
                px: 2,
                fontWeight: 600,
                "&.active": {
                  bgcolor: theme.palette.primary.main,
                  color: "#fff",
                  boxShadow: theme.shadows[3],
                  "& .MuiListItemIcon-root, & .MuiListItemText-primary": {
                    color: "#fff",
                  },
                },
                "&:hover": {
                  bgcolor: theme.palette.action.hover,
                  transform: "translateX(2px)",
                },
                transition: "all .15s cubic-bezier(.4,0,.2,1)",
              }}
            >
              <ListItemIcon
                sx={{
                  minWidth: 38,
                  color: "inherit",
                  fontSize: 20,
                }}
              >
                {item.icon}
              </ListItemIcon>
              <ListItemText
                primary={item.text}
                sx={{
                  "& .MuiTypography-root": { fontWeight: 600, fontSize: 16, color: "inherit" },
                }}
              />
            </ListItemButton>
          ))}
        </List>
      </Box>
    </Drawer>
  );
};

export default Sidebar;
