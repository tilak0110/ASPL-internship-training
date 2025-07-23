import React, { useState, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchAccountByMobile, clearStatus } from './accountSlice';
import {
  TextField,
  Button,
  Card,
  CardContent,
  Typography,
  CircularProgress,
  Stack,
  Paper,
  Box,
  Divider
} from '@mui/material';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const AccountDetail = () => {
  const dispatch = useDispatch();
  const [mobileNumber, setMobileNumber] = useState('');
  const { account, loading, error } = useSelector((state) => state.account);

  useEffect(() => {
    if (error) {
      toast.error(error, { autoClose: 3000 });
      setTimeout(() => dispatch(clearStatus()), 3000);
    }
  }, [error, dispatch]);

  useEffect(() => {
    return () => dispatch(clearStatus());
  }, [dispatch]);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (/^\d{10}$/.test(mobileNumber.trim())) {
      dispatch(fetchAccountByMobile(mobileNumber));
    } else {
      toast.error('Please enter a valid 10-digit mobile number');
    }
  };

  return (
    <Box
      minHeight="80vh"
      display="flex"
      alignItems="center"
      justifyContent="center"
      sx={{
        background: (theme) =>
          theme.palette.mode === 'dark' ? '#191c22' : '#f7f8fa',
        px: 1
      }}
    >
      <ToastContainer />
      <Paper
        elevation={4}
        sx={{
          p: { xs: 2, sm: 4 },
          width: { xs: "100%", sm: 430 },
          maxWidth: "96vw",
          borderRadius: 3,
          background: (theme) =>
            theme.palette.mode === 'dark'
              ? 'linear-gradient(120deg,#242943 30%,#141823 100%)'
              : 'linear-gradient(120deg,#fff 30%,#eef2f6 100%)'
        }}
      >
        <Stack spacing={2}>
          <Typography
            variant="h5"
            fontWeight={700}
            color="primary"
            textAlign="center"
            gutterBottom
            sx={{
              letterSpacing: "0.03em",
              textShadow: (theme) =>
                theme.palette.mode === 'light'
                  ? '0 2px 4px #e3e6f0'
                  : '0 2px 4px #000a20'
            }}
          >
            🔎 Account Lookup
          </Typography>
          <Divider sx={{ mb: 1 }} />
          <form onSubmit={handleSubmit} autoComplete="off">
            <Stack direction="row" spacing={1.5} alignItems="center">
              <TextField
                label="10-digit Mobile Number"
                variant="outlined"
                value={mobileNumber}
                onChange={e => setMobileNumber(e.target.value)}
                inputProps={{ maxLength: 10, pattern: '\\d{10}' }}
                required
                fullWidth
                autoFocus
                disabled={loading}
                size="small"
              />
              <Button
                type="submit"
                variant="contained"
                color="primary"
                disabled={loading}
                size="medium"
                sx={{
                  minWidth: 110,
                  textTransform: "none",
                  fontWeight: 600,
                  borderRadius: 2,
                  boxShadow: '0 2px 6px rgba(56,135,254,.09)'
                }}
              >
                {loading ? <CircularProgress size={22} color="inherit" /> : "Fetch"}
              </Button>
            </Stack>
          </form>

          {account && account.accountNumber && (
            <Card
              sx={{
                mt: 3,
                borderRadius: 2,
                background: (theme) =>
                  theme.palette.mode === 'dark'
                    ? '#252637'
                    : '#f7fbfe'
              }}
              elevation={0}
            >
              <CardContent>
                <Typography
                  variant="subtitle1"
                  color="secondary"
                  fontWeight={600}
                  pb={1}
                  textAlign="center"
                >
                  Account Information
                </Typography>
                <Stack spacing={1.5} mt={0.5}>
                  <Typography>
                    <b>Name:</b> {account.name}
                  </Typography>
                  <Typography>
                    <b>Email:</b> {account.email}
                  </Typography>
                  <Typography>
                    <b>Mobile:</b> {account.mobileNumber}
                  </Typography>
                  <Typography>
                    <b>Account Number:</b> {account.accountNumber}
                  </Typography>
                  <Typography>
                    <b>Account Type:</b> {account.accountType}
                  </Typography>
                  <Typography>
                    <b>Branch:</b> {account.branchAddress}
                  </Typography>
                </Stack>
              </CardContent>
            </Card>
          )}
        </Stack>
      </Paper>
    </Box>
  );
};

export default AccountDetail;
