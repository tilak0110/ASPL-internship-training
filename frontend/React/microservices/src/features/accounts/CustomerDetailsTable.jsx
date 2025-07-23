import React from 'react';
import {
  Box,
  Typography,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableRow,
  Paper,
  TableHead,
  Divider,
  useTheme,
} from '@mui/material';

const Section = ({ icon, title, children }) => (
  <Box mb={3}>
    <Box display="flex" alignItems="center" mb={1}>
      <Typography variant="subtitle1" sx={{ fontWeight: 700, fontSize: 18 }}>
        <span style={{ fontSize: 22, marginRight: 6 }}>{icon}</span>
        {title}
      </Typography>
    </Box>
    {children}
  </Box>
);

const CustomerDetailsTable = ({ customer }) => {
  const theme = useTheme();

  if (!customer) return null;

  const { name, email, mobileNumber, accountsDto, loansDto, cardsDto } = customer;

  return (
    <Box>
      <Typography
        variant="h6"
        fontWeight={700}
        color="primary"
        gutterBottom
        sx={{ mt: 1, mb: 1, letterSpacing: 0.06 }}
      >
        👤 Customer Basic Info
      </Typography>
      <Divider sx={{ mb: 1 }} />
      <TableContainer
        component={Paper}
        elevation={2}
        sx={{
          mb: 3,
          borderRadius: 2,
          background: theme.palette.mode === 'dark' ? '#232549' : '#f6fafd',
        }}
      >
        <Table size="small">
          <TableBody>
            <TableRow>
              <TableCell sx={{ fontWeight: 600 }}>Name</TableCell>
              <TableCell>{name}</TableCell>
            </TableRow>
            <TableRow>
              <TableCell sx={{ fontWeight: 600 }}>Email</TableCell>
              <TableCell>{email}</TableCell>
            </TableRow>
            <TableRow>
              <TableCell sx={{ fontWeight: 600 }}>Mobile Number</TableCell>
              <TableCell>{mobileNumber}</TableCell>
            </TableRow>
          </TableBody>
        </Table>
      </TableContainer>

      {accountsDto && (
        <Section icon="🏦" title="Account Info">
          <TableContainer
            component={Paper}
            elevation={1}
            sx={{
              mb: 2,
              borderRadius: 2,
              background: theme.palette.mode === 'dark' ? '#262B38' : '#f7fafc',
            }}
          >
            <Table size="small">
              <TableHead>
                <TableRow sx={{ background: theme.palette.action.hover }}>
                  <TableCell sx={{ fontWeight: 600 }}>Account Number</TableCell>
                  <TableCell sx={{ fontWeight: 600 }}>Type</TableCell>
                  <TableCell sx={{ fontWeight: 600 }}>Branch Address</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                <TableRow>
                  <TableCell>{accountsDto.accountNumber}</TableCell>
                  <TableCell>{accountsDto.accountType}</TableCell>
                  <TableCell>{accountsDto.branchAddress}</TableCell>
                </TableRow>
              </TableBody>
            </Table>
          </TableContainer>
        </Section>
      )}

      {loansDto && (
        <Section icon="💸" title="Loan Info">
          <TableContainer
            component={Paper}
            elevation={1}
            sx={{
              mb: 2,
              borderRadius: 2,
              background: theme.palette.mode === 'dark' ? '#262B38' : '#f7fafc',
            }}
          >
            <Table size="small">
              <TableHead>
                <TableRow sx={{ background: theme.palette.action.hover }}>
                  <TableCell sx={{ fontWeight: 600 }}>Loan Number</TableCell>
                  <TableCell sx={{ fontWeight: 600 }}>Type</TableCell>
                  <TableCell sx={{ fontWeight: 600 }}>Total</TableCell>
                  <TableCell sx={{ fontWeight: 600 }}>Paid</TableCell>
                  <TableCell sx={{ fontWeight: 600 }}>Outstanding</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                <TableRow>
                  <TableCell>{loansDto.loanNumber}</TableCell>
                  <TableCell>{loansDto.loanType}</TableCell>
                  <TableCell>{loansDto.totalLoan}</TableCell>
                  <TableCell>{loansDto.amountPaid}</TableCell>
                  <TableCell>{loansDto.outstandingAmount}</TableCell>
                </TableRow>
              </TableBody>
            </Table>
          </TableContainer>
        </Section>
      )}

      {cardsDto && (
        <Section icon="💳" title="Card Info">
          <TableContainer
            component={Paper}
            elevation={1}
            sx={{
              mb: 2,
              borderRadius: 2,
              background: theme.palette.mode === 'dark' ? '#262B38' : '#f7fafc',
            }}
          >
            <Table size="small">
              <TableHead>
                <TableRow sx={{ background: theme.palette.action.hover }}>
                  <TableCell sx={{ fontWeight: 600 }}>Card Number</TableCell>
                  <TableCell sx={{ fontWeight: 600 }}>Type</TableCell>
                  <TableCell sx={{ fontWeight: 600 }}>Total Limit</TableCell>
                  <TableCell sx={{ fontWeight: 600 }}>Used</TableCell>
                  <TableCell sx={{ fontWeight: 600 }}>Available</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                <TableRow>
                  <TableCell>{cardsDto.cardNumber}</TableCell>
                  <TableCell>{cardsDto.cardType}</TableCell>
                  <TableCell>{cardsDto.totalLimit}</TableCell>
                  <TableCell>{cardsDto.amountUsed}</TableCell>
                  <TableCell>{cardsDto.availableAmount}</TableCell>
                </TableRow>
              </TableBody>
            </Table>
          </TableContainer>
        </Section>
      )}
    </Box>
  );
};

export default CustomerDetailsTable;
