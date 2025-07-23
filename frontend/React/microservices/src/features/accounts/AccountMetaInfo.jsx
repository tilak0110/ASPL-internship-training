import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import {
  Paper,
  Typography,
  Stack,
  Divider,
  CircularProgress,
  Alert,
  Box,
  List,
  ListItem,
  ListItemIcon,
  ListItemText,
  useTheme
} from '@mui/material';
import SupportAgentIcon from '@mui/icons-material/SupportAgent';
import EmailIcon from '@mui/icons-material/Email';
import MessageIcon from '@mui/icons-material/Message';
import { getContactInfo, getBuildVersion, getJavaVersion } from './accountSlice';

const AccountMetaInfo = () => {
  const dispatch = useDispatch();
  const theme = useTheme();
  const {
    contactInfo,
    buildVersion,
    javaVersion,
    metaLoading,
    metaError,
  } = useSelector(state => state.account);

  useEffect(() => {
    dispatch(getContactInfo());
    dispatch(getBuildVersion());
    dispatch(getJavaVersion());
  }, [dispatch]);

  return (
    <Paper
      elevation={4}
      sx={{
        p: { xs: 2, sm: 4 },
        mb: 4,
        width: { xs: '100%', sm: 600 },
        maxWidth: '98vw',
        borderRadius: 3,
        mx: 'auto',
        background: theme.palette.mode === 'dark'
          ? 'linear-gradient(120deg,#232547 30%,#181927 100%)'
          : 'linear-gradient(120deg,#fff 0%,#f5f9fc 100%)'
      }}
    >
      <Stack spacing={1}>
        <Typography
          variant="h6"
          gutterBottom
          fontWeight={700}
          color="primary"
          sx={{ display: 'flex', alignItems: 'center', mb: 1.3 }}
        >
          <MessageIcon sx={{ mr: 1, fontSize: 24 }} />
          Welcome Message
        </Typography>

        {metaLoading && (
          <Box display="flex" alignItems="center" ml={1} mb={1}>
            <CircularProgress size={20} sx={{ mr: 1 }} />
            <Typography color="text.secondary" fontSize={15}>
              Loading metadata...
            </Typography>
          </Box>
        )}
        {metaError && (
          <Alert severity="error" sx={{ mb: 2 }}>
            {metaError}
          </Alert>
        )}
        {contactInfo && (
          <Box sx={{ mb: 2 }}>
            <Typography
              variant="subtitle1"
              sx={{
                fontWeight: 500,
                mb: 2,
                color: theme.palette.mode === 'dark' ? '#b8deff' : 'primary.dark'
              }}
            >
              {contactInfo.message}
            </Typography>
            <Divider sx={{ my: 2 }} />

            <Typography variant="subtitle1" fontWeight={600} gutterBottom>
              Contact Details
            </Typography>
            <Stack direction="row" alignItems="center" spacing={2} sx={{ mb: 2 }}>
              <SupportAgentIcon color="primary" sx={{ fontSize: 22 }} />
              <Typography>
                <strong>Name:</strong> {contactInfo.contactDetails?.name}
              </Typography>
              <EmailIcon sx={{ ml: 2, color: 'grey.700', fontSize: 22 }} />
              <Typography>
                <strong>Email:</strong> {contactInfo.contactDetails?.email}
              </Typography>
            </Stack>

            <Typography variant="subtitle1" fontWeight={600} gutterBottom>
              On Call Support
            </Typography>
            <List dense>
              {contactInfo.onCallSupport?.map((phone, idx) => (
                <ListItem key={phone || idx} sx={{ py: 0.5 }}>
                  <ListItemIcon sx={{ minWidth: 36 }}>
                    <SupportAgentIcon color="secondary" sx={{ fontSize: 21 }} />
                  </ListItemIcon>
                  <ListItemText primary={phone} />
                </ListItem>
              ))}
            </List>
          </Box>
        )}

        <Divider sx={{ my: 2 }} />

        <Stack direction="row" spacing={3} sx={{ mt: 1 }}>
          <Typography>
            <strong>Build Version:</strong> {buildVersion}
          </Typography>
          <Typography>
            <strong>Java Version:</strong> {javaVersion}
          </Typography>
        </Stack>
      </Stack>
    </Paper>
  );
};

export default AccountMetaInfo;
