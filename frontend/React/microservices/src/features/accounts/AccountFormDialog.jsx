import React, { useEffect } from 'react';
import { useDispatch } from 'react-redux';
import {
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  Button,
  IconButton,
  Typography,
  useTheme,
} from '@mui/material';
import CloseIcon from '@mui/icons-material/Close';
import AccountForm from './AccountForm';
import { clearStatus } from './accountSlice';

const AccountFormDialog = ({ open, handleClose }) => {
  const dispatch = useDispatch();
  const theme = useTheme();

  useEffect(() => {
    if (open) dispatch(clearStatus());
  }, [open, dispatch]);

  return (
    <Dialog
      open={open}
      onClose={handleClose}
      fullWidth
      maxWidth="sm"
      PaperProps={{
        sx: {
          borderRadius: 3,
          boxShadow: 9,
          bgcolor: theme.palette.mode === 'dark' ? '#20223a' : '#f8fcff'
        }
      }}
    >
      <DialogTitle
        sx={{
          fontWeight: 700,
          fontSize: { xs: 18, sm: 21 },
          pb: { xs: 1, sm: 2 },
          letterSpacing: 0.5,
          color: 'primary.main'
        }}
      >
        <Typography
          variant="inherit"
          component="span"
          sx={{ pr: 4, fontWeight: 700 }}
        >
          Create Account
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
        <AccountForm />
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

export default AccountFormDialog;
