import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { createAccount, clearStatus } from './accountSlice';
import {
  Button,
  TextField,
  Typography,
  CircularProgress,
  Stack,
  Paper,
  Box,
  Divider
} from '@mui/material';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const AccountForm = () => {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    mobileNumber: '',
  });

  const dispatch = useDispatch();
  const { loading, statusMsg, error } = useSelector((state) => state.account);

  useEffect(() => {
    if (statusMsg) {
      toast.success(statusMsg, { autoClose: 2000 });
      setTimeout(() => dispatch(clearStatus()), 2000);
    }
  }, [statusMsg, dispatch]);

  useEffect(() => {
    if (error) {
      toast.error(error, { autoClose: 3000 });
      setTimeout(() => dispatch(clearStatus()), 3000);
    }
  }, [error, dispatch]);

  useEffect(() => {
    return () => dispatch(clearStatus());
  }, [dispatch]);

  const handleChange = (e) => {
    setFormData((prev) => ({
      ...prev,
      [e.target.name]: e.target.value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    dispatch(clearStatus());
    if (!/^\d{10}$/.test(formData.mobileNumber)) {
      toast.error('Enter a valid 10-digit mobile number');
      return;
    }
    if (!/\S+@\S+\.\S+/.test(formData.email)) {
      toast.error('Enter a valid email address');
      return;
    }
    dispatch(createAccount(formData));
  };

  return (
    <Box
      minHeight="72vh"
      display="flex"
      alignItems="center"
      justifyContent="center"
      sx={{
        background: (theme) =>
          theme.palette.mode === 'dark' ? '#161726' : '#f4f7fb',
        px: 1,
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
              ? 'linear-gradient(120deg,#232547 30%,#1a1d31 100%)'
              : 'linear-gradient(120deg,#fff 0%,#eef4fb 100%)'
        }}
      >
        <form onSubmit={handleSubmit} autoComplete="off">
          <Stack spacing={2}>
            <Typography
              variant="h5"
              color="primary"
              fontWeight={700}
              textAlign="center"
              sx={{
                letterSpacing: '0.03em',
                mb: 1,
                textShadow: (theme) => theme.palette.mode === 'light'
                  ? '0 2px 4px #e3e6f0'
                  : '0 2px 4px #000a20'
              }}
            >
              📝 Create New Account
            </Typography>
            <Divider sx={{ mb: 1 }} />
            <TextField
              label="Full Name"
              name="name"
              value={formData.name}
              onChange={handleChange}
              required
              variant="outlined"
              fullWidth
              size="small"
              autoFocus
            />
            <TextField
              label="Email Address"
              name="email"
              value={formData.email}
              onChange={handleChange}
              required
              type="email"
              variant="outlined"
              fullWidth
              size="small"
            />
            <TextField
              label="Mobile Number"
              name="mobileNumber"
              value={formData.mobileNumber}
              onChange={handleChange}
              required
              inputProps={{ maxLength: 10, pattern: "\\d{10}" }}
              fullWidth
              variant="outlined"
              size="small"
            />
            <Button
              type="submit"
              variant="contained"
              color="primary"
              disabled={loading}
              sx={{
                py: 1.2,
                borderRadius: 2,
                fontWeight: 600,
                letterSpacing: '0.04em',
                fontSize: 16,
                boxShadow: '0 2px 6px rgba(56,135,254,.09)'
              }}
              fullWidth
            >
              {loading ? <CircularProgress color="inherit" size={22} /> : "Create Account"}
            </Button>
          </Stack>
        </form>
      </Paper>
    </Box>
  );
};

export default AccountForm;
