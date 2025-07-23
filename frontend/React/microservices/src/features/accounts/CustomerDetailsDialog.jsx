import React, { useState, useEffect } from 'react';
import {
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  Button,
  IconButton,
  Stack,
  TextField,
  CircularProgress,
  useTheme,
  Typography,
} from '@mui/material';
import CloseIcon from '@mui/icons-material/Close';
import { useDispatch, useSelector } from 'react-redux';
import { fetchCustomerDetails, clearCustomer } from './accountSlice';
import { toast, ToastContainer } from 'react-toastify';
import CustomerDetailsTable from './CustomerDetailsTable';

const CustomerDetailsDialog = ({ open, handleClose }) => {
  const [mobileNumber, setMobileNumber] = useState('');
  const dispatch = useDispatch();
  const theme = useTheme();

  const { customer, customerLoading, customerError } = useSelector(state => state.account);

  useEffect(() => {
    if (open) {
      dispatch(clearCustomer());
      setMobileNumber('');
    }
  }, [open, dispatch]);

  useEffect(() => {
    if (customerError) {
      toast.error(customerError, { autoClose: 2500 });
      setTimeout(() => dispatch(clearCustomer()), 2500);
    }
  }, [customerError, dispatch]);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!/^\d{10}$/.test(mobileNumber)) {
      toast.error('Enter a valid 10-digit mobile number');
      return;
    }
    dispatch(fetchCustomerDetails({ mobileNumber, correlationId: 'frontend-demo' }));
  };

  return (
    <Dialog
      open={open}
      onClose={handleClose}
      maxWidth="md"
      fullWidth
      PaperProps={{
        sx: {
          borderRadius: 3,
          boxShadow: 9,
          bgcolor: theme.palette.mode === 'dark' ? '#21223a' : '#f8fcff',
        },
      }}
    >
      <DialogTitle
        sx={{
          fontWeight: 700,
          fontSize: { xs: 18, sm: 21 },
          pb: { xs: 1, sm: 2 },
          letterSpacing: 0.5,
          color: 'primary.main',
        }}
      >
        <Typography variant="inherit" component="span" sx={{ pr: 4 }}>
          Fetch Customer Details
        </Typography>
        <IconButton
          aria-label="close"
          onClick={handleClose}
          sx={{
            position: 'absolute',
            right: 8,
            top: 8,
            color: (theme) => theme.palette.grey[500],
            zIndex: 2,
            p: 1.2,
          }}
          size="large"
        >
          <CloseIcon fontSize="medium" />
        </IconButton>
      </DialogTitle>

      <DialogContent dividers sx={{ pt: 2, pb: 3, background: 'none' }}>
        <ToastContainer />
        <form onSubmit={handleSubmit} autoComplete="off">
          <Stack direction={{ xs: 'column', sm: 'row' }} spacing={2} alignItems="center" sx={{ mb: 3 }}>
            <TextField
              label="Mobile Number"
              value={mobileNumber}
              onChange={e => setMobileNumber(e.target.value)}
              inputProps={{ maxLength: 10, pattern: '\\d{10}' }}
              required
              autoFocus
              fullWidth
              disabled={customerLoading}
              size="small"
            />
            <Button
              type="submit"
              variant="contained"
              size="medium"
              disabled={customerLoading}
              sx={{
                minWidth: 120,
                py: 1.1,
                fontWeight: 600,
                borderRadius: 2,
                letterSpacing: 0.02,
                boxShadow: '0 2px 6px rgba(56,135,254,.09)',
                textTransform: "none",
              }}
            >
              {customerLoading ? <CircularProgress size={22} color="inherit" /> : "Fetch"}
            </Button>
          </Stack>
        </form>
        <CustomerDetailsTable customer={customer} />
      </DialogContent>
      <DialogActions
        sx={{
          px: 3,
          pb: 2,
          display: 'flex',
          justifyContent: 'flex-end',
          background: 'none',
        }}
      >
        <Button
          onClick={handleClose}
          color="secondary"
          variant="text"
          sx={{ fontWeight: 600, textTransform: 'none', letterSpacing: 0.2 }}
        >
          Close
        </Button>
      </DialogActions>
    </Dialog>
  );
};

export default CustomerDetailsDialog;
