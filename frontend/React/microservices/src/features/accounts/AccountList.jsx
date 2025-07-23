import React from 'react';
import {
  Card,
  CardContent,
  Typography,
  Grid,
  Box,
  Divider,
  useTheme
} from '@mui/material';

const AccountList = ({ account }) => {
  const theme = useTheme();

  if (!account) return null;

  return (
    <Box mt={3} mx="auto" maxWidth={600}>
      <Card
        elevation={4}
        sx={{
          borderRadius: 3,
          backgroundColor: theme.palette.mode === 'dark' ? '#272b4d' : '#fefefe',
          boxShadow: theme.shadows[4],
        }}
      >
        <CardContent>
          <Typography
            variant="h6"
            gutterBottom
            fontWeight={700}
            color="primary"
            sx={{ letterSpacing: 0.05 }}
            textAlign="center"
          >
            Account Details
          </Typography>
          <Divider sx={{ mb: 2 }} />

          <Grid container spacing={2}>
            <Grid item xs={12} sm={6}>
              <Typography variant="body1">
                <strong>Name:</strong> {account.name}
              </Typography>
            </Grid>
            <Grid item xs={12} sm={6}>
              <Typography variant="body1">
                <strong>Email:</strong> {account.email}
              </Typography>
            </Grid>
            <Grid item xs={12} sm={6}>
              <Typography variant="body1">
                <strong>Mobile:</strong> {account.mobileNumber}
              </Typography>
            </Grid>
            <Grid item xs={12} sm={6}>
              <Typography variant="body1">
                <strong>Account No:</strong> {account.accountNumber}
              </Typography>
            </Grid>
            <Grid item xs={12} sm={6}>
              <Typography variant="body1">
                <strong>Type:</strong> {account.accountType}
              </Typography>
            </Grid>
            <Grid item xs={12} sm={6}>
              <Typography variant="body1">
                <strong>Branch:</strong> {account.branchAddress}
              </Typography>
            </Grid>
          </Grid>
        </CardContent>
      </Card>
    </Box>
  );
};

export default AccountList;
