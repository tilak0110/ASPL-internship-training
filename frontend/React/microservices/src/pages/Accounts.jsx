import { useState } from 'react';
import { Container, Typography, Box, Stack, Button, Paper, useTheme } from '@mui/material';
import AccountMetaInfo from '../features/accounts/AccountMetaInfo';
import AccountFormDialog from '../features/accounts/AccountFormDialog';
import AccountFetchDialog from '../features/accounts/AccountFetchDialog';
import CustomerDetailsDialog from '../features/accounts/CustomerDetailsDialog';

const Accounts = () => {
  const [openForm, setOpenForm] = useState(false);
  const [openFetch, setOpenFetch] = useState(false);
  const [openCustomer, setOpenCustomer] = useState(false);
  const theme = useTheme();

  return (
    <Container maxWidth="md" sx={{ py: { xs: 3, md: 6 } }}>
      <Paper
        elevation={3}
        sx={{
          p: { xs: 2, sm: 3, md: 5 },
          background: theme.palette.mode === "dark"
            ? "linear-gradient(90deg, #232541 60%, #21223a 100%)"
            : "linear-gradient(90deg, #fafdff 60%, #eef2f9 100%)",
          borderRadius: 3,
          mb: 4,
        }}
      >
        <Typography
          variant="h4"
          textAlign="center"
          gutterBottom
          sx={{
            fontWeight: 800,
            letterSpacing: 0.5,
            mb: 2,
            color: theme.palette.primary.main,
            textShadow: theme.palette.mode === "dark"
              ? "0 1px 8px #262d88"
              : "0 1px 8px #ebeacf",
          }}
        >
          Account Management
        </Typography>
        <AccountMetaInfo />
        <Box sx={{ textAlign: 'center', my: { xs: 2, sm: 3 } }}>
          <Stack
            direction={{ xs: 'column', sm: 'row' }}
            spacing={2}
            justifyContent="center"
            sx={{ width: '100%', maxWidth: 500, mx: 'auto' }}
          >
            <Button
              variant="contained"
              color="primary"
              onClick={() => setOpenForm(true)}
              sx={{ fontWeight: 600, letterSpacing: 0.3, minWidth: 160, py: 1.2 }}
            >
              ➕ Create Account
            </Button>
            <Button
              variant="contained"
              color="secondary"
              onClick={() => setOpenFetch(true)}
              sx={{ fontWeight: 600, letterSpacing: 0.3, minWidth: 150, py: 1.2 }}
            >
              🔍 Fetch Account
            </Button>
            <Button
              variant="outlined"
              color="primary"
              onClick={() => setOpenCustomer(true)}
              sx={{ fontWeight: 600, letterSpacing: 0.3, minWidth: 190, py: 1.22 }}
            >
              👤 Fetch Customer Details
            </Button>
          </Stack>
        </Box>
      </Paper>
      <AccountFormDialog open={openForm} handleClose={() => setOpenForm(false)} />
      <AccountFetchDialog open={openFetch} handleClose={() => setOpenFetch(false)} />
      <CustomerDetailsDialog open={openCustomer} handleClose={() => setOpenCustomer(false)} />
    </Container>
  );
};

export default Accounts;
